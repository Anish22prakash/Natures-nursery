package com.masai.loginController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.masai.exception.LoginException;
import com.masai.model.CustomerLoginDTO;
import com.masai.service.LoginService;

@CrossOrigin(origins = "*")
@RestController
public class allLoginController {
	
	@Autowired
	private LoginService customerLogin;
	
	@PostMapping("naturenursery/login")
	public ResponseEntity<String> logInCustomer(@RequestBody CustomerLoginDTO dto) throws LoginException {
		
		String result = customerLogin.logIntoAccount(dto);
		Gson gson= new Gson();
		result=gson.toJson(result);
		
		return new ResponseEntity<String>(result,HttpStatus.OK );
		
	}
	
	@PatchMapping("naturenursery/logout")
	public String logoutCustomer(@RequestParam(required = false) String key) throws LoginException {
		
			String logout=	customerLogin.logOutFromAccount(key);
			Gson gson=new Gson();
			logout=gson.toJson(logout);
			return logout;
		
	}
	

}
