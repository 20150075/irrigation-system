package com.bankmisr.irrigationsystem.exception;

public class IrrigationSystemException extends Exception {
	private String message;
	private int errorCode;
	private Throwable exception;

	public IrrigationSystemException() {

	}

	public IrrigationSystemException(String message, int errorCode, Throwable exception) {
		this.message = message;
		this.errorCode = errorCode;
		this.exception = exception;
	}

	public IrrigationSystemException(String message, int errorCode) {
		this.message = message;
		this.errorCode = errorCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public Throwable getException() {
		return exception;
	}

	public void setException(Throwable exception) {
		this.exception = exception;
	}

}
