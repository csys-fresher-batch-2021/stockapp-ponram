package in.ponram.service;

import static org.junit.Assert.*;

import org.junit.Test;


public class TestUserManager {
	
	/**
	 * Test case for valid user name and password
	 */
	@Test
	public void testWithValidUserLogin() {
		
		boolean valid = false;
		try {
			
			valid = UserManager.login("Ponram","Ponram@123");
			assertTrue(valid);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	/**
	 * Test case for invalid user name and password
	 */
	@Test
	public void testWithInvalidUserLogin() {
		
		try {
			
			UserManager.login("Raguram","Ponram@123");
		} catch (Exception e) {
			
			assertEquals("User is not exist", e.getMessage());
		}
	}
}
