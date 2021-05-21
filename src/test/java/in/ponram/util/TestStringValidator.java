package in.ponram.util;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestStringValidator {

	/**
	 * Test case for empty string input
	 */
	@Test
	public void testWithEmptyInput() {
		try {

			StringValidator.isValidString(" ","Test case for empty string input");
		} catch (Exception e) {

			assertEquals("Test case for empty string input", e.getMessage());
		}
	}

	/**
	 * Test case for input is null
	 */
	@Test
	public void testWithNullInput() {
		try {

			StringValidator.isValidString(null,"Test case for input is null");
		} catch (Exception e) {

			assertEquals("Test case for input is null", e.getMessage());
		}

	}

	/**
	 * Test case for valid string input
	 */
	@Test
	public void testWithValidInput() {
		try {

			boolean valid = StringValidator.isValidString("mobile","No exception");
			assertTrue(valid);
		} catch (Exception e) {

			e.printStackTrace();
		}
	}
	
	/**
	 * Test case for user name is less than three
	 */
	@Test
	public void testWithUserNameLessThanThree() {
		try {

			StringValidator.isValidUsername("ab");
		} catch (Exception e) {

			assertEquals("Insufficient user name length(min 4 and max 10)", e.getMessage());
		}
	}

	/**
	 * Test case for user name is greater than ten
	 */
	@Test
	public void testWithUserNameGreaterThanTen() {
		try {

			StringValidator.isValidUsername("abcdefghijk");
		} catch (Exception e) {

			assertEquals("Insufficient user name length(min 4 and max 10)", e.getMessage());
		}
	}

	/**
	 * Test case for user name is greater than three and less than ten
	 */
	@Test
	public void testWithUserNameGreaterThanThreeLessThanten() {
		
		boolean valid = false;
		try {
			
			valid =  StringValidator.isValidUsername("abcdefgh");			
			assertTrue(valid);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

	@Test
	public void testInvalidGender1() {

		try {

			StringValidator.isValidGender("mela");
		} catch (Exception e) {

			assertEquals("Invalid gender type", e.getMessage());
		}
	}

	@Test
	public void testInvalidGender2() {
		
		try {

			StringValidator.isValidGender("erf");
		} catch (Exception e) {

			assertEquals("Invalid gender type", e.getMessage());
		}
	}

	@Test
	public void testValidGender1() {
		
		try {

			boolean valid = StringValidator.isValidGender("male");
			assertTrue(valid);
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	@Test
	public void testValidGender2() {
		
		try {

			boolean valid = StringValidator.isValidGender("female");
			assertTrue(valid);
		} catch (Exception e) {

			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 */
	@Test
	public void testWithAddresLengthIsLessThanFour() {

		try {

			StringValidator.isValidAddress("abc");
		} catch (Exception e) {

			assertEquals("Invalid Address format", e.getMessage());
		}
	}

	@Test
	public void testWithAddresLengthIsGreaterThanTwenty() {
		
		try {

			StringValidator.isValidAddress("qwertyckjsdciudciwchiwuhckskcmsjdckjdscksdjcksjsjgdygus");
		} catch (Exception e) {

			assertEquals("Invalid Address format", e.getMessage());
		}
	}

	@Test
	public void testWithAddresLengthIsGreaterThanFourLessThanTen() {
		
		try {

			boolean valid = StringValidator.isValidAddress("vijayaramapuram");
			assertTrue(valid);
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

}
