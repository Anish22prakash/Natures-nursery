package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.model.CustomerUserSession;

public interface SessionDao extends JpaRepository<CustomerUserSession, Integer> {
	
	public  CustomerUserSession  findByUuid(String uuid);

}
