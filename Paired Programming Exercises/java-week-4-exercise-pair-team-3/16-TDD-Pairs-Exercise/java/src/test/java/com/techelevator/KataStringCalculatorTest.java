package com.techelevator;

import org.junit.*;
import static org.junit.Assert.*;

public class KataStringCalculatorTest {

	@Test
	public void Test_For_Empty_String() {
		KataStringCalculator testObject = new KataStringCalculator();
		assertEquals("Did not return 0", 0, testObject.add("0"));
	}

	@Test
	public void Test_For_Single_Digit() {
		KataStringCalculator testObject = new KataStringCalculator();
		assertEquals("Did not return 1", 1, testObject.add("1"));
	}

	@Test
	public void Test_For_Two_Digits() {
		KataStringCalculator testObject = new KataStringCalculator();
		assertEquals("Did not return 3", 3, testObject.add("1,2"));
	}
	
	@Test
	public void Test_For_Multiple_Digits() {
		KataStringCalculator testObject = new KataStringCalculator();
		assertEquals("Did not return 24", 24, testObject.add("5,7,12"));
	}
	
	@Test
	public void Test_For_Multiple_Digits_With_Spaces() {
		KataStringCalculator testObject = new KataStringCalculator();
		assertEquals("Did not return 10", 10, testObject.add("5\n3,2"));
	}
}
