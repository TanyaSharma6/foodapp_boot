package com.ty.foodapp_boot.foodapp_boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.foodapp_boot.foodapp_boot.dto.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
