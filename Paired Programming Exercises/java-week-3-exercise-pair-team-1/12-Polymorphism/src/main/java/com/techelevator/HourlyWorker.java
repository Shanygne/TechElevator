package com.techelevator;

import java.text.DecimalFormat;

public class HourlyWorker extends Worker {
	//ATTRIBUTES + GETTERS
	private double hourlyRate;
	private String firstName;
	private String lastName;

	public double getHourlyRate() {
		return hourlyRate;
	}
	
	// CONSTRUCTOR
	public HourlyWorker(String firstName, String lastName, double hourlyRate) {
		super();
		super.setFirstName(firstName);
		super.setLastName(lastName);
		this.hourlyRate = hourlyRate;
	}
	// METHOD
	public double calculateWeeklyPay(int hoursWorked) {
		DecimalFormat df = new DecimalFormat("###.##");
		if (hoursWorked < 0) {
			return 0;
		}
		double pay = 0.00;
		pay = hourlyRate * hoursWorked;
		double overtime = hoursWorked - 40;
		if(overtime > 0) {
		pay = pay + (hourlyRate * overtime * .5);
	}
		return Double.parseDouble(df.format(pay));
	}
}
