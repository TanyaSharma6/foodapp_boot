package com.ty.foodapp_boot.foodapp_boot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ty.foodapp_boot.foodapp_boot.dto.User;
import com.ty.foodapp_boot.foodapp_boot.util.ResponseStructure;

@RestControllerAdvice
public class ApplicationExceptionHandler {

	@ExceptionHandler(NoSuchIdFoundException.class)
	public ResponseEntity<ResponseStructure<String>> noSuchIdFoundHandler(NoSuchIdFoundException exception){
		
		ResponseStructure<String> responseStructure= new ResponseStructure<String>();
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("No Such ID FOund");
		responseStructure.setData(exception.getMessage());
		
		ResponseEntity<ResponseStructure<String>> responseEntity = new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.NOT_FOUND);

		
		return responseEntity;
		
	}
	
	@ExceptionHandler(NoUserFoundException.class)
	public ResponseEntity<ResponseStructure<String>> noSuchUserHandler(NoUserFoundException exception){
		
		ResponseStructure<String> responseStructure= new ResponseStructure<String>();
		
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("NO user found");
		responseStructure.setData(exception.getMessage());
		
		ResponseEntity<ResponseStructure<String>> responseEntity = new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.NOT_FOUND);

		return responseEntity;
	}
}
