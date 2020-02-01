package com.company.weather.exception;

public class WeatherNotFoundException extends Exception {
	private static final long serialVersionUID = 1L;
	private String message;

	public WeatherNotFoundException(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}	
}
