package com.bankmisr.irrigationsystem.service;

import java.util.List;
import java.util.Optional;
import com.bankmisr.irrigationsystem.exception.PipeNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bankmisr.irrigationsystem.dto.PipeDto;
import com.bankmisr.irrigationsystem.model.WaterPipe;
import com.bankmisr.irrigationsystem.repositories.PipeRepository;

@Service
public class PipeService {
	@Autowired
	private PipeRepository pipeRepository;

	public Optional<WaterPipe> getLandById(int id) {
		return pipeRepository.findById(id);
	}

	public WaterPipe addPipe(PipeDto pipe) {
		WaterPipe waterPipe = new WaterPipe();
		waterPipe.setWaterCapacityPerMin(pipe.getWaterCapacityPerMin());
		return pipeRepository.save(waterPipe);
	}

	public List<WaterPipe> getAllPipes() {
		return pipeRepository.findAll();
	}

	public WaterPipe findPipeById(int id) {
		return pipeRepository.findById(id).orElseThrow(() -> new PipeNotFoundException(id));
	}

	public WaterPipe updatePipe(PipeDto pipeDto, int id) {
		WaterPipe waterPipe = findPipeById(id);
		waterPipe.setWaterCapacityPerMin(pipeDto.getWaterCapacityPerMin());
		return pipeRepository.save(waterPipe);
	}

}
