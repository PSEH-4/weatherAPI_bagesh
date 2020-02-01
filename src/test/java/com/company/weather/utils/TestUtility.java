package com.company.weather.utils;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TestUtility {

	public static String mapObjectToJson(final Object object) throws JsonProcessingException {
		final ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(object);
	}

	public static <T> T mapJsonToObject(final String jsonString, Class<T> clazz) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.readValue(jsonString, clazz);

	}
}
