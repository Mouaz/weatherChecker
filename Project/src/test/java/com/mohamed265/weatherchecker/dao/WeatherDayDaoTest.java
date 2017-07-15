package com.mohamed265.weatherchecker.dao;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.mohamed265.weatherchecker.entity.WeatherDay;
import com.mohamed265.weatherchecker.util.DateFactory;

@ContextConfiguration("/test-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class WeatherDayDaoTest {

	@Autowired
	private WeatherDayDao weatherDayDao;

	@Test
	public void t01_addWeatherDay() throws Exception {

		WeatherDay weatherDay = new WeatherDay();
		weatherDay.setDate(DateFactory.getDate());
		weatherDay.setDescription("nice");
		weatherDay.setMaxValue(10);
		weatherDay.setMinValue(11);
		weatherDay.setValue(10);
		weatherDay.setSource("source");

		weatherDayDao.save(weatherDay);

		Assert.assertNotNull(weatherDay.getId());
	}

	@Test(expected = Exception.class)
	public void t02_duplicateWeatherDayDate() throws Exception {

		WeatherDay weatherDay = new WeatherDay();
		weatherDay.setDate(DateFactory.getDate());
		weatherDay.setDescription("nice");
		weatherDay.setMaxValue(10);
		weatherDay.setMinValue(11);
		weatherDay.setValue(10);
		weatherDay.setSource("source");

		weatherDayDao.save(weatherDay);

		WeatherDay weatherDay1 = new WeatherDay();
		weatherDay1.setDate(DateFactory.getDate());
		weatherDay1.setDescription("nice");
		weatherDay1.setMaxValue(10);
		weatherDay1.setMinValue(11);
		weatherDay1.setValue(10);
		weatherDay1.setSource("source");

		weatherDayDao.save(weatherDay1);
	}

	@Test
	@Transactional
	public void t03_delete_user_test() throws Exception {

		WeatherDay weatherDay = new WeatherDay();
		weatherDay.setDate(DateFactory.getDate());
		weatherDay.setDescription("nice");
		weatherDay.setMaxValue(10);
		weatherDay.setMinValue(11);
		weatherDay.setValue(10);
		weatherDay.setSource("source");

		weatherDayDao.save(weatherDay);

		weatherDay = weatherDayDao.getWeatherDayByDate(DateFactory.getDate());

		Assert.assertNotNull(weatherDay);
	}

	@Test
	@Transactional
	public void t04_not_found_date() throws Exception {

		WeatherDay weatherDay = null;

		weatherDay = weatherDayDao.getWeatherDayByDate(DateFactory.getDate());

		Assert.assertNull(weatherDay);
	}

}