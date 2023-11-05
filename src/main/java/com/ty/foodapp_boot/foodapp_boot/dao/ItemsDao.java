package com.ty.foodapp_boot.foodapp_boot.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.foodapp_boot.foodapp_boot.dto.Items;
import com.ty.foodapp_boot.foodapp_boot.repository.ItemsRepository;

@Repository
public class ItemsDao {

	@Autowired
	private ItemsRepository repository;
	
	
	public Items saveItems(Items items) {
		
		return repository.save(items);
	}
	
	public Items updateItems(Items items) {
		
		return repository.save(items);
	}
	
	public Items getItemsById(int id) {
		Optional<Items> optional = repository.findById(id);
		
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}
	
	public String deleteItemsById(int id){
		repository.deleteById(id);
		return "Deleted";
	}
}
