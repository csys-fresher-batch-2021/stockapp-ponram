package in.ponram.util;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestEmailvalidator {


	@Test
	public void testInvalidEmail1() {

		try {

			EmailValidator.isValidEmail("@gamil.com");
		} catch (Exception e) {

			assertEquals("Invalid email format", e.getMessage());
		}
	}

	@Test
	public void testInvalidEmail2() {
		
		try {

			EmailValidator.isValidEmail("example.gmail.com");
		} catch (Exception e) {

			assertEquals("Invalid email format", e.getMessage());
		}
	}

	@Test
	public void testValidEmail1() {
		
		try {

			boolean valid = EmailValidator.isValidEmail("example@gmail.com");
			assertTrue(valid);
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	@Test
	public void testValidEmail2() {
		
		try {

			boolean valid = EmailValidator.isValidEmail("ecample#12@gmail.com");
			assertTrue(valid);
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

}
