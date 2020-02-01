package com.company.weather.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.weather.exception.WeatherNotFoundException;
import com.company.weather.service.WeatherService;

@RestController
@RequestMapping("/api")
public class WeatherController {
	
	@Autowired
	private WeatherService weatherService;
	
	@RequestMapping(value = "/v1/forecast/{city}")
	public ResponseEntity<Object> forcastWeather(@PathVariable("city") String city) throws WeatherNotFoundException {
		return new ResponseEntity<Object>(weatherService.getWeatherForecasting(city),HttpStatus.OK);		
	}
}
