package com.masai.service;

import com.masai.exception.LoginException;
import com.masai.model.CustomerLoginDTO;
import com.masai.model.CustomerUserSession;

public interface LoginService {
	
	public String logIntoAccount(CustomerLoginDTO dto)throws LoginException;

	public String logOutFromAccount(String key)throws LoginException;
	
	

}
