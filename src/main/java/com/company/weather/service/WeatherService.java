package com.company.weather.service;

import com.company.weather.exception.WeatherNotFoundException;

public interface WeatherService {
	public String getWeatherForecasting(String city) throws WeatherNotFoundException;
}
