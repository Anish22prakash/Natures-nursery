package com.masai.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class globalException {
	
	@ExceptionHandler(plantException.class)
	public ResponseEntity<myErrorDetails> plantExceptionHandler(plantException se, WebRequest req){
		
		myErrorDetails err= new myErrorDetails();
		err.setTimestamp(LocalDateTime.now());
		err.setMessage(se.getMessage());
		err.setDetails(req.getDescription(false));
		
		return new ResponseEntity<myErrorDetails>(err, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(seedException.class)
	public ResponseEntity<myErrorDetails> seedExceptionHandler(seedException se, WebRequest req){
		
		myErrorDetails err= new myErrorDetails();
		err.setTimestamp(LocalDateTime.now());
		err.setMessage(se.getMessage());
		err.setDetails(req.getDescription(false));
		
		return new ResponseEntity<myErrorDetails>(err, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(orderIdException.class)
 public ResponseEntity<myErrorDetails> orderIdExceptionHandler(orderIdException se, WebRequest req){
		
		myErrorDetails err= new myErrorDetails();
		err.setTimestamp(LocalDateTime.now());
		err.setMessage(se.getMessage());
		err.setDetails(req.getDescription(false));
		
		return new ResponseEntity<myErrorDetails>(err, HttpStatus.NOT_FOUND);
	}
	
	
	

}
