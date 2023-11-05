package com.ty.foodapp_boot.foodapp_boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.foodapp_boot.foodapp_boot.dao.FoodorderDao;
import com.ty.foodapp_boot.foodapp_boot.dto.FoodOrder;
import com.ty.foodapp_boot.foodapp_boot.dto.Product;
import com.ty.foodapp_boot.foodapp_boot.exception.NoSuchIdFoundException;
import com.ty.foodapp_boot.foodapp_boot.exception.NoUserFoundException;
import com.ty.foodapp_boot.foodapp_boot.util.ResponseStructure;

@Service
public class FoodOrderService {

	@Autowired
	FoodorderDao foodorderDao;
	
	public ResponseEntity<ResponseStructure<FoodOrder>> saveFoodOrder(FoodOrder foodorder){
		ResponseStructure<FoodOrder> responseStructure= new ResponseStructure<FoodOrder>();
		
		List<Product> product = foodorder.getProduct();
		
		double totalcost=0;
		
		for (Product product2 : product) {
			
			totalcost = totalcost + (product2.getPrice() * product2.getQuantity());
		}
	
		foodorder.setTotalcost(totalcost); 
		
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("FoodOrder Saved");
		responseStructure.setData(foodorderDao.saveFoodOrder(foodorder));
		
		ResponseEntity<ResponseStructure<FoodOrder>> responseEntity = new ResponseEntity<ResponseStructure<FoodOrder>>(responseStructure,HttpStatus.CREATED);
		
		return responseEntity;
	}	


		public ResponseEntity<ResponseStructure<FoodOrder>> updateFoodOrder(FoodOrder foodorder,int id){
			ResponseStructure<FoodOrder> responseStructure= new ResponseStructure<FoodOrder>();
			
			if(foodorderDao.getFoodOrderById(id)!=null) {
			List<Product> product = foodorder.getProduct();
			
			double totalcost=0;
			
			for (Product product2 : product) {
				
				totalcost = totalcost + (product2.getPrice() * product2.getQuantity());
			}
		
			foodorder.setTotalcost(totalcost); 
			
			
				foodorder.setId(id);
				responseStructure.setStatus(HttpStatus.CREATED.value());
				responseStructure.setMessage("FoodOrder updated");
				responseStructure.setData(foodorderDao.updateFoodOrder(foodorder));
				
				
			}
			else {
				throw new NoUserFoundException();
			}
			ResponseEntity<ResponseStructure<FoodOrder>> responseEntity = new ResponseEntity<ResponseStructure<FoodOrder>>(responseStructure,HttpStatus.CREATED);

			return responseEntity;
			
		} 

	public ResponseEntity<ResponseStructure<FoodOrder>> getFoodOrderById(int id){
		ResponseStructure<FoodOrder> responseStructure= new ResponseStructure<FoodOrder>();
		
		if(foodorderDao.getFoodOrderById(id)!=null) {
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setMessage("FoodOrder Found");
			responseStructure.setData(foodorderDao.getFoodOrderById(id));
		}else {
			throw new NoSuchIdFoundException();
		}
		ResponseEntity<ResponseStructure<FoodOrder>> responseEntity = new ResponseEntity<ResponseStructure<FoodOrder>>(responseStructure,HttpStatus.FOUND);

		return responseEntity;
	}


	public ResponseEntity<ResponseStructure<String>> deleteFoodOrderById(int id){
		ResponseStructure<String> responseStructure= new ResponseStructure<String>();
		
		if(foodorderDao.getFoodOrderById(id)!=null) {
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setMessage("FoodOrder Found and Deleted");
			responseStructure.setData(foodorderDao.deleteFoodOrderById(id));
		}else {
			throw new NoSuchIdFoundException();
		}
		ResponseEntity<ResponseStructure<String>> responseEntity = new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.FOUND);

		return responseEntity;
	}
}
