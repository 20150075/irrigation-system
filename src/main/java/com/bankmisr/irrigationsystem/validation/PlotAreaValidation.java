package com.bankmisr.irrigationsystem.validation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bankmisr.irrigationsystem.dto.PlotDto;
import com.bankmisr.irrigationsystem.exception.Errors;
import com.bankmisr.irrigationsystem.exception.IrrigationSystemException;
import com.bankmisr.irrigationsystem.model.Plot;
import com.bankmisr.irrigationsystem.service.LandService;
import com.bankmisr.irrigationsystem.service.PlotService;
import com.bankmisr.irrigationsystem.utils.Utils;

@Component
public class PlotAreaValidation {

	@Autowired
	private LandService landService;

	@Autowired
	private PlotService plotService;

	public void validatePlotLengthAndWidth(PlotDto plotDto) throws IrrigationSystemException {
		if (plotDto.getLength() < plotDto.getWidth()) {
			IrrigationSystemException irrigationSystemException = new IrrigationSystemException();
			irrigationSystemException.setErrorCode(Errors.LENGTH_ERROR.getErrorCode());
			irrigationSystemException.setMessage(Errors.LENGTH_ERROR.getErrorMessage());
			throw irrigationSystemException;
		}
	}

	public void validatePlotArea(PlotDto plotDto) throws IrrigationSystemException {

		int landFreeSpace = getLandFreeSpace(plotDto.getLandId());
		int newPlotarea = Utils.calculateArea(plotDto.getLength(), plotDto.getWidth());
		if (newPlotarea > landFreeSpace) {
			IrrigationSystemException irrigationSystemException = new IrrigationSystemException();
			irrigationSystemException.setErrorCode(Errors.AREA_ERROR.getErrorCode());
			irrigationSystemException.setMessage(Errors.AREA_ERROR.getErrorMessage());
			throw irrigationSystemException;
		}
	}

	public int getLandFreeSpace(int landId) {
		int landArea = 0;
		try {
			landArea = landService.getLandArea(landId);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		int usedSpace = 0;
		List<Plot> landplots = plotService.getLandPlots(landId);
		for (Plot pl : landplots) {
			usedSpace += Utils.calculateArea(pl.getLength(), pl.getWidth());
		}
		System.out.println("Land area : " + landArea);
		System.out.println("free space : " + (usedSpace - landArea));
		return usedSpace - landArea;

	}

	public void validatePlot(PlotDto plotDto) throws IrrigationSystemException {
		validatePlotLengthAndWidth(plotDto);
		validatePlotArea(plotDto);

	}
}
