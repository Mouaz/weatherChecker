
package com.mohamed265.weatherchecker.managedBean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.mohamed265.weatherchecker.entity.Note;
import com.mohamed265.weatherchecker.entity.WeatherDay;
import com.mohamed265.weatherchecker.service.NoteService;
import com.mohamed265.weatherchecker.service.WeatherDayService;
import com.mohamed265.weatherchecker.statics.FetchingStatics;
import com.mohamed265.weatherchecker.util.FetchWeatherDay;
import com.mohamed265.weatherchecker.util.jsf.annotation.SpringViewScoped;

@ManagedBean(name = "homeBean")
@SpringViewScoped
@Controller
public class HomeBean extends BaseBean {

	@Autowired
	private WeatherDayService weatherDayService;

	@Autowired
	private NoteService noteService;

	private WeatherDay weatherDay;

	private List<Note> notes;

	@PostConstruct
	public void inti() {

		if (!FetchingStatics.isFetching) {

			if (FetchingStatics.isFetchingUncertain) {
				weatherDay = weatherDayService.getCurrentWeatherDay();
				FetchingStatics.isFetchingUncertain = false;
				if (weatherDay != null) {
					FetchingStatics.isFetchingSuccess = true;
					FetchingStatics.isFetching = false;
					notes = noteService.getCurrentNotes(weatherDay.getValue());
				} else {
					weatherDay = FetchWeatherDay.fetchWeatherDay();
					if (weatherDay != null) {
						FetchingStatics.isFetchingSuccess = true;
						FetchingStatics.isFetching = false;
						weatherDayService.save(weatherDay);
						notes = noteService.getCurrentNotes(weatherDay.getValue());
					}
				}

			} else if (FetchingStatics.accessDB()) {
				weatherDay = weatherDayService.getCurrentWeatherDay();
				notes = noteService.getCurrentNotes(weatherDay.getValue());
			} else {
				weatherDay = FetchWeatherDay.fetchWeatherDay();
				if (weatherDay != null) {
					FetchingStatics.isFetchingSuccess = true;
					FetchingStatics.isFetching = false;
					weatherDayService.save(weatherDay);
					notes = noteService.getCurrentNotes(weatherDay.getValue());
				}
			}

		} else {
			weatherDay = new WeatherDay();
			addInfoMessage("System is Fetching weather state, please refresh page later");
			notes = null;
		}
	}

	public WeatherDay getWeatherDay() {
		return weatherDay;
	}

	public List<Note> getNotes() {
		return notes;
	}

}