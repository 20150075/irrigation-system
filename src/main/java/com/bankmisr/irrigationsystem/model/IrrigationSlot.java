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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
@Table(name = "irrigation_slot")
public class IrrigationSlot {
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "BEGIN_WATERING_DATE")
	private java.sql.Timestamp beginWateringdate;
	@OneToMany(mappedBy = "irrigationSlot", fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	//@JsonIgnore
	//@JsonBackReference
	private List<PlotIrrigationSlots> plotIrrigationSlots = new ArrayList<>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public java.sql.Timestamp getBeginWateringdate() {
		return beginWateringdate;
	}

	public void setBeginWateringdate(java.sql.Timestamp beginWateringdate) {
		this.beginWateringdate = beginWateringdate;
	}
	public List<PlotIrrigationSlots> getPlotIrrigationSlots() {
		return plotIrrigationSlots;
	}

	public void setPlotIrrigationSlots(List<PlotIrrigationSlots> plotIrrigationSlots) {
		this.plotIrrigationSlots = plotIrrigationSlots;
	}

}
