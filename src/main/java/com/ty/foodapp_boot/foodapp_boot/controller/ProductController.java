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

import com.ty.foodapp_boot.foodapp_boot.dto.Product;
import com.ty.foodapp_boot.foodapp_boot.service.ProductService;
import com.ty.foodapp_boot.foodapp_boot.util.ResponseStructure;

@RestController
@RequestMapping("product")
public class ProductController {


	@Autowired
	private ProductService productService;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<Product>> saveProduct(@RequestBody Product product){
		return productService.saveProduct(product);
	}

	
	@PutMapping
	public ResponseEntity<ResponseStructure<Product>> updateProduct(@RequestBody Product product,@RequestParam int id){
		return productService.updateProduct(product, id);
	}
	
	@GetMapping
	public ResponseEntity<ResponseStructure<Product>> getProductById(@RequestParam int id){
		return productService.getProductById(id);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseStructure<String>> deleteProductById(@PathVariable int id){
		return productService.deleteProductById(id);
	}
}
