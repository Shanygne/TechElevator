package com.techelevator.npgeek;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ParksController {
	
	@Autowired
	ParkDao theParks;
	@Autowired
	WeatherDao theWeather;
	@Autowired
    private AuthProvider auth;
	
	@RequestMapping(path="/", method=RequestMethod.GET)
	public String displayHomepage(HttpSession parksMap) {
		List<Park> listOfParks = theParks.listAllParks();
		parksMap.setAttribute("theParks", listOfParks);
		
		parksMap.setAttribute("user", auth.getCurrentUser());
		return "HomePage";
	}
	
	@RequestMapping(path="/detailPage", method=RequestMethod.GET)
	public String displayParkDetails(@RequestParam String parkCode, HttpSession detailsMap, @RequestParam(value = "temperature", required = false) String temperature) throws UnauthorizedException{
		if (!auth.isLoggedIn()) {
			throw new UnauthorizedException();
		}
		
		List<Weather> theForecast = new ArrayList<>();
		theForecast = theWeather.getForecastByParkcode(parkCode);
		detailsMap.setAttribute("aWeather", theForecast);
		
		if(temperature != null) {
			detailsMap.setAttribute("temperature", temperature);
		}
		
		detailsMap.setAttribute("parkCode", parkCode);
		String userChoice = (String)detailsMap.getAttribute("temperature");
		this.setTempFromUserChoice(userChoice, parkCode, detailsMap);
		
		Park thePark = theParks.getParkByCode(parkCode);
		detailsMap.setAttribute("aPark", thePark);
		return "DetailPage";		
	}
	
	public int convertToCelsius(int fahrenheit) {
		int celsius = (int)((fahrenheit - 32.0) * 5.0 / 9.0);
		return celsius;
	}
	
	public void setTempFromUserChoice(String userChoice, String parkCode, HttpSession detailsMap) {
		List<Weather> weatherList = new ArrayList <Weather>();
		weatherList = theWeather.getForecastByParkcode(parkCode);
		if (userChoice == null || userChoice.equals("fahrenheit")) {
			detailsMap.setAttribute("temperature", "fahrenheit");
			detailsMap.setAttribute("weatherList", weatherList);
			detailsMap.setAttribute("temp", "F");
		}
		else if (userChoice.equals("celsius")) {
			for (Weather weather : weatherList) {
				int fahrenheit = weather.getHiTemp();
				int fahrenheitLow = weather.getLoTemp();
				weather.setHiTemp(convertToCelsius(fahrenheit));
				weather.setLoTemp(convertToCelsius(fahrenheitLow));
			}
			
			detailsMap.setAttribute("weatherList", weatherList);
			detailsMap.setAttribute("temp", "C");
		}
	}
}




