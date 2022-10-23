package com.bankmisr.irrigationsystem.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "plot_irrigation_slots")
//@IdClass(PlotSlotKey.class)
public class PlotIrrigationSlots {
	@EmbeddedId
	PlotSlotKey id;
	@JsonIgnore
	@ManyToOne
	@MapsId("plotId")
	@JoinColumn(name = "plot_id")
	private Plot plot;
	@JsonIgnore
	@ManyToOne
	@MapsId("slotId")
	@JoinColumn(name = "slot_id")
	private IrrigationSlot irrigationSlot;
	@Column(name = "END_WATERING_DATE")
	private java.sql.Timestamp endWateringdate;

	public PlotSlotKey getId() {
		return id;
	}

	public void setId(PlotSlotKey id) {
		this.id = id;
	}

	public Plot getPlot() {
		return plot;
	}

	public PlotIrrigationSlots()
	{
		
	}
	public PlotIrrigationSlots(Plot plot, IrrigationSlot irrigationSlot, Timestamp endWateringdate) {
		this.id = new PlotSlotKey(plot.getId(), irrigationSlot.getId());
		this.plot = plot;
		this.irrigationSlot = irrigationSlot;
		this.endWateringdate = endWateringdate;
	}

	public void setPlot(Plot plot) {
		this.plot = plot;
	}

	public IrrigationSlot getIrrigationSlot() {
		return irrigationSlot;
	}

	public void setIrrigationSlot(IrrigationSlot irrigationSlot) {
		this.irrigationSlot = irrigationSlot;
	}

	public java.sql.Timestamp getEndWateringdate() {
		return endWateringdate;
	}

	public void setEndWateringdate(java.sql.Timestamp endWateringdate) {
		this.endWateringdate = endWateringdate;
	}

}
