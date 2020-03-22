package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class VendingMachine {
	Scanner theKeyboard = new Scanner(System.in); // keyboard input
	String billChoice = "";
	double currentMoney = 0.0;
	double userBills = 0.0;
	double totalSales = 0.0;
	String userSelect = "";
	int qty = 5;
	DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
	Date dateObj = new Date();
	File log = new File ("Log.txt");
	PrintWriter logWriter = new PrintWriter(log); 
	
	 
	
	private static Map<String, String> productMap = new LinkedHashMap<String, String>();

	public VendingMachine() throws FileNotFoundException {
		this.vendingFileReader();
	}
	
	// METHODS
	
	public void productSelect() {
		try {
			
		getProducts();
		System.out.println("Please make a selection");
		userSelect = theKeyboard.nextLine();
		
		String userPurchase = productMap.get(userSelect);
		try {
		String[] purchaseArray = userPurchase.split(",");
		
		qty = Integer.parseInt(purchaseArray[3]);
		
		int newQty = Integer.parseInt(purchaseArray[3]);
		double thePrice = Double.parseDouble(purchaseArray[1]);
		if (currentMoney >= thePrice) {
			currentMoney = currentMoney - thePrice;
			totalSales = totalSales + thePrice;
			logWriter.println(df.format(dateObj) +" "+ purchaseArray[0] +" "+ userSelect + " $" + userBills + " $" + currentMoney);
			if (newQty == 1) {
				productMap.replace(userSelect, purchaseArray[0] +","+  purchaseArray[1] +","+ purchaseArray[2] +","+ "SOLD OUT");
			}
			else {
			productMap.replace(userSelect, purchaseArray[0] +","+  purchaseArray[1] +","+ purchaseArray[2] +","+ (newQty -1));
			}
		if(purchaseArray[2].equals("Chip")) {
			
			System.out.println("Crunch Crunch, Yum!");
		}
		
		if(purchaseArray[2].equals("Candy")) {
			
			System.out.println("Munch Munch, Yum!");
		}
		
		if(purchaseArray[2].equals("Drink")) {
			
			System.out.println("Glug Glug, Yum!");
		}

		if(purchaseArray[2].equals("Gum")) {
			
			System.out.println("Chew Chew, Yum!");
		}
		}
		else {
			System.out.println("Insufficient funds.");
			
		}
		}catch (NumberFormatException e) {
			System.out.println("This product is SOLD OUT please select something else.");
		}
		}catch (NullPointerException e1) {
			System.out.println("That product code does not exist.");
		} 
	}
	
	
	public void vendingFileReader() throws FileNotFoundException {
		File vendingFile = new File("vendingmachine.csv");
		Scanner vendingFileScanner = new Scanner(vendingFile);
		

		while (vendingFileScanner.hasNextLine()) {
			String fileLine = vendingFileScanner.nextLine();
			String[] productArray = fileLine.split("\\|");
			String valueString = "";
			if(qty < 5) {
			valueString = productArray[1] + "," + productArray[2] + "," + productArray[3] + "," + qty;
			}
			else {
				valueString = productArray[1] + "," + productArray[2] + "," + productArray[3] + "," + "5";
			}
			productMap.put(productArray[0], valueString);
		}
		vendingFileScanner.close();
	}

	public void getProducts() {
		Set<String> keys = productMap.keySet();
		for (String products : keys) {
			System.out.println(products + "," + productMap.get(products));
		}
	}

	public void getTheMoney() {
		
		do {
			System.out.println("What size bill would you like to put in? (1, 2, 5, 10)");
			userBills = (double) theKeyboard.nextInt();
			theKeyboard.nextLine(); // clear the keyboard buffer
			if (userBills != 1 && userBills != 2 && userBills != 5 && userBills != 10) {
				System.out.println("Please enter a whole dollar amount (1, 2, 5, or 10)");	
			}
			else {
			
			currentMoney = currentMoney + userBills;
			logWriter.println(df.format(dateObj) + " FEED MONEY " + "$" + userBills + " $" + currentMoney);
			System.out.println("You're current balance is $" + currentMoney);

			System.out.println("Would you like to put in any more? (Y/N)");

			billChoice = theKeyboard.nextLine();
			}
		} while ((billChoice.equals("y")) || (billChoice.equals("Y")));
		}
		
	
	
	public void endTransaction() {
		int quarter = 0;
		int dime = 0;
		int nickel = 0;
		int pennies = (int) (currentMoney *100);
		while (pennies >= 25) {
			pennies = pennies - 25;
			quarter++;
		};
		
		while (pennies >= 10) {
			pennies = pennies - 10;
			dime++;
		};
		
		while (pennies >= 5) {
			pennies = pennies - 5;
			nickel++;
		};
		
		Double moneyLeft = (double) (pennies/100);
		    logWriter.println(df.format(dateObj) +" GIVE CHANGE " + "$" + currentMoney + " $" + moneyLeft);
		    currentMoney = pennies/100;
			System.out.println("Here's your change: \n" + quarter+ " Quarters\n" + dime + " Dimes\n" + nickel+ " Nickels");
		}
	
	
	public void printSalesReport() throws FileNotFoundException {
		String salesName = df.format(dateObj).replace("/", "-") + "Sales Report.txt";
		File salesReport = new File (salesName); 
		PrintWriter salesWriter = new PrintWriter(salesReport);
		
		Set<String> keys = productMap.keySet();
		for (String products : keys) {
			
			String[] salesArray = productMap.get(products).split(",");
			int productLeft = 5 - Integer.parseInt(salesArray[3]);
			salesWriter.println(salesArray[0] + ", " + productLeft);
		}
			salesWriter.println();
			salesWriter.println("Total Sales: $" + totalSales);
		salesWriter.close();
	}
	
	public void getCurrentMoney() {
		System.out.println("Current Money: $" + currentMoney);
	}
	
	public void closeLogFile() {
		logWriter.close();
		System.out.println("Thank you for using this Vending Machine! Goodbye!");
		
	}
}
	
	



	
		
	


		
	
	
	
	
	


