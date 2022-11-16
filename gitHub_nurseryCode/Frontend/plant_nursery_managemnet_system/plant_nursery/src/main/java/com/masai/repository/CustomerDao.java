package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.model.CustomerRegsister;

public interface CustomerDao extends JpaRepository<CustomerRegsister, Integer> {
	
	public CustomerRegsister findByMobileNo(String mobileNo);
	
	

}
