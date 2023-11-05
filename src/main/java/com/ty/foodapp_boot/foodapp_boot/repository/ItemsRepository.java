package com.ty.foodapp_boot.foodapp_boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.foodapp_boot.foodapp_boot.dto.Items;

public interface ItemsRepository extends JpaRepository<Items, Integer> {

}
