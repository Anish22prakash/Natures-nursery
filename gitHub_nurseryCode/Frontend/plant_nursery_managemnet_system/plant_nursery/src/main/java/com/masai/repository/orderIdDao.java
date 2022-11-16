package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.model.OrderId;

public interface orderIdDao extends JpaRepository<OrderId, Integer> {

	
	
}
