package com.bankmisr.irrigationsystem.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class PlotSlotKey implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name = "plot_id")
	int plotId;

	@Column(name = "slot_id")
	int slotId;

	public PlotSlotKey() {

	}

	public PlotSlotKey(int plotId, int slotId) {
		this.plotId = plotId;
		this.slotId = slotId;
	}

}
