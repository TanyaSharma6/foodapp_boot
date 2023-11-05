package com.ty.foodapp_boot.foodapp_boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.foodapp_boot.foodapp_boot.dao.MenuDao;
import com.ty.foodapp_boot.foodapp_boot.dto.Items;
import com.ty.foodapp_boot.foodapp_boot.dto.Menu;
import com.ty.foodapp_boot.foodapp_boot.exception.NoSuchIdFoundException;
import com.ty.foodapp_boot.foodapp_boot.exception.NoUserFoundException;
import com.ty.foodapp_boot.foodapp_boot.util.ResponseStructure;

@Service
public class MenuService {

	@Autowired
	MenuDao menuDao;
	
	
	public ResponseEntity<ResponseStructure<Menu>> saveMenu(Menu menu){
			ResponseStructure<Menu> responseStructure= new ResponseStructure<Menu>();
			
			responseStructure.setStatus(HttpStatus.CREATED.value());
			responseStructure.setMessage("Menu Saved");
			responseStructure.setData(menuDao.saveMenu(menu));
			
			ResponseEntity<ResponseStructure<Menu>> responseEntity = new ResponseEntity<ResponseStructure<Menu>>(responseStructure,HttpStatus.CREATED);
			
			return responseEntity;
	}
	
	
	public ResponseEntity<ResponseStructure<Menu>> updateMenu(Menu menu,int id){
		ResponseStructure<Menu> responseStructure= new ResponseStructure<Menu>();
		
		if(menuDao.getMenuById(id)!=null) {
			List<Items> items= menu.getItems();
			menu.setId(id);
			menu.setItems(items);
			responseStructure.setStatus(HttpStatus.CREATED.value());
			responseStructure.setMessage("Menu updated");
			responseStructure.setData(menuDao.updateMenu(menu));
			
			
		}
		else {
			throw new NoUserFoundException();
		}
		ResponseEntity<ResponseStructure<Menu>> responseEntity = new ResponseEntity<ResponseStructure<Menu>>(responseStructure,HttpStatus.CREATED);

		return responseEntity;
		
	} 
	
	public ResponseEntity<ResponseStructure<Menu>> getMenuById(int id){
		ResponseStructure<Menu> responseStructure= new ResponseStructure<Menu>();
		
		if(menuDao.getMenuById(id)!=null) {
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setMessage("Menu Found");
			responseStructure.setData(menuDao.getMenuById(id));
		}else {
			throw new NoSuchIdFoundException();
		}
		ResponseEntity<ResponseStructure<Menu>> responseEntity = new ResponseEntity<ResponseStructure<Menu>>(responseStructure,HttpStatus.FOUND);

		return responseEntity;
	}
	
	
	public ResponseEntity<ResponseStructure<String>> deleteMenuById(int id){
		ResponseStructure<String> responseStructure= new ResponseStructure<String>();
		
		if(menuDao.getMenuById(id)!=null) {
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setMessage("Menu Found and Deleted");
			responseStructure.setData(menuDao.deleteMenuById(id));
		}else {
			throw new NoSuchIdFoundException();
		}
		ResponseEntity<ResponseStructure<String>> responseEntity = new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.FOUND);

		return responseEntity;
	}
}
