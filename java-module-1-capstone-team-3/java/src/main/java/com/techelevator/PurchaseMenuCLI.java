package com.techelevator;

import java.io.FileNotFoundException;

import com.techelevator.view.Menu;

public class PurchaseMenuCLI {
	
	private static final String PURCHASE_MENU_OPTION_FEED_MONEY = "Feed Money";
	private static final String PURCHASE_MENU_OPTION_SELECT_PRODUCT = "Select Product";
	private static final String PURCHASE_MENU_OPTION_FINISH_TRANSACTION = "Finish Transaction";
	private static final String[] PURCHASE_MENU_OPTIONS = { PURCHASE_MENU_OPTION_FEED_MONEY,
															PURCHASE_MENU_OPTION_SELECT_PRODUCT,
															PURCHASE_MENU_OPTION_FINISH_TRANSACTION
															
														  };

	
    private Menu purchaseMenu;             // Menu object to be used by an instance of this class
	
    private VendingMachine aVendingMachine;
	
	public PurchaseMenuCLI(Menu menu) throws FileNotFoundException  {  // Constructor - user will pas a menu for this class to use
		this.purchaseMenu = menu;
		this.aVendingMachine = new VendingMachine();// Make the Menu the user object passed, our Menu
	}
	/**************************************************************************************************************************
	*  VendingMachineCLI main processing loop
	*  
	*  Display the main menu and process option chosen
	*
	*  It is invoked from the VendingMachineApp program
	*
	*  THIS is where most, if not all, of your Vending Machine objects and interactions 
	*  should be coded
	*
	*  Methods should be defined following run() method and invoked from it
	*
	***************************************************************************************************************************/

	public void run() {

		boolean shouldProcess = true;         // Loop control variable
		
		while(shouldProcess) {                // Loop until user indicates they want to exit
			
			String choice = (String)purchaseMenu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);  // Display menu and get choice
			
			switch(choice) {                  // Process based on user menu choice
			
				case PURCHASE_MENU_OPTION_FEED_MONEY:
					feedMoney();           // invoke method to display items in Vending Machine
					break;                    // Exit switch statement
			
				case PURCHASE_MENU_OPTION_SELECT_PRODUCT:
					selectProduct();          // invoke method to purchase items from Vending Machine
					break;                    // Exit switch statement
			
				case PURCHASE_MENU_OPTION_FINISH_TRANSACTION:
					endMethodProcessing();    // Invoke method to perform end of method processing
					shouldProcess = false;    // Set variable to end loop
					break;                    // Exit switch statement
			}	
		}
		return;                               // End method and return to caller
	}
/********************************************************************************************************
 * Methods used to perform processing
 * @throws FileNotFoundException 
 ********************************************************************************************************/
	public void feedMoney() {{	
			
		}
	}
	
	public void selectProduct() {	 
	}
	
	public void endMethodProcessing() { // static attribute used as method is not associated with specific object instance
		// Any processing that needs to be done before method ends
	}
}
