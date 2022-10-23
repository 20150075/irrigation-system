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
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Land")
public class Land {
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "LOCATION")
	private String location;
	@Column(name = "LAND_NAME")
	private String landName;
	@Column(name = "OWNER_NAME")
	private String ownerName;
	@Column(name = "TOTAL_AREA")
	private int totalArea;

	@OneToMany(mappedBy = "land", fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	// @JsonManagedReference
	@JsonIgnore
	private List<Plot> plots = new ArrayList<>();

	public Land() {
	}

	public Land(int id, String location, String landName, String ownerName) {

		this.id = id;
		this.location = location;
		this.landName = landName;
		this.ownerName = ownerName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

	public List<Plot> getPlots() {
		return plots;
	}

	public void setPlots(List<Plot> plots) {
		this.plots = plots;
	}

}
