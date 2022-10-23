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
import com.bankmisr.irrigationsystem.dto.CropDto;
import com.bankmisr.irrigationsystem.model.Crop;
import com.bankmisr.irrigationsystem.service.CropService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "crops")
public class CropController {
	@Autowired
	private CropService cropService;

	@PostMapping("/crop")
	public Crop addCrop(@RequestBody CropDto cropDto) throws Exception {
		return cropService.addCrop(cropDto);
	}

	@GetMapping("/crops")
	public List<Crop> getAllCrops() {
		return cropService.getAllCrops();
	}

	@GetMapping("/crop/{id}")
	public Crop getLandById(@PathVariable int id) throws Throwable {
		return cropService.findCropById(id);
	}

	@PutMapping("/crop/{id}")
	public Crop updateLand(@RequestBody CropDto cropDto, @PathVariable int id) {
		return cropService.updateCrop(cropDto, id);

	}

}
