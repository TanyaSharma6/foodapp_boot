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

import com.ty.foodapp_boot.foodapp_boot.dto.Items;
import com.ty.foodapp_boot.foodapp_boot.service.ItemsService;
import com.ty.foodapp_boot.foodapp_boot.util.ResponseStructure;

@RestController
@RequestMapping("items")
public class ItemsController {


	@Autowired
	private ItemsService itemsService;
	
	@PostMapping
	public  ResponseEntity<ResponseStructure<Items>> saveItems(@RequestBody Items items){
		return itemsService.saveItem(items);
	}

	
	@PutMapping
	public ResponseEntity<ResponseStructure<Items>> updateItems(@RequestBody Items items,@RequestParam int id){
		return itemsService.updateItem(items, id);
	}
	
	@GetMapping
	public ResponseEntity<ResponseStructure<Items>> getItemsById(@RequestParam int id){
		return itemsService.getItemById(id);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseStructure<String>> deleteItemsById(@PathVariable int id){
		return itemsService.deleteItemById(id);
	}
}
