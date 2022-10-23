package com.bankmisr.irrigationsystem.listener;

import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.retry.annotation.Retryable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import com.bankmisr.irrigationsystem.model.Plot;
import com.bankmisr.irrigationsystem.service.PlotService;

@Component
public class PlotsListener {
	private Logger logger = LoggerFactory.getLogger(PlotsListener.class);
	@Autowired
	private PlotService plotService;
	private ArrayList<Plot> neededWateringPlots = new ArrayList<>();

	public PlotsListener() {
	}

	@Scheduled(initialDelayString = "${schedularInitialDelay}", fixedRateString = "${schedularFixedRate}")
	@Retryable(value = Exception.class, maxAttemptsExpression = "${retryAttempts}")
	public void run() throws InterruptedException {
		neededWateringPlots.clear();
		neededWateringPlots = plotService.getNeddedWateringPlots();

		if (neededWateringPlots.size() > 0) {
			neededWateringPlots.forEach(lp -> {
				try {
					plotService.processNeededWateringPlots(lp);
				} catch (InterruptedException e) {
					e.printStackTrace();
					logger.error("Failed to watering Plot with id : " + lp.getId());
				}
			});
		}
	}
}
