package com.bankmisr.irrigationsystem.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bankmisr.irrigationsystem.configuration.DatabasePasswordEncryptin;
import com.bankmisr.irrigationsystem.dto.PasswordDto;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "passwordEncryption")
public class PasswordEncryptionController {
	
	@Autowired
	private DatabasePasswordEncryptin databasePasswordEncryptin;
	@PostMapping("/encrypt")
	public String encryptPassword(@RequestBody PasswordDto passwordDto) {
		System.out.println("Password: "+ passwordDto.getPassword());
		return databasePasswordEncryptin.databasePasswordEncryptor().encrypt(passwordDto.getPassword());
	}

}
