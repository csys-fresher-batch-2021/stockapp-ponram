package in.ponram.service;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import in.ponram.model.User;


public class TestUserManager {
	
	@BeforeClass
	public static void testRegistration() {
		User user1 = new User("Ponram",8903117739L,"Male","Thoothukudi","ponram2503@gmail.com","Ponram@123");

		User user2 = new User("Siva",9302116632L,"Male","Thoothukudi","siva@gmail.com","SiVa#123");

		User user3 = new User("Raja",7658934121L,"Male","chennai","raja@gmail.com","Raja$123");

		UserManager.registration(user1, user2, user3);

	}
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
			
			assertEquals("User is not exists", e.getMessage());
		}
	}
}
