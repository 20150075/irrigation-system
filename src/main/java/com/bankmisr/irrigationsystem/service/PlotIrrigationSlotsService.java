package com.bankmisr.irrigationsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankmisr.irrigationsystem.model.PlotIrrigationSlots;
import com.bankmisr.irrigationsystem.repositories.PlotIrrigrationSlotsRepository;

@Service
public class PlotIrrigationSlotsService {
	@Autowired
	private PlotIrrigrationSlotsRepository plotIrrigrationSlotsRepository;

	public PlotIrrigationSlots addPlotIrrigrationSlots(PlotIrrigationSlots plotIrrigationSlots) {
		return plotIrrigrationSlotsRepository.save(plotIrrigationSlots);
	}

}
