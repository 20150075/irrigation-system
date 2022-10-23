package com.bankmisr.irrigationsystem.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bankmisr.irrigationsystem.dto.LandDto;
import com.bankmisr.irrigationsystem.model.Land;
import com.bankmisr.irrigationsystem.service.LandService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "lands")
public class LandController {
	@Autowired
	private LandService landService;

	@PostMapping("/land")
	public Land addLand(@RequestBody LandDto landDto) throws Exception {
		return landService.addLand(landDto);
	}

	@GetMapping("/lands")
	public List<Land> getAllLands() {
		return landService.getAllLands();
	}

	@GetMapping("/land/{id}")
	public Land getLandById(@PathVariable int id) throws Throwable {
		return landService.findLandById(id);
	}

	@PutMapping("/land/{id}")
	public Land updateLand(@RequestBody LandDto landDto, @PathVariable int id) {
		return landService.updateLand(landDto, id);

	}

}
