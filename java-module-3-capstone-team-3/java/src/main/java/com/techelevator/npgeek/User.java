package com.techelevator.npgeek;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

public class User {
	
	private int userId;
	@NotBlank(message = "Username is required")
	@Size(min=4, max=20, message="User name cannot be less than 4 characters or more than 20 characters")
	private String username;
	
    @NotBlank(message = "Password is required")
	@Size(min=8, max=20, message="Password cannot be less than 8 characters or more than 20 characters")
	private String password;
    
	@Size(min=5, max=30, message="Password hint cannot be less than 5 characters or more than 30 characters")
	private String passwordHint;
	
	@NotBlank(message= "Please input a valid email address")
	@Email(message = "Email must be a valid email address")
	@Pattern(regexp=".+@.+\\..+", message="Please provide a valid email address")
	private String emailAddress;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPasswordHint() {
		return passwordHint;
	}
	public void setPasswordHint(String passwordHint) {
		this.passwordHint = passwordHint;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	
	@Override
	public String toString() {
		return username + " " + userId + " " + emailAddress + " " + password + " " + passwordHint;
	}
}
