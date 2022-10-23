package com.bankmisr.irrigationsystem.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Id;

@Entity
@Table(name = "crop")
public class Crop {
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "CROP_NAME",unique = true)
	private String cropName;
	@Column(name = "WATER_AMOUNT_PER_METER")
	private int waterAmountPerMeter;

	@OneToMany(mappedBy = "crop", fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	@JsonIgnore
	private List<Plot> plots = new ArrayList<>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

	public List<Plot> getPlots() {
		return plots;
	}

	public void setPlots(List<Plot> plots) {
		this.plots = plots;
	}
	
	

}
