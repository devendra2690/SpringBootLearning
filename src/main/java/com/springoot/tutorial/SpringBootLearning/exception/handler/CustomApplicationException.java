package com.springoot.tutorial.SpringBootLearning.exception.handler;

public class CustomApplicationException extends RuntimeException{

	private String errorMessage;
	
	public CustomApplicationException(String message) {
         this.errorMessage = message;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}	
}
