package com.techelevator;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

import org.apache.commons.dbcp2.BasicDataSource;

import com.sun.xml.internal.bind.v2.model.core.ID;
import com.techelevator.model.campground.Campground;
import com.techelevator.model.campground.JdbcCampgroundDAO;
import com.techelevator.model.park.JdbcParkDAO;
import com.techelevator.model.park.Park;
import com.techelevator.model.reservation.*;
import com.techelevator.model.site.JdbcSiteDAO;
import com.techelevator.model.site.Site;
import com.techelevator.view.*;

public class CampgroundApp {
	
	private static JdbcParkDAO parkDao;
	private static JdbcCampgroundDAO campgroundDao;
	private static JdbcReservationDAO reservationDao;
	private static JdbcSiteDAO siteDao;
	
	/************** PARK MENU SETUP **************/	
	private static final String MENU_OPTION_RETURN_TO_MAIN = "Return to main menu";
	
//	private static final String MAIN_MENU_ACADIA = "Acadia";
//	private static final String MAIN_MENU_ARCHES = "Arches";
//	private static final String MAIN_MENU_CUYAHOGA = "Cuyahoga National Valley Park";
//	private static final String[] MAIN_MENU_OPTIONS = new String[] { MAIN_MENU_ACADIA,
//																	 MAIN_MENU_ARCHES,
//																	 MAIN_MENU_CUYAHOGA};
	

	private static final String PARK_MENU_OPTION_VIEW_CAMPGROUNDS = "View Campgrounds";
	private static final String PARK_MENU_OPTION_SEARCH_FOR_RESERVATION = "Search for Reservation";
	private static final String[] PARK_MENU_OPTIONS = new String[] { PARK_MENU_OPTION_VIEW_CAMPGROUNDS,
																	 PARK_MENU_OPTION_SEARCH_FOR_RESERVATION, 
																	 MENU_OPTION_RETURN_TO_MAIN };

	/************** CAMPGROUND MENU SETUP **************/	
	private static final String CAMPGROUNDS_MENU_OPTION_SEARCH_FOR_AVAILABLE_RESERVATION = "Search for Available Reservation";
	private static final String[] CAMPGROUNDS_MENU_OPTIONS = new String[] {
			CAMPGROUNDS_MENU_OPTION_SEARCH_FOR_AVAILABLE_RESERVATION, MENU_OPTION_RETURN_TO_MAIN };

	/****************************************************************************************************
	 * This is the Campground Reservation system application program
	 * 
	 * Any and all user interactions should be placed in the CampgroundUI class 
	 *     which is in the com.techelevator.view package.
	 *     
	 * This application program should instantiate a CampgroundUI object 
	 *      and use its methods to interact with the user.
	 *      
	 * This application program should contain no user interactions.
	 * 
	 * Any and all database accesses should be placed in the appropriate
	 *     com.techelevator.model.tablename package component
	 *     
	 * This application program should instantiate DAO objects and use the methods
	 *     in the DAO to interact with the database tables.   
	 *     
	 * There should be no SQL in this application program
	 *   
	 ***************************************************************************************************/
	
	public static void main(String[] args) {
		
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setUrl("jdbc:postgresql://localhost:5432/campground");
		dataSource.setUsername("postgres");
		dataSource.setPassword("postgres1");
		                                                  
		/****************************************************************************************************
		 * Instantiate any DAOs you will be using here
		 ***************************************************************************************************/
		parkDao        = new JdbcParkDAO(dataSource);
		campgroundDao  = new JdbcCampgroundDAO(dataSource);
		reservationDao = new JdbcReservationDAO(dataSource);
		siteDao        = new JdbcSiteDAO(dataSource);
	
		  // Object to manage user interactions;
	
		/****************************************************************************************************
		 * Your application programming logic goes here
		 ***************************************************************************************************/

		CampgroundUI userInterface = new CampgroundUI();
		//Menu campMenu = new Menu(System.in, System.out);
	
		boolean stop = false;
		while (!stop) {
			userInterface.displayBanner();
			List<Park> allParks = parkDao.getAllAvailableParks();						// use method from object parkDao and store them into a variable list allParks
			Park parkFromUI = userInterface.displayParksAndPick1(allParks);			    // use method from object userInterface and store into a variable park  called parkFromUI, takes in data allParks which is an object list of parks
			userInterface.displayParkInfo(parkFromUI);									// use method from object userInterface and pass in data obtained from parkFromUI
			while (!stop) {	
				String choice = userInterface.getParkMenuChoiceFromUser(PARK_MENU_OPTIONS);
				
				switch (choice)
				{
					case "View Campgrounds":{
						List<Campground> allCampgrounds = campgroundDao.getCampgroundsByParkId(parkFromUI.getParkId());  // pass in the chosen park from line 96 into the method getcampgroundsbyparkid
						userInterface.displayParkCampgroundInfo(allCampgrounds);
					    break;
					}
					case "Search for Reservation":{
						List<Campground> allCampgrounds = campgroundDao.getCampgroundsByParkId(parkFromUI.getParkId());
						userInterface.displayParkCampgroundInfo(allCampgrounds);
						Long selectedParkId = parkFromUI.getParkId();
						Long campground = Long.parseLong(userInterface.askForCampground());
						LocalDate arrivalDate = LocalDate.parse(userInterface.askForArrivaleDate());
						LocalDate departureDate = LocalDate.parse(userInterface.askForDepartureDate());
			
						List<Site> availableSites = siteDao.getAllAvailableSites(campground, arrivalDate, departureDate);						
						Long daysStayed = ChronoUnit.DAYS.between(arrivalDate, departureDate);
						Campground aCampground = campgroundDao.getCampgroundByCampgroundId(campground);
						
						if (availableSites.size() > 0) {	
						userInterface.displaySites(availableSites, daysStayed * aCampground.getDailyFee());	
						Integer campgroundSite = Integer.parseInt(userInterface.askForReservationSite());
						String reservationName = userInterface.askForReservationName();
						reservationDao.createReservation(campgroundSite, reservationName, arrivalDate, departureDate);
						}
						if(availableSites.size() == 0) {
							userInterface.displayChooseAnotherRange();
							break;
						}
						
//						
//						List<Campground> theSelectedCampgrounds = campgroundDao.getCampgroundsByParkId(selectedParkId);
//						userInterface.displayParkCampgroundsAndPick1(theSelectedCampgrounds);
//						
//						List<Site> theSelectedSites = siteDao.getAllAvailableSites(campgroundSite, arrivalDate, departureDate);
//						userInterface.displaySites(theSelectedSites);
//						
//						
//						List<Campground> campgroundsAvailable = campgroundDao.getAllCampGroundByDateAvailabiliy(campground, arrivalDate, departureDate);
						
						
					    break;
					}
					case "Return to main menu":{
						userInterface.displayParksAndPick1(allParks);	
						break;
					}
					case "End Process":{
					      stop = false;	
					      break;
					}
				}
			}
			break;
		}
	}
}

