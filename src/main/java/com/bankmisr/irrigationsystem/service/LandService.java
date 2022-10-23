package com.bankmisr.irrigationsystem.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bankmisr.irrigationsystem.dto.LandDto;
import com.bankmisr.irrigationsystem.model.Land;
import com.bankmisr.irrigationsystem.repositories.LandRepository;
import com.bankmisr.irrigationsystem.exception.LandNotFoundException;

@Service
public class LandService {
	@Autowired
	private LandRepository landRepository;

	public Land findLandById(int id) {
		return landRepository.findById(id).orElseThrow(() -> new LandNotFoundException(id));
	}

	public Land addLand(LandDto landDto) {
		Land land = new Land();
		land.setLandName(landDto.getLandName());
		land.setLocation(landDto.getLocation());
		land.setOwnerName(landDto.getOwnerName());
		land.setTotalArea(landDto.getTotalArea());
		return landRepository.save(land);
	}

	public List<Land> getAllLands() {
		return landRepository.findAll();
	}

	public Land updateLand(LandDto landDto, int id) {
		Land land = findLandById(id);
		land.setLandName(landDto.getLandName());
		land.setLocation(landDto.getLocation());
		land.setOwnerName(landDto.getOwnerName());
		land.setTotalArea(landDto.getTotalArea());
		return landRepository.save(land);
	}

	public int getLandArea(int id) {
		return landRepository.getLandArea(id);
	}
}
