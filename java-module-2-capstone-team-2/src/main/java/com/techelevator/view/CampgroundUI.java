package com.techelevator.view;

import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

import com.techelevator.CampgroundApp;
import com.techelevator.model.campground.Campground;
import com.techelevator.model.campground.CampgroundDAO;
import com.techelevator.model.park.JdbcParkDAO;
import com.techelevator.model.park.Park;
import com.techelevator.model.site.Site;

public class CampgroundUI {

	/*******************************************************************************************************
	 * This is the CampgroundUI class
	 * 
	 * All user interactions should be coded here
	 * 
	 * The application program will instantiate an object of this class and use the
	 * object to interact with the user.
	 * 
	 * And data required from the user for the application will be acquired by
	 * methods of this class and sent back to the user either as the return value
	 * from the method or in an object returned from the method.
	 * 
	 * Any messages the application programmer wishes to display to the user may be
	 * sent to methods of this class as variables or objects. Any messaging method
	 * may also have "canned" messages the user may request by a message id.
	 * 
	 *******************************************************************************************************/

	/*******************************************************************************************************
	 * Menu class object
	 * 
	 * Use this Menu object for ALL Menu choices presented to the user
	 * 
	 * This is the same Menu class discussed in module 1 and made available in the
	 * module 1 capstone
	 * 
	 * 
	 ******************************************************************************************************/

	Menu campMenu = new Menu(System.in, System.out);// Define menu for keyboard input and screen output
	Scanner theKeyboard = new Scanner(System.in);
	
	/*******************************************************************************************************
	 * Class member variables, objects, constants and methods should be coded here.
	 ******************************************************************************************************/
	
 	public void displayBanner() {
		System.out.println("Welcome!");
	}

	/****************************************************************************
	 * MENU METHODS
	 ****************************************************************************/

	//String parkChoiceForCampground = theKeyboard.nextLine();
	
	public Park displayParksAndPick1(List<Park> Parks) {
		Park selectedPark = (Park)campMenu.getChoiceFromOptions(Parks.toArray());   // object list of parks passed in. converted to array and got choice from user which is stored in selectedPark
		return selectedPark;
	}
	
	public String getParkMenuChoiceFromUser(String[] PARK_MENU_OPTIONS) {			// get choice from user from park menu options, stored in choice
		String choice = (String)campMenu.getChoiceFromOptions(PARK_MENU_OPTIONS);
		return choice;
	}
	
	public void displayParkCampgroundInfo(List<Campground> campground) {   //object list of campgrounds passed in, goes through array to display each campground in the array
		for(int i = 0; i < campground.size(); i++) {
			System.out.println("Id: " + campground.get(i).getCampgroundId() + " Name: " + campground.get(i).getName() + " | Open: " + campground.get(i).getOpenFromMm() + " | Close: " + campground.get(i).getOpenToMm()+ " | Daily Fee: " + campground.get(i).getDailyFee());
		}
	}
	
	
	public void displayChooseAnotherRange() {
		System.out.println("No sites available, please choose another range.");
	}
	///NOT NEEDED CURRENTLY
//	public Campground displayParkCampgroundsAndPick1(List<Campground> campground) { // object list of campgrounds passed in, goes through array to display each campground, and we get the choice from user
//		for(int i = 0; i < campground.size(); i++) {
//			System.out.println("Name: " + campground.get(i).getName() + " | Open: " + campground.get(i).getOpenFromMm() + " | Close: " + campground.get(i).getOpenToMm()+ " | Daily Fee: " + campground.get(i).getDailyFee());
//		}
//		Campground selectedCampground = (Campground)campMenu.getChoiceFromOptions(campground.toArray());
//
//		return selectedCampground;
//	}
	
	public void displayParkInfo(Park park) {
		System.out.println("Name: " + park.getName());
		System.out.println("Location: " + park.getLocation());
		System.out.println("Established: " + park.getEstablishDate());
		System.out.println("Area: " + park.getArea());
		System.out.println("Annual Visitors: " + park.getVisitors());
		System.out.println("Description:");
		System.out.println(park.getDescription());
	}
	
	
	public String askForCampground() {
		System.out.println("Which campground do you want? (Enter Id)");
		String campground = theKeyboard.nextLine();
		return campground;
	}
	
	public String askForArrivaleDate() {
		try {
			System.out.println("What is the arrival date? (YYYY-MM-DD)");
			String arrivalDate = theKeyboard.nextLine();
			return arrivalDate;
		}
		catch (DateTimeParseException e) {
			System.out.println("Date format error.");
			return null;
		}
}
	
	public String askForDepartureDate() {
		try {
		System.out.println("what is the departure date (YYYY-MM-DD)");
		String departureDate = theKeyboard.nextLine();
		return departureDate;
		}
		catch (DateTimeParseException e) {
			System.out.println("Date format error.");
			return null;
		}
	}
	
	public String askForReservationSite() {
		System.out.println("Which site should be reserved? (Enter 0 to cancel)");
		String reservationSite = theKeyboard.nextLine();
		return reservationSite;
	}
	
	public String askForReservationName() {
		System.out.println("What name should the reservation be made under?");
		String reservationName = theKeyboard.nextLine();
		return reservationName;
	}
	
	public void displaySites(List<Site> sites, double totalCost) {
		for(int i = 0; i < sites.size(); i++) {
			System.out.println("Site No. " + sites.get(i).getSiteNumber() + " | Max Occupancy " + sites.get(i).getMaxOccupancy() + " | Accessible? " + sites.get(i).getAccessible() + " | RV Length? " + sites.get(i).getMaxRvLength() + " | Utility " + sites.get(i).getUtilities() + " | Cost " + totalCost); 
		
		}
	}
	
	
	public void printHeading(String headingText) {
		System.out.println("/n" + headingText);
		for (int i = 0; i < headingText.length(); i++) {
			System.out.println("-");
		}
		System.out.println();
	}
}
