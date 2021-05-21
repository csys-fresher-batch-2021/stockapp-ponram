package in.ponram.service;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import in.ponram.model.User;


public class TestUserManager {
			
	@BeforeClass
	public static void testRegistration() {
		User user1 = new User("Ponram",8903117739L,"Thoothukudi","Male","ponram2503@gmail.com","Ponram@123");

		User user2 = new User("Siva",9302116632L,"Thoothukudi","Male","siva@gmail.com","SiVa#123");

		User user3 = new User("Raja",7658934121L,"chennai","Male","raja@gmail.com","Raja$123");

		UserManager.registration(user1, user2, user3);

	}
	@Test
	public void testRegister(){
		User user = new User("Karthi",8555555555L,"Thoothukudi","Male","Karthi@gmail.com","Karthi@123");

		boolean valid = UserManager.registration(user);

		assertTrue(valid);
	}
	
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
	
	@Test
	public void testWithInvalidUserLogin() {
		
		try {
			
			UserManager.login("Raguram","Ponram@123");
		} catch (Exception e) {
			
			assertEquals("User not found", e.getMessage());
		}
	}
	
	@Test
	public void testWithInvalidAdmin() {
		
		try {
			UserManager.adminLogin("Ponram","Ponram@123");
		} catch (Exception e) {
			e.printStackTrace();
			assertEquals("User is not an admin", e.getMessage());
		}
	}
	
	@Test
	public void testWithValidAdmin() {
		
		boolean valid = false;
		try {
			
			valid = UserManager.adminLogin("Admin","Admin@123");
			assertTrue(valid);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
}
