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

			StringValidator.isValidString("abcdefghijk");
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

	/**
	 * Test case for password without number
	 */
	@Test
	public void testPasswordWithoutNumber() {
		try {

			StringValidator.isValidPassword("ABc@#def");
		} catch (Exception e) {

			assertEquals("Insufficient password characters", e.getMessage());
		}
	}

	/**
	 * Test case for password without special character
	 */
	@Test
	public void testPasswordWithoutSpecialCharacter() {
		try {

			StringValidator.isValidPassword("ABc12def");
		} catch (Exception e) {

			assertEquals("Insufficient password characters", e.getMessage());
		}
	}

	/**
	 * Test case for password without small letter
	 */
	@Test
	public void testPasswordWithoutSmallLetters() {
		try {

			StringValidator.isValidPassword("ABC@#123");
		} catch (Exception e) {

			assertEquals("Insufficient password characters", e.getMessage());
		}
	}

	/**
	 * Test case for password without capital letter
	 */
	@Test
	public void testPasswordWithoutCapitalLetters() {
		try {

			StringValidator.isValidPassword("abc@#123");
		} catch (Exception e) {

			assertEquals("Insufficient password characters", e.getMessage());
		}
	}

	/**
	 * Test case for password length is less than eight
	 */
	@Test

	public void testPasswordLengthIsLessThanEight() {
		try {

			StringValidator.isValidPassword("Abc@123");
		} catch (Exception e) {

			assertEquals("Insufficient password characters", e.getMessage());
		}
	}

	/**
	 * Test case for password length is grater than twenty
	 */
	@Test

	public void testPasswordLengthIsGreaterThanTwenty() {
		try {

			StringValidator.isValidPassword("AbCdefh@123453#89xaVdQ");
		} catch (Exception e) {

			assertEquals("Insufficient password characters", e.getMessage());
		}
	}

	/**
	 * Test case for password with valid input
	 */
	@Test

	public void testPasswordWithValidInput() {
		boolean valid = false;
		try {
			
			valid = StringValidator.isValidPassword("Abcd#@1234");
			assertTrue(valid);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}

}
