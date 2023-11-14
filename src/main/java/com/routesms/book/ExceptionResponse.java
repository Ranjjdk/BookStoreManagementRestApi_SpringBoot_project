package com.routesms.book;

import java.time.LocalDateTime;



public class ExceptionResponse {
	
	private String message;
	private LocalDateTime datatime;
	private String description;
	
	
	public ExceptionResponse(String message, LocalDateTime datatime, String description) {
		
		this.message = message;
		this.datatime = datatime;
		this.description = description;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public LocalDateTime getDatatime() {
		return datatime;
	}
	public void setDatatime(LocalDateTime datatime) {
		this.datatime = datatime;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	

}
