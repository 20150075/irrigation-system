package com.bankmisr.irrigationsystem.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "land_plots")
public class Plot {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int length;
	private int width;
	@Column(name = "SOIL_TEMP")
	private int soilTemperature;
	@Column(name = "WATERING_IND")
	private String wateringIndicator;
	@ManyToOne
	@JoinColumn(name = "crop_id", referencedColumnName = "id")
	@JsonManagedReference
	private Crop crop;	
	@ManyToOne
	@JoinColumn(name = "land_id", referencedColumnName = "id")
	@JsonManagedReference
	private Land land;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "pipe_id", referencedColumnName = "id",unique=true)
	@JsonManagedReference
	private WaterPipe pipe;

	@OneToMany(mappedBy = "plot"/*, fetch = FetchType.LAZY*/, cascade = { CascadeType.ALL })
	//@JsonBackReference
	private List<PlotIrrigationSlots> plotIrrigationSlots = new ArrayList<>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

	public Crop getCrop() {
		return crop;
	}

	public void setCrop(Crop crop) {
		this.crop = crop;
	}

	public Land getLand() {
		return land;
	}

	public void setLand(Land land) {
		this.land = land;
	}

	public List<PlotIrrigationSlots> getPlotIrrigationSlots() {
		return plotIrrigationSlots;
	}

	public void setPlotIrrigationSlots(List<PlotIrrigationSlots> plotIrrigationSlots) {
		this.plotIrrigationSlots = plotIrrigationSlots;
	}

	public int getSoilTemperature() {
		return soilTemperature;
	}

	public void setSoilTemperature(int soilTemperature) {
		this.soilTemperature = soilTemperature;
	}

	public WaterPipe getPipe() {
		return pipe;
	}

	public void setPipe(WaterPipe pipe) {
		this.pipe = pipe;
	}

	public String getWateringIndicator() {
		return wateringIndicator;
	}

	public void setWateringIndicator(String wateringIndicator) {
		this.wateringIndicator = wateringIndicator;
	}

}
