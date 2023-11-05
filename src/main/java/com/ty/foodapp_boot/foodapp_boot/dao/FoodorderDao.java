package com.ty.foodapp_boot.foodapp_boot.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.foodapp_boot.foodapp_boot.dto.FoodOrder;
import com.ty.foodapp_boot.foodapp_boot.repository.FoodOrderRepository;

@Repository
public class FoodorderDao {


	@Autowired
	private FoodOrderRepository repository;
	
	
	public FoodOrder saveFoodOrder(FoodOrder foodorder) {
		
		return repository.save(foodorder);
	}
	
	public FoodOrder updateFoodOrder(FoodOrder foodorder) {
		
		return repository.save(foodorder);
	}
	
	public FoodOrder getFoodOrderById(int id) {
		Optional<FoodOrder> optional = repository.findById(id);
		
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}
	
	public String deleteFoodOrderById(int id){
		repository.deleteById(id);
		return "Deleted";
	}
}
