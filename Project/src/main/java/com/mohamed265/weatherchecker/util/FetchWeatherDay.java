/**
 * @author mohamed265
 * Created On : Mar 25, 2017 11:18:42 AM
 */
package com.mohamed265.weatherchecker.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

import com.mohamed265.weatherchecker.entity.WeatherDay;
import com.mohamed265.weatherchecker.service.WeatherDayService;
import com.mohamed265.weatherchecker.statics.FetchingStatics;

/**
 * @author mohamed265
 *
 */
@Controller
public class FetchWeatherDay {

	@Autowired
	private static WeatherDayService weatherDayService;

	@Scheduled(cron = "	0 0 1 1/1 * ?")
	public static void schedual() {
		FetchingStatics.isFetchingUncertain = false;
		FetchingStatics.isFetching = true;
		WeatherDay weatherDay = fetchWeatherDay();

		if (weatherDay != null)
			FetchingStatics.isFetchingSuccess = weatherDayService.save(weatherDay);
		else
			FetchingStatics.isFetchingSuccess = false;

		FetchingStatics.isFetching = false;
	}

	public static WeatherDay fetchWeatherDay() {
		String url = PropertiesReader.getApiUrl();
		if (url != null && url.length() != 0) {
			String apiresponse = WebServiceConnector.getResponeString(url);
			if (apiresponse != null && apiresponse.length() != 0) {
				return JsonHandler.parseJsonToWeather(apiresponse);
			}
		}
		return null;
	}

}
