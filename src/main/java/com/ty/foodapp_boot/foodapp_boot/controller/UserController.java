package com.ty.foodapp_boot.foodapp_boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.foodapp_boot.foodapp_boot.dto.User;
import com.ty.foodapp_boot.foodapp_boot.service.UserService;
import com.ty.foodapp_boot.foodapp_boot.util.ResponseStructure;

@RestController
@RequestMapping("user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<User>> saveUser(@RequestBody User user){
		return userService.saveUser(user);
	}

	
	@PutMapping
	public ResponseEntity<ResponseStructure<User>> updateUser(@RequestBody User user,@RequestParam int id){
		return userService.updateUser(user, id);
	}
	
	@GetMapping
	public ResponseEntity<ResponseStructure<User>> getUserById(@RequestParam int id){
		return userService.getUserById(id);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseStructure<String>> deleteUserById(@PathVariable int id){
		return userService.deleteUserById(id);
	}
}
