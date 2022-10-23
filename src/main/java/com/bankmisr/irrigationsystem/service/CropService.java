package com.bankmisr.irrigationsystem.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bankmisr.irrigationsystem.dto.CropDto;
import com.bankmisr.irrigationsystem.exception.CropNotFoundException;
import com.bankmisr.irrigationsystem.model.Crop;
import com.bankmisr.irrigationsystem.repositories.CropsRepository;

@Service
public class CropService {

	@Autowired
	private CropsRepository cropsRepository;

	public Crop getCropByName(String cropName) {
		return cropsRepository.findByCropName(cropName).orElseThrow(() -> new CropNotFoundException(cropName));
	}

	public Crop findCropById(int id) {
		return cropsRepository.findById(id).orElseThrow(() -> new CropNotFoundException(id));
	}

	public Crop addCrop(CropDto cropDto) {
		Crop crop = new Crop();
		crop.setCropName(cropDto.getCropName());
		crop.setWaterAmountPerMeter(cropDto.getWaterAmountPerMeter());
		return cropsRepository.save(crop);
	}

	public List<Crop> getAllCrops() {
		return cropsRepository.findAll();
	}

	public Crop updateCrop(CropDto cropDto, int id) {
		Crop crop = findCropById(id);
		crop.setCropName(cropDto.getCropName());
		crop.setWaterAmountPerMeter(cropDto.getWaterAmountPerMeter());
		return cropsRepository.save(crop);
	}

}
