package com.company.weather.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class WeatherErrorController {
	
	  @ExceptionHandler(value = WeatherNotFoundException.class)
	   public ResponseEntity<Object> weathernotfound(WeatherNotFoundException exception) {
	      return new ResponseEntity<>("Weather data not found", HttpStatus.NOT_FOUND);
	   }

}
