package com.ty.foodapp_boot.foodapp_boot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.foodapp_boot.foodapp_boot.dao.ItemsDao;
import com.ty.foodapp_boot.foodapp_boot.dto.FoodOrder;
import com.ty.foodapp_boot.foodapp_boot.dto.Items;
import com.ty.foodapp_boot.foodapp_boot.exception.NoSuchIdFoundException;
import com.ty.foodapp_boot.foodapp_boot.util.ResponseStructure;

@Service
public class ItemsService {

	@Autowired
	ItemsDao itemsDao;
	
	
	public ResponseEntity<ResponseStructure<Items>> saveItem(Items items){
		
		ResponseStructure<Items> responseStructure = new ResponseStructure<Items>();
		
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("Saved");
		responseStructure.setData(itemsDao.saveItems(items));
		
		ResponseEntity<ResponseStructure<Items>> responseEntity = new ResponseEntity<ResponseStructure<Items>>(responseStructure,HttpStatus.CREATED);

		return responseEntity;
		
	}
	
	public ResponseEntity<ResponseStructure<Items>> updateItem(Items items,int id){
		
		ResponseStructure<Items> responseStructure = new ResponseStructure<Items>();
		
		if(itemsDao.getItemsById(id)!=null) {
			items.setId(id);
			responseStructure.setStatus(HttpStatus.CREATED.value());
			responseStructure.setMessage("Found & updated");
			responseStructure.setData(itemsDao.saveItems(items));
			
		}else {
			throw new NoSuchIdFoundException();
		}
		
		ResponseEntity<ResponseStructure<Items>> responseEntity = new ResponseEntity<ResponseStructure<Items>>(responseStructure,HttpStatus.CREATED);
		
		return responseEntity;
	}
	
	
	public ResponseEntity<ResponseStructure<Items>> getItemById(int id){
			ResponseStructure<Items> responseStructure = new ResponseStructure<Items>();
		
			
			if(itemsDao.getItemsById(id)!=null) {
				responseStructure.setStatus(HttpStatus.FOUND.value());
				responseStructure.setMessage("Item Found");
				responseStructure.setData(itemsDao.getItemsById(id));
				
			}else {
				throw new NoSuchIdFoundException();
			}
			
		ResponseEntity<ResponseStructure<Items>> responseEntity = new ResponseEntity<ResponseStructure<Items>>(responseStructure,HttpStatus.FOUND);
	
		return responseEntity;
	}
	
	public ResponseEntity<ResponseStructure<String>> deleteItemById(int id){
		ResponseStructure<String> responseStructure= new ResponseStructure<String>();
		
		if(itemsDao.getItemsById(id)!=null) {
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setMessage("Item Found and Deleted");
			responseStructure.setData(itemsDao.deleteItemsById(id));
		}else {
			throw new NoSuchIdFoundException();
		}
		ResponseEntity<ResponseStructure<String>> responseEntity = new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.FOUND);

		return responseEntity;
	}
	
	
	
}
