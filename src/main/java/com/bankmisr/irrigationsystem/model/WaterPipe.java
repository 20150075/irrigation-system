package com.bankmisr.irrigationsystem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "water_pipe")
public class WaterPipe {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="WATER_CAPACITY_PER_MIN")
	private int waterCapacityPerMin;
	@OneToOne(mappedBy="pipe")
	@JsonIgnore
	private Plot plot;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getWaterCapacityPerMin() {
		return waterCapacityPerMin;
	}
	public void setWaterCapacityPerMin(int waterCapacityPerMin) {
		this.waterCapacityPerMin = waterCapacityPerMin;
	}
	public Plot getPlot() {
		return plot;
	}
	public void setPlot(Plot plot) {
		this.plot = plot;
	}
	
	
	

}
