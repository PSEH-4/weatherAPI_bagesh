package com.company.weather.helper;

import java.util.List;

import org.springframework.stereotype.Component;

import com.company.weather.exception.WeatherNotFoundException;
import com.company.weather.model.WeatherList;
import com.company.weather.model.WeatherModel;

@Component
public class WeatherForecastHelper {

	public String getForecastingSuggestionForNextDays(WeatherModel weatherModel, String city)
			throws WeatherNotFoundException {

		if (weatherModel.getCity().getName().equalsIgnoreCase(city)) {
			List<WeatherList> weatherLists = weatherModel.getList();

			if (weatherLists != null && weatherLists.size() >= 0) {
				for (WeatherList weatherItem : weatherLists) {
					double temperatureInCelcius = weatherItem.getMain().getTempMax() - 273.15F;

					StringBuilder response = new StringBuilder();

					if (temperatureInCelcius <= 9) {
						response.append("Temp Around 9 degree celcius ... Too cold");
					} else if (temperatureInCelcius >= 40) {
						response.append("Use Sunscreen lotion ... Its Hot");
					}

					if (weatherItem.getWeather().stream().anyMatch(obj -> obj.getMain().equalsIgnoreCase("Rain"))) {
						response.append("...... It might rain also... Carry Umbrella");
					}

					if (!response.toString().isEmpty())
						return response.toString();
				}

				return "Enjoy ... It's a pleasant Weather!!";
			}
		}
		return null;
	}
}
