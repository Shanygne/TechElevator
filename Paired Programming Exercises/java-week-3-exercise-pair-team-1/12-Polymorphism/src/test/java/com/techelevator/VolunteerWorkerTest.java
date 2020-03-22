package com.techelevator;

import static org.junit.Assert.*;

import org.junit.Test;

public class VolunteerWorkerTest {
	
	VolunteerWorker testVolunteerWorker = new VolunteerWorker("Works", "Forfree");

	@Test
	public void first_and_last_names_exist() {
		assertNotNull(testVolunteerWorker.getFirstName());
		assertNotNull(testVolunteerWorker.getLastName());
	}
	
	@Test
	public void makes_sure_they_make_nothing() {
		assertTrue("They made money when they worked 10 hours", testVolunteerWorker.calculateWeeklyPay(10) == 0);
		assertTrue("They made money when they worked negative hours", testVolunteerWorker.calculateWeeklyPay(-50) == 0);
		assertTrue("They made money when they worked 150 hours", testVolunteerWorker.calculateWeeklyPay(150) == 0);
		
	}

}
