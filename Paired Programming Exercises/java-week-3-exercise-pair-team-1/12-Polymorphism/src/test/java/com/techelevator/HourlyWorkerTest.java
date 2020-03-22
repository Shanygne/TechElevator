package com.techelevator;

import static org.junit.Assert.*;

import org.junit.Test;

public class HourlyWorkerTest {
	
	HourlyWorker testWorker = new HourlyWorker("Test", "Testerson", 10);
	
	@Test
	public void first_and_last_names_exist() {
		assertNotNull(testWorker.getFirstName());
		assertNotNull(testWorker.getLastName());
	}


	@Test
	public void does_hourly_rate_return_correctly() {
		assertTrue("The total pay was incorrect", testWorker.calculateWeeklyPay(10) == 100);
		assertTrue("Zero hours dont equal 0 pay", testWorker.calculateWeeklyPay(0) == 0);
		assertTrue("Negative numbers should return 0", testWorker.calculateWeeklyPay(-1) == 0);
		assertTrue("Overtime not working right", testWorker.calculateWeeklyPay(41) == 415);
		assertEquals("Not equal", 10, testWorker.calculateWeeklyPay(1), 0);
	}
}
