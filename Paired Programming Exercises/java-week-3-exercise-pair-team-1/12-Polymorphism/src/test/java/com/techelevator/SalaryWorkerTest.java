package com.techelevator;

import static org.junit.Assert.*;

import org.junit.Test;

public class SalaryWorkerTest {
	
	SalaryWorker testSalaryWorker = new SalaryWorker("Salaried", "Employee", 75000);
	
	@Test
	public void first_and_last_names_exist() {
		assertNotNull(testSalaryWorker.getFirstName());
		assertNotNull(testSalaryWorker.getLastName());
	}


	@Test
	public void does_hourly_rate_return_correctly() {
		assertTrue("The total pay was incorrect", testSalaryWorker.calculateWeeklyPay(10) == 1442.31);
		assertTrue("Zero hours dont equal 0 pay", testSalaryWorker.calculateWeeklyPay(0) == 1442.31);
		assertTrue("Negative numbers should return 0", testSalaryWorker.calculateWeeklyPay(-1) == 1442.31);
		assertTrue("Overtime not working right", testSalaryWorker.calculateWeeklyPay(41) == 1442.31);
		assertEquals("Not equal", 1442.31, testSalaryWorker.calculateWeeklyPay(1000), 0);
	}

}
