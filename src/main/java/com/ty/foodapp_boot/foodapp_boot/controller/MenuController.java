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

import com.ty.foodapp_boot.foodapp_boot.dto.Menu;
import com.ty.foodapp_boot.foodapp_boot.service.MenuService;
import com.ty.foodapp_boot.foodapp_boot.util.ResponseStructure;

@RestController
@RequestMapping("menu")
public class MenuController {

	
	@Autowired
	MenuService menuService;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<Menu>> saveMenu(@RequestBody Menu menu){
		return menuService.saveMenu(menu);
	}
	
	@PutMapping
	public ResponseEntity<ResponseStructure<Menu>> updateMenu(@RequestBody Menu menu,@RequestParam int menuid){
		return menuService.updateMenu(menu,menuid);
	}
	
	@GetMapping
	public ResponseEntity<ResponseStructure<Menu>> getMenuById(@RequestParam int id){
		return menuService.getMenuById(id);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseStructure<String>> deleteMenuById(@PathVariable int id){
		return menuService.deleteMenuById(id);
	}
	
	
	
	
	
	
	
}
