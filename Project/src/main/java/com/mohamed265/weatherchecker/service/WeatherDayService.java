package com.mohamed265.weatherchecker.service;

import com.mohamed265.weatherchecker.entity.WeatherDay;

public interface WeatherDayService {

	public boolean save(WeatherDay weatherDay);

	public WeatherDay getCurrentWeatherDay();

}