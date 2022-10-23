package com.bankmisr.irrigationsystem.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bankmisr.irrigationsystem.model.IrrigationSlot;
import com.bankmisr.irrigationsystem.service.IrrigationSlotService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "slots")
public class IrrigationSlotController {

	@Autowired
	private IrrigationSlotService irrigationSlotService;

	@GetMapping("/slots")
	public List<IrrigationSlot> getAllSlots() {
		return irrigationSlotService.getAllSlots();
	}

}
