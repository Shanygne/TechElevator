package com.techelevator.npgeek;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JdbcWeatherDao implements WeatherDao {
	
	private JdbcTemplate jdbcTemplate;

	public JdbcWeatherDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Weather> getForecastByParkcode(String parkCode) {
		List<Weather> theForecast = new ArrayList<>();
		
		String SqlForecast = "SELECT * " +
							 "FROM weather " +
							 "WHERE parkcode = ? " +
							 "ORDER BY fivedayforecastvalue ASC";
		SqlRowSet foreCast = jdbcTemplate.queryForRowSet(SqlForecast, parkCode);
		int day = 1;
		while (foreCast.next()) {
			Weather theWeather = mapRowToForecast(foreCast, day);
			theForecast.add(theWeather);
			day++;
		}
		
		
		return theForecast;
	}

	
	
	
	private Weather mapRowToForecast(SqlRowSet foreCast, int day ) {
		Weather aForecast = new Weather();
		aForecast.setDay(day);
		aForecast.setParkCode(foreCast.getString("parkcode"));
		aForecast.setFiveDayForecastValue(foreCast.getInt("fivedayforecastvalue"));
		aForecast.setLoTemp(foreCast.getInt("low"));
		aForecast.setHiTemp(foreCast.getInt("high"));
		aForecast.setForecast(foreCast.getString("forecast"));
		aForecast.setAdvisory(aForecast.getHiTemp(), aForecast.getLoTemp());
		
		return aForecast;
	}
	
	
	
	
	
	
}
