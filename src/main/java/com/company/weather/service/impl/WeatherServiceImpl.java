package com.company.weather.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.weather.exception.WeatherNotFoundException;
import com.company.weather.helper.WeatherForecastHelper;
import com.company.weather.model.WeatherModel;
import com.company.weather.repository.WeatherRepository;
import com.company.weather.service.WeatherService;

@Service
public class WeatherServiceImpl implements WeatherService {

	@Autowired
	private WeatherRepository weatherRepository;
	@Autowired
	private WeatherForecastHelper weatherHelper;

	@Override
	public String getWeatherForecasting(String city) throws WeatherNotFoundException {
		WeatherModel weatherModel = weatherRepository.getWeatherData(city);

		if (weatherModel != null) {
			String data = weatherHelper.getForecastingSuggestionForNextDays(weatherModel, city);
			if(data != null) {
				return data;
			}else {
				throw new WeatherNotFoundException("Weather data not found");
			}
		} else
			throw new WeatherNotFoundException("Weather data not found");
	}
}
