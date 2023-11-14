package com.routesms.book;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * this class will handle exception occur any controller class in application
 * 
 * ***/

@RestControllerAdvice
public class GlobalExceptionResponser  extends ResponseEntityExceptionHandler{
	
	@Autowired
	private NoBookAvailableException noException;
	
	@ExceptionHandler(NoBookAvailableException.class)
	public ResponseEntity<Object> handleSomeException(NoBookAvailableException ex,WebRequest request) {
		
		
	    ExceptionResponse errorResponse = new ExceptionResponse("No book "
	    		+ " available that you are to update ",
	    		LocalDateTime.now(),request.getDescription(true));
	    return new ResponseEntity<>(errorResponse, HttpStatusCode.valueOf(404));
	}


}
