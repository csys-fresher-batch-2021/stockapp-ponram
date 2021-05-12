package in.ponram.util;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestStringValidator {

	/**
	 * Test case for empty string input
	 */
	@Test
	public void testWithEmptyInput() {
		boolean valid = StringValidator.isValidString("  ");
		assertFalse(valid);
	}

	/**
	 * Test case for null
	 */
	@Test
	public void testWithNullInput() {
		boolean valid = StringValidator.isValidString(null);
		assertFalse(valid);

	}

	/**
	 * Test case for valid string input
	 */
	@Test
	public void testWithValidInput() {
		boolean valid =  StringValidator.isValidString("mobile");
		assertTrue(valid);
	}
}
