package com.techelevator.model.park;

import java.util.List;

public interface ParkDAO {

//1. starting with showing available parks
		public List<Park> getAllAvailableParks();
		// Must be available parks
		// Must be sorted alphabetically
		
//2. show park info while having options to choose from
		public Park getParkById(Long parkId);
		
		
}
