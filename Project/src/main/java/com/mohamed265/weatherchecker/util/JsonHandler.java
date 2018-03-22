
package com.mohamed265.weatherchecker.util;

import org.json.JSONArray;
import org.json.JSONObject;

import com.mohamed265.weatherchecker.entity.WeatherDay;

public final class JsonHandler {

	private JsonHandler(){
		throw new AssertionError();
	}
	public static WeatherDay parseJsonToWeather(String str) {
		JSONObject json = new JSONObject(str);
		WeatherDay weatherDay = new WeatherDay();

		weatherDay.setDate(DateFactory.getDate());
		weatherDay.setSource("OPENWEAHTERMAP");

		JSONObject main = json.getJSONObject("main");
		weatherDay.setValue((int) main.getDouble("temp"));
		weatherDay.setMaxValue((int) main.getDouble("temp_max"));
		weatherDay.setMinValue((int) main.getDouble("temp_min"));

		JSONArray arr = json.getJSONArray("weather");
		if (arr.length() != 0)
			weatherDay.setDescription(arr.getJSONObject(0).getString("description"));
		return weatherDay;
	}

}
