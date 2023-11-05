package com.ty.foodapp_boot.foodapp_boot.exception;

public class NoUserFoundException extends RuntimeException{

	String message="No Such User Found in the Database";

	
	public NoUserFoundException(String message) {
		super();
		this.message = message;
	}
	
	public NoUserFoundException() {
	
	}
	

	@Override
	public String getMessage() {
		return message;
	}

	
	
}
