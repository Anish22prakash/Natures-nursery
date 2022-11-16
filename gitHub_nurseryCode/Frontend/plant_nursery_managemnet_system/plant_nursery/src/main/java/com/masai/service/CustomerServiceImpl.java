package com.masai.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.CustomerException;
import com.masai.model.CustomerRegsister;
import com.masai.model.CustomerUserSession;
import com.masai.repository.CustomerDao;
import com.masai.repository.SessionDao;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerDao customerDao;
	
	@Autowired
	private SessionDao sessionDao;

	@Override
	public CustomerRegsister createCustomer(CustomerRegsister customer) throws CustomerException {

		CustomerRegsister existingCustomer= customerDao.findByMobileNo(customer.getMobileNo());
		
		
		
		if(existingCustomer != null) 
			throw new CustomerException("Customer Already Registered with Mobile number");
			
		
		
		
			return customerDao.save(customer);
		
		
	}

	@Override
	public CustomerRegsister updateCustomer(CustomerRegsister customer, String key) throws CustomerException {
		
		CustomerUserSession loggedInUser= sessionDao.findByUuid(key);
		
		if(loggedInUser == null) {
			throw new CustomerException("Please provide a valid key to update a customer");
		}
		
		
	
		if(customer.getCustomerId() == loggedInUser.getUserId()) {
			//If LoggedInUser id is same as the id of supplied Customer which we want to update
			return customerDao.save(customer);
		}
		else
			throw new CustomerException("Invalid Customer Details, please login first");
		
	}
	


}
