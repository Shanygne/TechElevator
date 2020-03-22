package com.techelevator;

import java.awt.List;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class WorkerTest {

	public static void main(String[] args) {
		Worker tom = new SalaryWorker("Tom", "Wehman", 60000.00);
		Worker phil = new HourlyWorker("Phil", "Brown", 23.50);
		Worker mary = new VolunteerWorker("Mary", "Poppins");
		
		ArrayList<Worker> payroll = new ArrayList<Worker>();
		payroll.add(tom);
		payroll.add(phil);
		payroll.add(mary);
		double totalHours = 0;
		double totalPay = 0;
		DecimalFormat df = new DecimalFormat("###.##");
		for (Worker worker : payroll) {
			int hoursWorked = (int)Math.round((Math.random() * 50));
			System.out.println(worker.getLastName() + "," + worker.getFirstName() + " " + "$" + df.format(worker.calculateWeeklyPay(hoursWorked)));
			totalHours += hoursWorked;
			totalPay += worker.calculateWeeklyPay(hoursWorked);
		}
		System.out.println("Total Hours: " + totalHours);
		System.out.println("Total Pay: " + "$" + df.format(totalPay));
		
	}

}
