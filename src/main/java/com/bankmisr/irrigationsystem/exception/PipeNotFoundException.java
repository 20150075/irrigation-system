package com.bankmisr.irrigationsystem.exception;

public class PipeNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public PipeNotFoundException(int id) {
		    super("Could not find pipe with id : " + id);
		  }
}
