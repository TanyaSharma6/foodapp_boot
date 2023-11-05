package com.ty.foodapp_boot.foodapp_boot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.foodapp_boot.foodapp_boot.dao.UserDao;
import com.ty.foodapp_boot.foodapp_boot.dto.User;
import com.ty.foodapp_boot.foodapp_boot.exception.NoSuchIdFoundException;
import com.ty.foodapp_boot.foodapp_boot.exception.NoUserFoundException;
import com.ty.foodapp_boot.foodapp_boot.util.ResponseStructure;

@Service
public class UserService {

	@Autowired
	private UserDao dao;
	
	public ResponseEntity<ResponseStructure<User>> saveUser(User user){
		ResponseStructure<User> responseStructure= new ResponseStructure<User>();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("Data Saved");
		responseStructure.setData(dao.saveUser(user));
		
		ResponseEntity<ResponseStructure<User>> responseEntity = new ResponseEntity<ResponseStructure<User>>(responseStructure,HttpStatus.CREATED);
		
		return responseEntity;
	}
	
	public ResponseEntity<ResponseStructure<User>> updateUser(User user,int id){
		ResponseStructure<User> responseStructure= new ResponseStructure<User>();
		
		if(dao.getUserById(id)!=null) {
			user.setId(id);
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Data Updated");
			responseStructure.setData(dao.updateUser(user));
			
		}else {
			
			throw new NoUserFoundException();
		}
		ResponseEntity<ResponseStructure<User>> responseEntity = new ResponseEntity<ResponseStructure<User>>(responseStructure,HttpStatus.OK);

		return responseEntity;
			
		
	}
	
	public  ResponseEntity<ResponseStructure<User>> getUserById(int id){
		ResponseStructure<User> responseStructure= new ResponseStructure<User>();
		
		User user=dao.getUserById(id);
		
		if(user!=null) {
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setMessage("Data Found");
			responseStructure.setData(dao.getUserById(id));
		}
		else {
			throw new NoSuchIdFoundException();
		}
		ResponseEntity<ResponseStructure<User>> responseEntity = new ResponseEntity<ResponseStructure<User>>(responseStructure,HttpStatus.FOUND);

			return responseEntity;
	}
	
	public   ResponseEntity<ResponseStructure<String>> deleteUserById(int id){
		ResponseStructure<String> responseStructure= new ResponseStructure<String>();
		
		User user=dao.getUserById(id);
		
		if(user!=null) {
		
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setMessage("Data Deleted");
			responseStructure.setData(dao.deleteUserById(id));
		}else {
			throw new NoSuchIdFoundException();
		}
		
		ResponseEntity<ResponseStructure<String>> responseEntity = new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.FOUND);

		
		
		return responseEntity;
	}
	
	
	
	
	
}
