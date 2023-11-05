package com.ty.foodapp_boot.foodapp_boot.exception;

public class NoSuchIdFoundException extends RuntimeException{

	String message="No Such ID Found is the DB";

	
	
	public NoSuchIdFoundException(String message) {
		super();
		this.message = message;
	}

	public NoSuchIdFoundException() {
	}

	@Override
	public String getMessage() {
		return message;
	}
	
	

	

	
}
