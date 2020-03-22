package com.techelevator.model.campground;

import java.time.LocalDate;
import java.util.List;

import com.techelevator.model.reservation.Reservation;

public interface CampgroundDAO {
	
//3. show list of campgrounds by parkId  that was chosen from #2
	public List<Campground> getCampgroundsByParkId(Long id);
	//use object from park to pass was chosen into parameter
	// Must show list of available parks at selected Campground
	
	
//4. shows list of campground reservations
	// DO NOT THINK WE NEED
	public List<Campground>getAllCampGroundByDateAvailabiliy(Long campgroundId, LocalDate fromDate, LocalDate toDate);
	// F
	
	public Campground getACampground (Campground newCampground);

}
