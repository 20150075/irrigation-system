package com.bankmisr.irrigationsystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bankmisr.irrigationsystem.model.PlotIrrigationSlots;
import com.bankmisr.irrigationsystem.model.PlotSlotKey;

public  interface PlotIrrigrationSlotsRepository extends JpaRepository<PlotIrrigationSlots, PlotSlotKey>{
	


}
