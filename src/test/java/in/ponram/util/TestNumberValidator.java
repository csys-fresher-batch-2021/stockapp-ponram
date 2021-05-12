package in.ponram.util;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestNumberValidator {

	/**
	 * Test case for given number is less than 0
	 */
	@Test
	public void testNumberIsLessThanZero() {

		boolean valid = NumberValidator.isValidNumber(-1);
		assertFalse(valid);
	}

	/**
	 * Test case for given number is equals to 0
	 */
	@Test
	public void testNumberIsEqualToZero() {

		boolean valid = NumberValidator.isValidNumber(0);
		assertFalse(valid);
	}

	/**
	 * Test case for given number is greater than 0
	 */
	@Test
	public void testNumberIsGreaterThanZero() {

		boolean valid = NumberValidator.isValidNumber(1);
		assertTrue(valid);
	}
}
