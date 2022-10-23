package com.bankmisr.irrigationsystem.dto;

public class LandDto {

	private String location;
	private String landName;
	private String ownerName;
	private int totalArea;

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getLandName() {
		return landName;
	}

	public void setLandName(String landName) {
		this.landName = landName;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public int getTotalArea() {
		return totalArea;
	}

	public void setTotalArea(int totalArea) {
		this.totalArea = totalArea;
	}

}
