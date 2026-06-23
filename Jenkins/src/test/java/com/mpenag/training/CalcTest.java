package com.mpenag.training;

import org.junit.Test;

import static org.junit.Assert.*;

//import org.testng.annotations.Test;

public class CalcTest {
	@Test
	public void addTest() {
		Calculator myCalc = new Calculator();
		assertEquals(10, myCalc.addNumbers(5, 5));
	}

	@Test
	public void subtractTest() {
		Calculator myCalc = new Calculator();
		assertEquals(5, myCalc.subtractNumbers(10, 5));
	}
}
