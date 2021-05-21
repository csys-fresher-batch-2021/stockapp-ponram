package in.ponram.validator;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestUserManagerValidation {

	/**
	 * Test case for user name is null password is not empty and not null
	 */
	@Test
	public void testWhetherTheUserNameNullPasswordIsFilled() {
		
		try {
			UserManagerValidation.rejectIfValueEmpty(null,"Password@12");
		}
		catch(Exception e) {
			assertEquals("User name shouldn't empty", e.getMessage());
		}
	}
	
	/**
	 * Test case for user name is null password is not empty and not null
	 */
	@Test
	public void testWhetherTheUserNameEmptyPasswordIsFilled() {
		try {
			UserManagerValidation.rejectIfValueEmpty(" ","Password@12");
		}
		catch(Exception e) {
			assertEquals("User name shouldn't empty", e.getMessage());
		}
	}
	
	/**
	 * Test case for password is null user name is not empty and not null
	 */
	@Test
	public void testWhetherThePasswordNullUserNameIsFilled() {
		
		try {
			UserManagerValidation.rejectIfValueEmpty("Adbc",null);
		}
		catch(Exception e) {
			assertEquals("Password shouldn't empty", e.getMessage());
		}
	}
	
	/**
	 * Test case for password is null user name is not empty and not null
	 */
	@Test
	public void testWhetherThePasswordEmptyUserNameIsFilled() {
		try {
			UserManagerValidation.rejectIfValueEmpty("abcd","  ");
		}
		catch(Exception e) {
			assertEquals("Password shouldn't empty", e.getMessage());
		}
	}
	
	/**
	 * Test case for user name is valid
	 */
	@Test
	public void testIfBothUserNameAndPasswordIsFilled() {
		boolean valid = false;
		try {
			valid = UserManagerValidation.rejectIfValueEmpty("abcde","Password@123");
			assertTrue(valid);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Test case for user name is null
	 */
	@Test
	public void testWhetherTheUserNameNull() {
		
		try {
			UserManagerValidation.checkUserName(null);
		}
		catch(Exception e) {
			assertEquals("User name shouldn't empty", e.getMessage());
		}
	}
	
	/**
	 * Test case for user name is null
	 */
	@Test
	public void testWhetherTheUserNameEmpty() {
		try {
			UserManagerValidation.checkUserName("  ");
		}
		catch(Exception e) {
			assertEquals("User name shouldn't empty", e.getMessage());
		}
	}
	
	/**
	 * Test case for user name is valid
	 */
	@Test
	public void testWithValidUserName() {
		boolean valid = false;
		try {
			valid = UserManagerValidation.checkUserName("abcde");
			assertTrue(valid);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Test case for Address is null
	 */
	@Test
	public void testWhetherTheAddressNull() {
		
		try {
			UserManagerValidation.checkAddress(null);
		}
		catch(Exception e) {
			assertEquals("Address shouldn't empty", e.getMessage());
		}
	}
	
	/**
	 * Test case for Address is empty
	 */
	@Test
	public void testWhetherTheAddressEmpty() {
		try {
			UserManagerValidation.checkAddress("  ");
		}
		catch(Exception e) {
			assertEquals("Address shouldn't empty", e.getMessage());
		}
	}
	
	/**
	 * Test case for Address is valid
	 */
	@Test
	public void testWithValidAddress() {
		boolean valid = false;
		try {
			valid = UserManagerValidation.checkAddress("madurai");
			assertTrue(valid);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Test case for Gender is null
	 */
	@Test
	public void testWhetherTheGenderNull() {
		
		try {
			UserManagerValidation.checkGender(null);
		}
		catch(Exception e) {
			assertEquals("Gender shouldn't empty", e.getMessage());
		}
	}
	
	/**
	 * Test case for Gender is null
	 */
	@Test
	public void testWhetherTheGenderEmpty() {
		try {
			UserManagerValidation.checkGender("  ");
		}
		catch(Exception e) {
			assertEquals("Gender shouldn't empty", e.getMessage());
		}
	}
	
	/**
	 * Test case for Gender is valid(male or female)
	 */
	@Test
	public void testWithValidGender() {
		boolean valid = false;
		try {
			valid = UserManagerValidation.checkAddress("male");
			assertTrue(valid);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Test case for email is null
	 */
	@Test
	public void testWhetherTheEmailNull() {
		
		try {
			UserManagerValidation.checkEmail(null);
		}
		catch(Exception e) {
			assertEquals("Email shouldn't empty", e.getMessage());
		}
	}
	
	/**
	 * Test case for email is null
	 */
	@Test
	public void testWhetherTheEmailEmpty() {
		try {
			UserManagerValidation.checkEmail("  ");
		}
		catch(Exception e) {
			assertEquals("Email shouldn't empty", e.getMessage());
		}
	}
	
	/**
	 * Test case for email is valid
	 */
	@Test
	public void testWithValidEmail() {
		boolean valid = false;
		try {
			valid = UserManagerValidation.checkEmail("male");
			assertTrue(valid);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Test case for password is null
	 */
	@Test
	public void testWhetherThePasswordNull() {
		
		try {
			UserManagerValidation.checkPassword(null);
		}
		catch(Exception e) {
			assertEquals("Password shouldn't empty", e.getMessage());
		}
	}
	
	/**
	 * Test case for password is null
	 */
	@Test
	public void testWhetherThePasswordEmpty() {
		try {
			UserManagerValidation.checkPassword("  ");
		}
		catch(Exception e) {
			assertEquals("Password shouldn't empty", e.getMessage());
		}
	}
	
	/**
	 * Test case for password is valid
	 */
	@Test
	public void testWithValidPassword() {
		boolean valid = false;
		try {
			valid = UserManagerValidation.checkPassword("male");
			assertTrue(valid);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
