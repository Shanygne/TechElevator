package com.techelevator.model.campground;

public class Campground {
	
	private Long campgroundId;
	private Long parkId;
	private String name;
	private String openFromMm;
	private String openToMm;
	private Double dailyFee;
	
	public Long getCampgroundId() {
		return campgroundId;
	}
	public void setCampgroundId(Long campgroundId) {
		this.campgroundId = campgroundId;
	}
	public Long getParkId() {
		return parkId;
	}
	public void setParkId(Long parkId) {
		this.parkId = parkId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getOpenFromMm() {
		return openFromMm;
	}
	public void setOpenFromMm(String openFromMm) {
		this.openFromMm = openFromMm;
	}
	public String getOpenToMm() {
		return openToMm;
	}
	public void setOpenToMm(String openToMm) {
		this.openToMm = openToMm;
	}
	public Double getDailyFee() {
		return dailyFee;
	}
	public void setDailyFee(Double dailyFee) {
		this.dailyFee = dailyFee;
	}
	
	@Override 
	public String toString() {
		return this.getName();
	}
}
