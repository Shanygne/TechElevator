package com.techelevator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Scanner;

public class WordCount {

	public static void main(String[] args) throws IOException {
		String fileName = "alices_adventures_in_wonderland.txt";

		File aliceFile = new File(fileName);

		Scanner aliceFileScanner = new Scanner(aliceFile);
		int wordCount = 0;
		int sentenceCount = 0;

		while (aliceFileScanner.hasNextLine()) {
			String fileLine = aliceFileScanner.nextLine();

			String[] wordArray = fileLine.split(" ");

			for (int i = 0; i < wordArray.length; i++) {

				if (wordArray[i].length() >= 1) {
					wordCount++;
				}
				if (wordArray[i].contains(".")) {
					sentenceCount++;
				}
				if (wordArray[i].contains("!")) {
					sentenceCount++;
				}
				if (wordArray[i].contains("?")) {
					sentenceCount++;
				}
				if (wordArray[i].contains("I.")) {
					sentenceCount--;
				}
				if (wordArray[i].contains("V.")) {
					sentenceCount--;
				}
				if (wordArray[i].contains("X.")) {
					sentenceCount--;
				}

			} // for loop ends

		} // while loop ends
		System.out.println("Word Count is: " + wordCount);

		System.out.println("Sentence Count is: " + sentenceCount);

	}

}
