package com.company.weather.repository.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.company.weather.exception.WeatherNotFoundException;
import com.company.weather.model.WeatherModel;
import com.company.weather.repository.WeatherRepository;

@Repository
public class WeatherRepositoryImpl implements WeatherRepository {

	@Value("${app.weather.link}")
	private String weatherAPIURL;

	@Value("${app.weather.forecast.data.intervalInHours}")
	private Integer weatherDataInterval;

	@Value("${app.weather.forecast.noofdays}")
	private Integer numberOfDays;

	@Override
	public WeatherModel getWeatherData(String city) throws WeatherNotFoundException {
		RestTemplate restTemplate = new RestTemplate();

		try {

			WeatherModel response = restTemplate.getForObject(weatherAPIURL.replace("input", city).concat("&cnt=")
					.concat(String.valueOf((24 / weatherDataInterval) * numberOfDays)), WeatherModel.class);
			return response;
		} catch (Exception e) {
			throw new WeatherNotFoundException("Some problem occued");
		}
	}

}
