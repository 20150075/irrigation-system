package com.bankmisr.irrigationsystem.exception;

public enum Errors {

	LENGTH_ERROR(1, "Plot length must be greater than or equal width"),
	AREA_ERROR(2, "Plot Area exceeds land free space , select another land or resize the plot");

	private final int errorCode;
	private final String errorMessage;

	private Errors(int errorCode, String errorMessage) {
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

}
