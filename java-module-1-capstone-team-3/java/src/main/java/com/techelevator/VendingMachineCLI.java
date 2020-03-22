package com.techelevator;
import java.io.FileNotFoundException;
import java.util.Map;

/**************************************************************************************************************************
*  This is your Vending Machine Command Line Interface (CLI) class
*
*  It is the main process for the Vending Machine
*
*  THIS is where most, if not all, of your Vending Machine interactions should be coded
*  
*  It is instantiated and invoked from the VendingMachineApp (main() application)
*  
*  Your code should be placed in here
***************************************************************************************************************************/
import com.techelevator.view.Menu;         // Gain access to Menu class provided for the Capstone

public class VendingMachineCLI {

    // Main menu options defined as constants

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE      = "Purchase";
	private static final String MAIN_MENU_OPTION_EXIT          = "Exit";
	private static final String MAIN_MENU_OPTION_SALES_REPORT  = "Print Sales Report";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS,
													    MAIN_MENU_OPTION_PURCHASE,
													    MAIN_MENU_OPTION_EXIT,
													    MAIN_MENU_OPTION_SALES_REPORT
													    };
	
	private static final String PURCHASE_MENU_OPTION_FEED_MONEY = "Feed Money";
	private static final String PURCHASE_MENU_OPTION_SELECT_PRODUCT = "Select Product";
	private static final String PURCHASE_MENU_OPTION_FINISH_TRANSACTION = "Finish Transaction";
	private static final String[] PURCHASE_MENU_OPTIONS = { PURCHASE_MENU_OPTION_FEED_MONEY,
															PURCHASE_MENU_OPTION_SELECT_PRODUCT,
															PURCHASE_MENU_OPTION_FINISH_TRANSACTION
															
														  };
	
	
	
	private Menu vendingMenu;              // Menu object to be used by an instance of this class
	
	private VendingMachine aVendingMachine;
	
	public VendingMachineCLI(Menu menu) throws FileNotFoundException {  // Constructor - user will pas a menu for this class to use
		this.vendingMenu = menu;
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
	 * @throws FileNotFoundException 
	*
	***************************************************************************************************************************/

	public void run() throws FileNotFoundException {

		boolean shouldProcess = true;         // Loop control variable
		
		while(shouldProcess) {                // Loop until user indicates they want to exit
			
			String choice = (String)vendingMenu.getChoiceFromOptions(MAIN_MENU_OPTIONS);  // Display menu and get choice
			
			switch(choice) {                  // Process based on user menu choice
			
				case MAIN_MENU_OPTION_DISPLAY_ITEMS:
					displayItems();           // invoke method to display items in Vending Machine
					break;                    // Exit switch statement
			
				case MAIN_MENU_OPTION_PURCHASE:
					purchaseItems();
					break;// Loop control variable
					
					                                      // invoke method to purchase items from Vending Machine
					                   // Exit switch statement
			
				case MAIN_MENU_OPTION_EXIT:
					endMethodProcessing();    // Invoke method to perform end of method processing
					shouldProcess = false;    // Set variable to end loop
					break;    
					
				case MAIN_MENU_OPTION_SALES_REPORT:
					aVendingMachine.printSalesReport();
					
					break;
					// Exit switch statement
			}	
		}
		return;                               // End method and return to caller
	}
/********************************************************************************************************
 * Methods used to perform processing
 * @throws FileNotFoundException 
 ********************************************************************************************************/
	public void displayItems() {{	
			aVendingMachine.getProducts();
		}
	}
	 
	public void purchaseItems() {
		aVendingMachine.getCurrentMoney();
		boolean shouldProcess2 = true;
		while(shouldProcess2) {                // Loop until user indicates they want to exit
			
			String choice2 = (String)vendingMenu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);  // Display menu and get choice
			
			switch(choice2) {                  // Process based on user menu choice
			
				case PURCHASE_MENU_OPTION_FEED_MONEY:
					aVendingMachine.getTheMoney();           // invoke method to display items in Vending Machine
					break;                    // Exit switch statement
			
				case PURCHASE_MENU_OPTION_SELECT_PRODUCT:
					aVendingMachine.productSelect();          // invoke method to purchase items from Vending Machine
					break;                    // Exit switch statement
			
				case PURCHASE_MENU_OPTION_FINISH_TRANSACTION:
					aVendingMachine.endTransaction();// Invoke method to perform end of method processing
					shouldProcess2 = false;    // Set variable to end loop
					break;                    // Exit switch statement
			}
			aVendingMachine.getCurrentMoney();
		}
		return;  
	}
	
	public void endMethodProcessing() { 
		aVendingMachine.closeLogFile();// static attribute used as method is not associated with specific object instance
		// Any processing that needs to be done before method ends
	}
}
