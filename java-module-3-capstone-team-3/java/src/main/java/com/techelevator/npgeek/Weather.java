package com.techelevator.npgeek;

public class Weather {
	
	private String parkCode;
	private String forecast;
	private int fiveDayForecastValue;
	private int loTemp;
	private int hiTemp;
	private int day;
	private String advisory;

	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public String getParkCode() {
		return parkCode;
	}
	public void setParkCode(String parkCode) {
		this.parkCode = parkCode;
	}
	public String getForecast() {
		return forecast;
	}
	public void setForecast(String forecast) {
		this.forecast = forecast;
	}
	public int getFiveDayForecastValue() {
		return fiveDayForecastValue;
	}
	public void setFiveDayForecastValue(int fiveDayForecastValue) {
		this.fiveDayForecastValue = fiveDayForecastValue;
	}
	public int getLoTemp() {
		return loTemp;
	}
	public void setLoTemp(int loTemp) {
		this.loTemp = loTemp;
	}
	public int getHiTemp() {
		return hiTemp;
	}
	public void setHiTemp(int hiTemp) {
		this.hiTemp = hiTemp;
	}
	
	public String getAdvisory() {
		return advisory;
	}
	public void setAdvisory(int hiTemp, int loTemp) {
		String result = "";
		switch(this.getForecast()) {
		case "snow": result="Don't forget to pack some snowshoes!";
		break;
		case "rain": result="Don't forget to pack raingear and wear waterfproof shoes!";
		break;
		case "thunderstorms": result="Please seek shelter and avoid hiking on exposed ridges!";
		break;
		case "sun": result="Don't forget to pack some sunblock! ";
		break;
		}
	
		if (hiTemp > 75) {
			result += "Don't forget to bring an extra gallon of water!";
		}
		if (loTemp < 20) {
			result += "Be careful and don't catch hypothermia! ";
		}
		if((hiTemp - loTemp) > 20) {
			result += "Don't forget to wear breathable layers!";
		}
		advisory = result;
	}
}
