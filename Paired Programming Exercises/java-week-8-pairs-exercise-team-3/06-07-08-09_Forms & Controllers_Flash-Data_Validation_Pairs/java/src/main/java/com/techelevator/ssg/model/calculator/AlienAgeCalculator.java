package com.techelevator.ssg.model.calculator;

public class AlienAgeCalculator {
	
	private double earthAge;
	private String planetChoice;
	private double alienAge;
	
	public AlienAgeCalculator (double earthAge, String planetChoice) {
		this.earthAge = earthAge;
		this.planetChoice = planetChoice;
	}

	public double getAlienAge() {
		alienAge = 0;
		switch (planetChoice) {
		case "Mercury" :
			alienAge = earthAge / .24;
			break;
		case "Venus" :
			alienAge = earthAge / .61;
			break;
		case "Earth" :
			alienAge = earthAge / 1;
			break;
		case "Mars" :
			alienAge = earthAge / 1.88;
			break;
		case "Jupiter" :
			alienAge = earthAge / 11.8;
			break;
		case "Saturn" :
			alienAge = earthAge / 29.4;
			break;
		case "Uranus" :
			alienAge = earthAge / 84.1;
			break;
		case "Neptune" :
			alienAge = earthAge / 164.8;
			break;
		}
		
	 return alienAge;
	}
}

	
