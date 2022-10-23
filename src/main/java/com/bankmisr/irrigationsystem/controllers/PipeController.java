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
import com.bankmisr.irrigationsystem.dto.PipeDto;
import com.bankmisr.irrigationsystem.model.WaterPipe;
import com.bankmisr.irrigationsystem.service.PipeService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "pipes")
public class PipeController {

	@Autowired
	private PipeService pipeService;

	@PostMapping("/pipe")
	public WaterPipe addPipe(@RequestBody PipeDto waterPipeDto) throws Exception {
		return pipeService.addPipe(waterPipeDto);
	}

	@GetMapping("/pipes")
	public List<WaterPipe> getAllPipes() {
		return pipeService.getAllPipes();
	}

	@GetMapping("/pipe/{id}")
	public WaterPipe getPipeById(@PathVariable int id) throws Throwable {
		return pipeService.findPipeById(id);
	}

	@PutMapping("/pipe/{id}")
	public WaterPipe updatePipe(@RequestBody PipeDto pipeDto, @PathVariable int id) {

		return pipeService.updatePipe(pipeDto, id);

	}

}
