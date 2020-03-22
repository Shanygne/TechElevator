package com.techelevator;

public class KataStringCalculator {

	// CONSTRUCTORS
	public KataStringCalculator() {
	}

	// METHOD
	public int add(String numbers) {
		if (numbers.equals("")) {
			numbers = "0";
			int A = Integer.parseInt(numbers);
			return A;
		} else {
			String[] numberArray = numbers.replaceAll("\n", ",").split(",");
			int C = 0;
			if(numberArray.length == 1) {
				return Integer.parseInt(numbers);
			}
			for (int i = 0; i < numberArray.length; i++) {
				C += Integer.parseInt(numberArray[i]);
			}
			return C; 
			}
		}
}
