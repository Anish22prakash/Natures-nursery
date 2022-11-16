package com.masai.registerController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.CustomerException;
import com.masai.model.CustomerRegsister;
import com.masai.service.CustomerService;

@CrossOrigin(origins = "*")
@RestController
public class allRegisterController {
	
	@Autowired
	private CustomerService customerService;
	
	
	@PostMapping("naturenursery/regsistercustomers")
	public ResponseEntity<CustomerRegsister> saveCustomer(@RequestBody CustomerRegsister customer) throws CustomerException {
		
		CustomerRegsister savedCustomer= customerService.createCustomer(customer);
		
		
		return new ResponseEntity<CustomerRegsister>(savedCustomer,HttpStatus.CREATED);
	}
	
	@PutMapping("naturenursery/updatecustomers")
	public  ResponseEntity<CustomerRegsister> updateCustomer(@RequestBody CustomerRegsister customer,@RequestParam(required = false) String key ) throws CustomerException {
		
		
		CustomerRegsister updatedCustomer= customerService.updateCustomer(customer, key);
				
		return new ResponseEntity<CustomerRegsister>(updatedCustomer,HttpStatus.OK);
		
	}
	

}
