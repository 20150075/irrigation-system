package com.bankmisr.irrigationsystem.exception;

public class CropNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public CropNotFoundException(int id) {
		super("Could not find crop with id : " + id);
	}
	
	public CropNotFoundException(String name) {
		super("Could not find crop with iname : " + name);
	}

}
