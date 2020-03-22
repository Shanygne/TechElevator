package com.techelevator.npgeek;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

public class Survey {
	
	private String parkcode;
	
	private int surveyId;
	
	@NotBlank(message= "Please input a valid email address")
	@Email(message = "Email must be a valid email address")
	@Pattern(regexp=".+@.+\\..+", message="Please provide a valid email address")
	private String email;
	
	private String state;
	private String activityLevel;
	private String parkName;
	private int surveyCount;
	
	
	public String getParkName() {
		return parkName;
	}
	public void setParkName(String parkName) {
		this.parkName = parkName;
	}
	public int getSurveyCount() {
		return surveyCount;
	}
	public void setSurveyCount(int surveyCount) {
		this.surveyCount = surveyCount;
	}
	public String getParkcode() {
		return parkcode;
	}
	public void setParkcode(String parkcode) {
		this.parkcode = parkcode;
	}
	
	public int getSurveyId() {
		return surveyId;
	}
	public void setSurveyId(int surveyId) {
		this.surveyId = surveyId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getActivityLevel() {
		return activityLevel;
	}
	public void setActivityLevel(String activityLevel) {
		this.activityLevel = activityLevel;
	}
	
	@Override
	public String toString() {
		return activityLevel + " " + surveyId + " " + email + " " + state + " " + parkcode;
	}

}
