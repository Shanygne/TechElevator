package com.techelevator;

import java.text.DecimalFormat;

public class SalaryWorker extends Worker {
// ATTRIBUTES + GETTERS
	private double annualSalary;
	private String firstName;
	private String lastName;

	public double getAnnualSalary() {
		return annualSalary;
	}
	
	
	// CONSTRUCTOR
	public SalaryWorker(String firstName, String lastName, double annualSalary) {
		super();
		super.setFirstName(firstName);
		super.setLastName(lastName);
		this.annualSalary = annualSalary;
	}
	
	// METHOD
	public double calculateWeeklyPay(int hoursWorked) {
		DecimalFormat df = new DecimalFormat("###.##");
		return Double.parseDouble(df.format(annualSalary/52));
	}
}
