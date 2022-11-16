package com.masai.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.LoginException;
import com.masai.model.CustomerLoginDTO;
import com.masai.model.CustomerRegsister;
import com.masai.model.CustomerUserSession;

import com.masai.repository.CustomerDao;
import com.masai.repository.SessionDao;

import net.bytebuddy.utility.RandomString;


@Service
public class LoginServiceImpl implements LoginService {
	
	
	@Autowired
	private CustomerDao customerDao;
	
	@Autowired
	private SessionDao sessionDao;
	
	

	@Override
	public String logIntoAccount(CustomerLoginDTO dto) throws LoginException {
		
   CustomerRegsister existingCustomer= customerDao.findByMobileNo(dto.getMobileNo());
		
		if(existingCustomer == null) {
			
			throw new LoginException("Please Enter a valid mobile number");
			
			 
		}
		
		
		Optional<CustomerUserSession> validCustomerSessionOpt =  sessionDao.findById(existingCustomer.getCustomerId());
		
		
		
		if(validCustomerSessionOpt.isPresent()) {
			
			throw new LoginException("User already Logged In with this number");
			
		}
		
		if(existingCustomer.getPassword().equals(dto.getPassword())) {
			
			String key= RandomString.make(6);
			
			
			CustomerUserSession customerUserSession = new CustomerUserSession(existingCustomer.getCustomerId(),key,LocalDateTime.now());
			
			  sessionDao.save(customerUserSession);

		      return customerUserSession.toString();
			 // throw new LoginException(customerUserSession.toString());
		}
		else
			throw new LoginException("Please Enter a valid password");
		
	}

	@Override
	public String logOutFromAccount(String key) throws LoginException {
		
		
		CustomerUserSession validCustomerSession = sessionDao.findByUuid(key);
		
		
		if(validCustomerSession == null) {
			throw new LoginException("User Not Logged In with this number");
			
		}
		
		
		sessionDao.delete(validCustomerSession);
		
		
		return "Logged Out !!!!!";
		
	}
	

}
