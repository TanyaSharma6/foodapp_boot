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

import com.ty.foodapp_boot.foodapp_boot.dto.FoodOrder;
import com.ty.foodapp_boot.foodapp_boot.service.FoodOrderService;
import com.ty.foodapp_boot.foodapp_boot.util.ResponseStructure;

@RestController
@RequestMapping("foodorder")
public class FoodOrderController {

	@Autowired
	FoodOrderService foodOrderService;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<FoodOrder>> saveFoodOrder(@RequestBody FoodOrder foodOrder){
		return foodOrderService.saveFoodOrder(foodOrder);
	}
	
	@PutMapping
	public ResponseEntity<ResponseStructure<FoodOrder>> updateFoodOrder(@RequestBody FoodOrder foodOrder,@RequestParam int id){
		return foodOrderService.updateFoodOrder(foodOrder, id);
	}
	
	@GetMapping
	public ResponseEntity<ResponseStructure<FoodOrder>> getFoodOrderById(@RequestParam int id){
		return foodOrderService.getFoodOrderById(id);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseStructure<String>> deleteFoodOrderById(@PathVariable int id){
		return foodOrderService.deleteFoodOrderById(id);
	}
}
