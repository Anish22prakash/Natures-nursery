package com.masai.service;

import com.masai.exception.CustomerException;
import com.masai.model.CustomerRegsister;

public interface CustomerService {
	
     public CustomerRegsister createCustomer(CustomerRegsister customer)throws CustomerException;
	
	public CustomerRegsister updateCustomer(CustomerRegsister customer,String key)throws CustomerException;

}
