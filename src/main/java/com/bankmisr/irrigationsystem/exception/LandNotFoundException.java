package com.bankmisr.irrigationsystem.exception;

public class LandNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public LandNotFoundException(int id) {
		super("Could not find land with id : " + id);
	}
}
