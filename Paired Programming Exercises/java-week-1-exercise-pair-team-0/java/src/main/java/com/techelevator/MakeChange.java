package com.techelevator;

import java.util.Scanner;

/*
 Write a command line program which prompts the user for the total bill, and the amount tendered. It should then
 display the change required.

 $ java MakeChange
 Please enter the amount of the bill: 23.65
 Please enter the amount tendered: 100.00
 The change required is 76.35
 */
public class MakeChange {

	public static void main(String[] args) {
	System.out.println("Welcome to Make Change");
	
	String amountOfBill = "";
	String amountTendered = "";
	
	Scanner changeMachine = new Scanner(System.in);
	
	System.out.println("Please enter amount of the bill ");
	amountOfBill = changeMachine.nextLine();
	System.out.println("You entered " + amountOfBill);
	
	System.out.println("Please enter amount tendered ");
	amountTendered = changeMachine.nextLine();
	System.out.println("You paid " + amountTendered);
	
	double change = Double.parseDouble(amountTendered) - Double.parseDouble(amountOfBill);
	
	System.out.println("The change required is " + change);

	}

}
