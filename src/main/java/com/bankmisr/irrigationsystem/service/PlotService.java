package com.bankmisr.irrigationsystem.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bankmisr.irrigationsystem.dto.PlotDto;
import com.bankmisr.irrigationsystem.dto.UpdatedPlotDto;
import com.bankmisr.irrigationsystem.exception.PipeNotFoundException;
import com.bankmisr.irrigationsystem.exception.PlotNotFoundException;
import com.bankmisr.irrigationsystem.model.Crop;
import com.bankmisr.irrigationsystem.model.IrrigationSlot;
import com.bankmisr.irrigationsystem.model.Land;
import com.bankmisr.irrigationsystem.model.Plot;
import com.bankmisr.irrigationsystem.model.PlotIrrigationSlots;
import com.bankmisr.irrigationsystem.model.WaterPipe;
import com.bankmisr.irrigationsystem.repositories.PlotsRepository;
import com.bankmisr.irrigationsystem.utils.Utils;
import com.bankmisr.irrigationsystem.validation.PlotAreaValidation;

@Service
public class PlotService {

	@Autowired
	private PlotsRepository plotRepository;
	@Autowired
	private LandService landService;
	@Autowired
	private CropService cropService;
	@Autowired
	private PipeService pipeService;
	@Autowired
	private IrrigationSlotService irrigationSlotService;
	@Autowired
	private PlotIrrigationSlotsService plotIrrigationSlotsService;
	@Value("${dryTemp}")
	private int soilTemp;
	@Value("${normalTemp}")
	private int normalTemp;

	public ArrayList<Plot> getAllPlots() {
		return (ArrayList<Plot>) plotRepository.findAll();
	}

	public Plot addNewPlot(PlotDto plotDto) throws Exception {

		Plot plot = new Plot();
		PlotAreaValidation plotAreaValidation = new PlotAreaValidation();
		plotAreaValidation.validatePlot(plotDto);
		Crop crop = cropService.getCropByName(plotDto.getCropName());
		plot.setCrop(crop);
		Land land = landService.findLandById(plotDto.getLandId());
		plot.setLand(land);
		WaterPipe pipe = pipeService.getLandById(plotDto.getPipeId())
				.orElseThrow(() -> new PipeNotFoundException(plotDto.getPipeId()));
		plot.setPipe(pipe);
		plot.setLand(land);
		plot.setLength(plotDto.getLength());
		plot.setSoilTemperature(plotDto.getSoilTemperature());
		plot.setWateringIndicator("N");
		plot.setWidth(plotDto.getWidth());

		return plotRepository.save(plot);

	}

	public ArrayList<Plot> getNeddedWateringPlots() {
		return (ArrayList<Plot>) plotRepository.getPlotsNeedWater(soilTemp);
	}

	public Plot findPlotById(int id) {
		return plotRepository.findById(id).orElseThrow(() -> new PlotNotFoundException(id));
	}

	public int updatePlot(UpdatedPlotDto updatedPlotDto, int id) {
		findPlotById(id);
		Crop updatedCrop = cropService.getCropByName(updatedPlotDto.getCropName());
		return plotRepository.updatePlot(updatedCrop.getId(), updatedPlotDto.getSoilTemp(), id);
	}

	/**
	 * this function will update soil temp only, but not update Crop fk for this
	 * plot, so i create another function to update plot updateble properties using
	 * query
	 **/
	public Plot updatePlot_Old(UpdatedPlotDto updatedPlot, int id) {
		Crop updatedCrop = cropService.getCropByName(updatedPlot.getCropName());
		return plotRepository.findById(id).map(plot -> {
			System.out.println("updatedCrop :" + updatedCrop.getId());
			plot.setSoilTemperature(updatedPlot.getSoilTemp());
			plot.setCrop(updatedCrop);
			return plotRepository.save(plot);
		}).orElseGet(() -> {
			Plot newPlot = new Plot();
			newPlot.setId(id);
			return plotRepository.save(newPlot);
		});
	}

	public void deletePlot(int id) {
		plotRepository.deleteById(id);
	}

	public void configurePlot(Plot plot) throws InterruptedException {
		processNeededWateringPlots(plot);

	}

	public void changPlotWateringStatus(int id, String status) {

		plotRepository.updatePlotWateringStatus(status, id);
	}

	@Async
	@Transactional(rollbackFor = RuntimeException.class)
	public void processNeededWateringPlots(Plot plot) throws InterruptedException {

		this.changPlotWateringStatus(plot.getId(), "Y");
		long start = System.currentTimeMillis();
		long end = start + this.getPlotneedWateringTime(plot);
		System.out.println("Plot with id [" + plot.getId() + "] starts.");
		try {
			long now = System.currentTimeMillis();
			Timestamp beginWateringdate = new Timestamp(now);
			IrrigationSlot irrigationSlot = new IrrigationSlot();
			irrigationSlot.setBeginWateringdate(beginWateringdate);
			Thread.currentThread().sleep(end - start);
			Timestamp endWateringdate = new Timestamp(end);
			IrrigationSlot irrigationSlotObj = irrigationSlotService.addIrrigationSlot(irrigationSlot);
			PlotIrrigationSlots plotIrrigationSlots = new PlotIrrigationSlots(plot, irrigationSlotObj, endWateringdate);
			plotIrrigationSlotsService.addPlotIrrigrationSlots(plotIrrigationSlots);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
			plotRepository.updateWateredPlotTemp("N", plot.getSoilTemperature(), plot.getId());
			System.out.println("Plot with id [" + plot.getId() + "] interrputed");
			throw e;
		} catch (Exception ex) {

			Thread.currentThread().interrupt();
			plotRepository.updateWateredPlotTemp("N", plot.getSoilTemperature(), plot.getId());
			System.out.println("Failed to process Plot with id [" + plot.getId() + "] .");
			throw ex;
		}
		/*
		 * while (System.currentTimeMillis() <= end) {
		 * System.out.println("Plot with id ["+lp.getId()+"] waiting");
		 * 
		 * 
		 * //this.changPlotWateringStatus(lp.getId(),"N"); }
		 */
		Thread.currentThread().interrupt();
		plotRepository.updateWateredPlotTemp("N", normalTemp, plot.getId());
		System.out.println("Plot with id [" + plot.getId() + "] finished");

		// }

	}

	public int getPlotneedWateringTime(Plot plot) {
		int plotArea = Utils.calculateArea(plot.getLength(), plot.getWidth());
		System.out.println("Plot area with id [" + plot.getId() + "] " + plotArea);
		Crop crop = cropService.findCropById(plot.getCrop().getId());
		int TotalNeededWaterAmount = 0;
		int neededMilliSecondsTime = 0;
		int totalNeededMilliSecondsTime = 0;
		if (crop != null) {
			int waterAmountPerWater = crop.getWaterAmountPerMeter();
			System.out.println("Plot area with id [" + plot.getId() + "] waterAmountPerWater :" + waterAmountPerWater);
			TotalNeededWaterAmount = plotArea / waterAmountPerWater;
		}
		Integer pipeCapacityPerMin = plot.getPipe().getWaterCapacityPerMin();
		if (pipeCapacityPerMin != null) {
			neededMilliSecondsTime = pipeCapacityPerMin * 60000;
			System.out.println(
					"Plot area with id [" + plot.getId() + "] neededMilliSecondsTime :" + neededMilliSecondsTime);

			totalNeededMilliSecondsTime = neededMilliSecondsTime * plotArea;
			System.out.println("Plot area with id [" + plot.getId() + "] totalNeededMilliSecondsTime :"
					+ totalNeededMilliSecondsTime);

		}
		return totalNeededMilliSecondsTime;

	}

	public List<Plot> getLandPlots(int landId) {
		return plotRepository.getLandPlots(landId);
	}
}
