package com.mohamed265.weatherchecker.dao;

import java.util.Date;

import com.mohamed265.weatherchecker.entity.WeatherDay;

public interface WeatherDayDao {

	public void save(WeatherDay weatherDay) throws Exception;

	public WeatherDay getWeatherDayByDate(Date date);

}
