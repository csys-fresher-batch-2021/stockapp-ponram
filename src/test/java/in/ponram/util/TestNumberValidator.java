package in.ponram.util;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestNumberValidator {

	/**
	 * Number validation
	 */
	// if given number is less than 0
	@Test
	public void testNumberIsLessThanZero() {

		boolean valid = NumberValidator.isValidNumber(-1);
		assertFalse(valid);
	}

	// if given number is equals to 0
	@Test
	public void testNumberIsEqualToZero() {

		boolean valid = NumberValidator.isValidNumber(0);
		assertFalse(valid);
	}

	// if given number is greater than 0
	@Test
	public void testNumberIsGreaterThanZero() {

		boolean valid = NumberValidator.isValidNumber(1);
		assertTrue(valid);
	}
}
