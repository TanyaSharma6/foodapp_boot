package com.ty.foodapp_boot.foodapp_boot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.foodapp_boot.foodapp_boot.dao.MenuDao;
import com.ty.foodapp_boot.foodapp_boot.dao.ProductDao;
import com.ty.foodapp_boot.foodapp_boot.dto.Items;
import com.ty.foodapp_boot.foodapp_boot.dto.Menu;
import com.ty.foodapp_boot.foodapp_boot.dto.Product;
import com.ty.foodapp_boot.foodapp_boot.exception.NoSuchIdFoundException;
import com.ty.foodapp_boot.foodapp_boot.exception.NoUserFoundException;
import com.ty.foodapp_boot.foodapp_boot.util.ResponseStructure;

@Service
public class ProductService {

	@Autowired
	ProductDao productDao;
	
	
	public ResponseEntity<ResponseStructure<Product>> saveProduct(Product product){
			ResponseStructure<Product> responseStructure= new ResponseStructure<Product>();
			
			responseStructure.setStatus(HttpStatus.CREATED.value());
			responseStructure.setMessage("Product Saved");
			responseStructure.setData(productDao.saveProduct(product));
			
			ResponseEntity<ResponseStructure<Product>> responseEntity = new ResponseEntity<ResponseStructure<Product>>(responseStructure,HttpStatus.CREATED);

			return responseEntity;
	}
	
	
	public ResponseEntity<ResponseStructure<Product>> updateProduct(Product product,int id){
		ResponseStructure<Product> responseStructure= new ResponseStructure<Product>();
		
		if(productDao.getProductById(id)!=null) {
			product.setId(id);
			responseStructure.setStatus(HttpStatus.CREATED.value());
			responseStructure.setMessage("Product updated");
			responseStructure.setData(productDao.updateProduct(product));
			
			
		}
		else {
			throw new NoUserFoundException();
		}
		ResponseEntity<ResponseStructure<Product>> responseEntity = new ResponseEntity<ResponseStructure<Product>>(responseStructure,HttpStatus.CREATED);

		return responseEntity;
		
	} 
	
	public ResponseEntity<ResponseStructure<Product>> getProductById(int id){
		ResponseStructure<Product> responseStructure= new ResponseStructure<Product>();
		
		if(productDao.getProductById(id)!=null) {
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setMessage("Product Found");
			responseStructure.setData(productDao.getProductById(id));
		}else {
			throw new NoSuchIdFoundException();
		}
		ResponseEntity<ResponseStructure<Product>> responseEntity = new ResponseEntity<ResponseStructure<Product>>(responseStructure,HttpStatus.FOUND);

		return responseEntity;
	}
	
	
	public ResponseEntity<ResponseStructure<String>> deleteProductById(int id){
		ResponseStructure<String> responseStructure= new ResponseStructure<String>();
		
		if(productDao.getProductById(id)!=null) {
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setMessage("Product Found and Deleted");
			responseStructure.setData(productDao.deleteProductById(id));
		}else {
			throw new NoSuchIdFoundException();
		}
		ResponseEntity<ResponseStructure<String>> responseEntity = new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.FOUND);

		return responseEntity;
	}
}
