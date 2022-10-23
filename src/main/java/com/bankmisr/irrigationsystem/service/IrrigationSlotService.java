package com.bankmisr.irrigationsystem.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bankmisr.irrigationsystem.model.IrrigationSlot;
import com.bankmisr.irrigationsystem.repositories.IrrigationSlotRepository;

@Service
public class IrrigationSlotService {
	@Autowired
	private IrrigationSlotRepository irrigationSlotRepository;

	public IrrigationSlot addIrrigationSlot(IrrigationSlot irrigationSlot) {

		// boolean isExist=
		// irrigationSlotRepository.existsIrrigationSlotByBeginWateringdat(irrigationSlot.getBeginWateringdate());
		IrrigationSlot irrigationSlotObj = irrigationSlotRepository
				.findFirstByBeginWateringdate(irrigationSlot.getBeginWateringdate());

		if (irrigationSlotObj == null) {
			return irrigationSlotRepository.save(irrigationSlot);
		} else
			return irrigationSlotObj;

	}

	public List<IrrigationSlot> getAllSlots() {
		return irrigationSlotRepository.findAll();
	}
}
