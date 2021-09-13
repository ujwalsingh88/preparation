package com.java.preparation.exception;

public class CustomException extends Exception{
	 
	private static final long serialVersionUID = 1L;
	private boolean hasLoggerMessage =true;
	
	

	public CustomException() {
		
	}
	
	public CustomException(String message) {
		super(message);
	}
	
	public CustomException(Throwable cause) {
		super(cause);
	}
	
	public CustomException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public boolean isHasLoggerMessage() {
		return hasLoggerMessage;
	}

	public void setHasLoggerMessage(boolean hasLoggerMessage) {
		this.hasLoggerMessage = hasLoggerMessage;
	}
	
}
