package com.bankmisr.irrigationsystem.dto;

public class CropDto {
	private String cropName;
	private int waterAmountPerMeter;

	public String getCropName() {
		return cropName;
	}

	public void setCropName(String cropName) {
		this.cropName = cropName;
	}

	public int getWaterAmountPerMeter() {
		return waterAmountPerMeter;
	}

	public void setWaterAmountPerMeter(int waterAmountPerMeter) {
		this.waterAmountPerMeter = waterAmountPerMeter;
	}

}
