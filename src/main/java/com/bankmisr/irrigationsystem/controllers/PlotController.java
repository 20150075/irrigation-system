package com.bankmisr.irrigationsystem.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bankmisr.irrigationsystem.dto.UpdatedPlotDto;
import com.bankmisr.irrigationsystem.model.Plot;
import com.bankmisr.irrigationsystem.dto.PlotDto;
import com.bankmisr.irrigationsystem.service.PlotService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "plots")
public class PlotController {

	@Autowired
	private PlotService plotService;

	@GetMapping("/plots")
	public List<Plot> getAllPlots() {
		return plotService.getAllPlots();
	}

	@GetMapping("/plot/{id}")
	public Plot getPlotById(@PathVariable int id) throws Throwable {
		return (Plot) plotService.findPlotById(id);
	}

	@PostMapping("/plot")
	public Plot addPlot(@RequestBody PlotDto plotDto) throws Exception {
		return (Plot) plotService.addNewPlot(plotDto);
	}

	@PutMapping("/plot/{id}")
	public String updatePlot(@RequestBody UpdatedPlotDto updatedPlot, @PathVariable int id) {

		int updateStatus = plotService.updatePlot(updatedPlot, id);
		if (updateStatus == 1) {
			return "Plot with id  [" + id + "] has been updated successfully";
		} else
			return "Failed to update Plot with id  [" + id + "] ";

	}

	@DeleteMapping("/plot/{id}")
	public void deletePlot(@PathVariable int id) {

		plotService.deletePlot(id);

	}

}
