package com.company.weather.repository;

import com.company.weather.exception.WeatherNotFoundException;
import com.company.weather.model.WeatherModel;

public interface WeatherRepository {
	public WeatherModel getWeatherData(String city) throws WeatherNotFoundException;
}
