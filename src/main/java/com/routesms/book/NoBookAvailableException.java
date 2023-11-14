package com.routesms.book;

import org.springframework.stereotype.Component;

@Component
public class NoBookAvailableException  extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	public NoBookAvailableException() {
		
	}
	
	public NoBookAvailableException(String msg) {
		super(msg);
		
	}

}
