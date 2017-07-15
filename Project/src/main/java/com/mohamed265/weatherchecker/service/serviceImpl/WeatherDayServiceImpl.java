package com.mohamed265.weatherchecker.service.serviceImpl;

import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mohamed265.weatherchecker.dao.WeatherDayDao;
import com.mohamed265.weatherchecker.entity.WeatherDay;
import com.mohamed265.weatherchecker.service.WeatherDayService;

@Service("WeatherDayService")
public class WeatherDayServiceImpl implements WeatherDayService {

	private final static Logger logger = Logger.getLogger(WeatherDayServiceImpl.class);

	@Autowired
	private WeatherDayDao weatherDayDao;

	@Override
	public boolean save(WeatherDay weatherDay) {

		try {
			weatherDayDao.save(weatherDay);
			return true;
		} catch (Exception e) {
			logger.error(e);
		}
		return false;
	}

	@Override
	public WeatherDay getCurrentWeatherDay() {
		Date date = new Date();
		date.setHours(0);
		date.setMinutes(0);
		date.setSeconds(0);
		return weatherDayDao.getWeatherDayByDate(date);
	}

}
