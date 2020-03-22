package com.techelevator.model.reservation;

import java.time.LocalDate;
import java.util.List;

import com.techelevator.model.campground.Campground;

public interface ReservationDAO {
	
	//6. Which site to be reserved and confirmed with name
	public Reservation createReservation(Integer siteId, String name, LocalDate fromDate, LocalDate toDate);
	// returns created reservation
	
	
	
}
