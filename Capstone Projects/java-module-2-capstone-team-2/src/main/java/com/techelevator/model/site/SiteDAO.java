package com.techelevator.model.site;

import java.time.LocalDate;
import java.util.List;

import com.techelevator.model.reservation.Reservation;

public interface SiteDAO {

//5. Produces available sites that match date criteria
	public List<Site> getAllAvailableSites(Long campgroundId, LocalDate fromDate, LocalDate toDate);

	
	// In DBVisualizer
	//Query that notes a where clause of 3 conditions, existing begin < desired begin AND existing end > desired begin OR existing begin is < desired end AND the existing end > desired end
	// OR existing begin is > the desired begin AND the existing end < desired end
	// Use that to tell you what sites are available
}
