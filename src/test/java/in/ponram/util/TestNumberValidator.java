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
	
	/**
	 * if mobile number is equals to 10 digits
	 */
	
	@Test
	public void testMobileNumberIsEqualToTenDigit() {
		
		boolean valid = false;
		try {

			valid = NumberValidator.isValidMobileNumber("88888888");
			assertTrue(valid);
		} catch (Exception e) {

			e.printStackTrace();
		}
	}
	
	/**
	 * if mobile number is Less than 10 digits
	 */
	@Test
	public void testMobileNumberIsLessThanTenDigit() {
		
		
		try {

			NumberValidator.isValidMobileNumber("8888888");
		} catch (Exception e) {

			assertEquals("Mobile number format is invalid", e.getMessage());
		}
		
	}
	
	/**
	 * if mobile number is Greater than 10 digits
	 */
	@Test
	public void testMobileNumberIsGreaterThanTenDigit() {
		
		
		try {

			NumberValidator.isValidMobileNumber("88888888888");
		} catch (Exception e) {

			assertEquals("Mobile number format is invalid", e.getMessage());
		}
		
	}
}
