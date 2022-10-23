package com.bankmisr.irrigationsystem.exception;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonFormat;

public class APICallingError {
	private HttpStatus status;
	   @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
	   private LocalDateTime timestamp;
	   private String message;
	   private String debugMessage;
	   private List<ApiSubError> subErrors;
	   private List<String> errors;
	   private String error;
	   private APICallingError() {
	       timestamp = LocalDateTime.now();
	   }

	   APICallingError(HttpStatus status) {
	       this();
	       this.status = status;
	   }

	   APICallingError(HttpStatus status, Throwable ex) {
	       this();
	       this.status = status;
	       this.message = "Unexpected error";
	       this.debugMessage = ex.getLocalizedMessage();
	   }

	   APICallingError(HttpStatus status, String message, Throwable ex) {
	       this();
	       this.status = status;
	       this.message = message;
	       this.debugMessage = ex.getLocalizedMessage();
	   }

	public APICallingError(HttpStatus badRequest, String localizedMessage, List<String> errors) {
		 this.status = badRequest;
		 this.message = localizedMessage;
		 this.errors=errors;
	}

	public APICallingError(HttpStatus badRequest, String localizedMessage, String error) {
		 this.status = badRequest;
		 this.message = localizedMessage;
		 this.error=error;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDebugMessage() {
		return debugMessage;
	}

	public void setDebugMessage(String debugMessage) {
		this.debugMessage = debugMessage;
	}

	public List<ApiSubError> getSubErrors() {
		return subErrors;
	}

	public void setSubErrors(List<ApiSubError> subErrors) {
		this.subErrors = subErrors;
	}
	   
	   
}
