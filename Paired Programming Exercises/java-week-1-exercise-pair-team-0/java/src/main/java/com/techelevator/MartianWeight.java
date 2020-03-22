package com.techelevator;

import java.util.Scanner;

/*
 In case you've ever pondered how much you weight on Mars, here's the calculation:
 	Wm = We * 0.378
 	where 'Wm' is the weight on Mars, and 'We' is the weight on Earth
 
Write a command line program which accepts a series of Earth weights from the user  
and displays each Earth weight as itself, and its Martian equivalent.

 $ MartianWeight 
 
Enter a series of Earth weights (space-separated): 98 235 185
 
 98 lbs. on Earth, is 37 lbs. on Mars.
 235 lbs. on Earth, is 88 lbs. on Mars.
 185 lbs. on Earth, is 69 lbs. on Mars. 
 */
public class MartianWeight {
	
	public static void main(String[] args) {
		
	System.out.println("How Much Would You Weigh On Mars?");
		
	String earthWeight = "";
	String friendsWeight = "";
	Scanner sojourner = new Scanner(System.in);
	
	System.out.println("Enter your weight - on Earth");
	earthWeight = sojourner.nextLine();
	System.out.println("Your weight is " + earthWeight + " on Earth");

	System.out.println("Please enter a series of friend's weights separated by spaces");
	friendsWeight = sojourner.nextLine();
	
	String[] allFriendsWeights = friendsWeight.split(" ");
	double convert = 0.378;
	double martianWeight = 0;
	for(int i=0; i < allFriendsWeights.length; i++) {
		martianWeight = convert * Double.parseDouble(allFriendsWeights[i]);
	
	System.out.println("Your friends' weights on Mars are " + martianWeight);
	}	
	}
	
	
	}


