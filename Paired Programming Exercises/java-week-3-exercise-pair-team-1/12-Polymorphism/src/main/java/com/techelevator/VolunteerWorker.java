package com.techelevator;

public class VolunteerWorker extends Worker {
	//ATTRIBUTES
	private String firstName;
	private String lastName;
	
	//CONSTRUCTOR
	public VolunteerWorker(String firstName, String lastName) {
		super();
		super.setFirstName(firstName);
		super.setLastName(lastName);
	}
	//METHOD
	public double calculateWeeklyPay(int hoursWorked) {
		return hoursWorked * 0;
	}
}
