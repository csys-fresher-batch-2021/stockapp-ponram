package in.ponram.util;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestPasswordValidator {

	/**
	 * Test case for password without number
	 */
	@Test
	public void testPasswordWithoutNumber() {
		try {

			PasswordValidator.isValidPassword("ABc@#def");
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

			PasswordValidator.isValidPassword("ABc12def");
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

			PasswordValidator.isValidPassword("ABC@#123");
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

			PasswordValidator.isValidPassword("abc@#123");
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

			PasswordValidator.isValidPassword("Abc@123");
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

			PasswordValidator.isValidPassword("AbCdefh@123453#89xaVdQ");
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

			valid = PasswordValidator.isValidPassword("Abcd#@1234");
			assertTrue(valid);
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

}
