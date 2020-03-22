package com.techelevator.ssg.model.calculator;

public class AlienWeightCalculator {
	
	private double earthWeight;
	private String planetChoice;
	private double alienWeight;
	
	public AlienWeightCalculator (double earthWeight, String planetChoice) {
		this.earthWeight = earthWeight;
		this.planetChoice = planetChoice;
	}

	public double getAlienWeight() {
		alienWeight = 0;
		switch (planetChoice) {
		case "Mercury" :
			alienWeight = earthWeight * .38;
			break;
		case "Venus" :
			alienWeight = earthWeight * .91;
			break;
		case "Earth" :
			alienWeight = earthWeight * 1;
			break;
		case "Mars" :
			alienWeight = earthWeight * .38;
			break;
		case "Jupiter" : 
			alienWeight = earthWeight * 2.34;
			break;
		case "Saturn" :
			alienWeight = earthWeight * 1.06;
			break;
		case "Uranus" :
			alienWeight = earthWeight * 0.92;
			break;
		case "Neptune" :
			alienWeight = earthWeight * 1.19;
			break;
		}
		return alienWeight;
	}
}
