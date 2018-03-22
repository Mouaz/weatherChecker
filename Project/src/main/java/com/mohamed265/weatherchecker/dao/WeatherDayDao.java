package com.mohamed265.weatherchecker.dao;

import java.util.Date;

import com.mohamed265.weatherchecker.entity.WeatherDay;
import com.mohamed265.weatherchecker.exceptions.EntityMergeException;

public interface WeatherDayDao {

	public void save(WeatherDay weatherDay) throws EntityMergeException;

	public WeatherDay getWeatherDayByDate(Date date);

}
