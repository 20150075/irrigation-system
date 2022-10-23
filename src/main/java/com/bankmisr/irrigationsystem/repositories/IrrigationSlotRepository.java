package com.bankmisr.irrigationsystem.repositories;

import java.sql.Timestamp;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bankmisr.irrigationsystem.model.IrrigationSlot;

public interface IrrigationSlotRepository extends JpaRepository<IrrigationSlot, Integer> {

	IrrigationSlot findByBeginWateringdate(Timestamp beginWateringdate);

	IrrigationSlot findFirstByBeginWateringdate(Timestamp beginWateringdate);
	

}
