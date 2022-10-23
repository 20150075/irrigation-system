package com.bankmisr.irrigationsystem.exception;

public class PlotNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public PlotNotFoundException(int id) {
		    super("Could not find plot with id : " + id);
		  }

}
