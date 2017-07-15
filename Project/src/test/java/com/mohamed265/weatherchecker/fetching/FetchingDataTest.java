package com.mohamed265.weatherchecker.fetching;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.mohamed265.weatherchecker.entity.WeatherDay;
import com.mohamed265.weatherchecker.util.FetchWeatherDay;
import com.mohamed265.weatherchecker.util.JsonHandler;
import com.mohamed265.weatherchecker.util.PropertiesReader;
import com.mohamed265.weatherchecker.util.WebServiceConnector;

@ContextConfiguration("/test-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class FetchingDataTest {

	@Test
	public void t01_fetchWeatherDay() throws Exception {
		WeatherDay res = FetchWeatherDay.fetchWeatherDay();
		Assert.assertNotNull(res);
	}

	@Test
	public void t02_readProperties() throws Exception {
		String url = PropertiesReader.getApiUrl();
		Assert.assertNotNull(url);
	}

	@Test
	public void t03_getResonse() throws Exception {
		String url = PropertiesReader.getApiUrl();
		String apiresponse = WebServiceConnector.getResponeString(url);
		Assert.assertNotNull(apiresponse);

	}

	@Test
	public void t04_parseResponse() throws Exception {
		String url = PropertiesReader.getApiUrl();
		String apiresponse = WebServiceConnector.getResponeString(url);
		WeatherDay res = JsonHandler.parseJsonToWeather(apiresponse);
		Assert.assertNotNull(res);

	}

}