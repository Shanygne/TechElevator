package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FindAndReplace {

	public static void main(String[] args) throws FileNotFoundException {
		String searchWord = "";
		String replacementWord = "";
		String source = "";
		String destination = "";
		
		Scanner theKeyboard = new Scanner(System.in);
		
		System.out.println("What word are you searching for?");
		
		searchWord = theKeyboard.nextLine();
		
		System.out.println("What word would you like to replace it with?");
		
		replacementWord = theKeyboard.nextLine();
		
		System.out.println("Please enter the source file");
		
		source = theKeyboard.nextLine();
		
		System.out.println("Enter a name for the new file");
		
		destination = theKeyboard.nextLine();

		File newFile = new File(destination);

	    String fileName = source;

		File searchFile = new File(fileName);
		Scanner searchFileScanner;

		try {
			searchFileScanner = new Scanner(searchFile);

				try (PrintWriter writer = new PrintWriter(newFile)) {
					while (searchFileScanner.hasNextLine()) {
					String fileLine = searchFileScanner.nextLine();
					String newFileLine = fileLine.replace(searchWord,replacementWord);
					writer.println(newFileLine);

					} 
			} 
				catch (FileNotFoundException e) {
					System.out.println("This is an invalid source file, the program will now exit.");

				}
			
				
				

		} catch (FileNotFoundException e) {
			 
				System.out.println("This is an invalid destination file, the program will now exit.");
			
		} 	
		finally {
			System.exit(0);
		}

		}}
