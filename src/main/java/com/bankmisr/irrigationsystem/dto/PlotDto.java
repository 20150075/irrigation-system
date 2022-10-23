package com.bankmisr.irrigationsystem.dto;

public class PlotDto {

	private int length;
	private int width;
	private int soilTemperature;
	private String cropName;
	private int landId;
	private int pipeId;

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getSoilTemperature() {
		return soilTemperature;
	}

	public void setSoilTemperature(int soilTemperature) {
		this.soilTemperature = soilTemperature;
	}

	public String getCropName() {
		return cropName;
	}

	public void setCropName(String cropName) {
		this.cropName = cropName;
	}

	public int getLandId() {
		return landId;
	}

	public void setLandId(int landId) {
		this.landId = landId;
	}

	public int getPipeId() {
		return pipeId;
	}

	public void setPipeId(int pipeId) {
		this.pipeId = pipeId;
	}

}
