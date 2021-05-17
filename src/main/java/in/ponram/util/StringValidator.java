package in.ponram.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringValidator {
	
	private StringValidator() {
		//Default constructor
	}
	/**
	 * This method used to check string should not empty and null
	 * 
	 * @param value
	 * @return
	 */
	public static boolean isValidString(String value) {

		boolean valid = false;
		if (value != null && !value.trim().equals("")) {
			valid = true;
		}
		return valid;
	}

	/**
	 * User name doesn't be empty To validate user name should contain minimum of 4
	 * character and max 10 character
	 * 
	 * @param userName
	 * @return
	 */
	public static boolean isValidUsername(String userName) {

		boolean valid = false;
		if (userName.length() >= 3 && userName.length() <= 10) {
			valid = true;
		} else {
			throw new RuntimeException("Insufficient user name length(min 4 and max 10)");
		}
		return valid;
	}

	/**
	 * Validate the password would contain, minimum of 8 character maximum of 20
	 * characters Small and capital Alphabets Some numerical Some special character
	 * And no whitespace character should be accepted
	 * 
	 * @param password
	 * @return boolean value
	 */
	public static boolean isValidPassword(String password) {

		String check = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%])(?=\\S+$).{8,20}$";
		Pattern p = Pattern.compile(check);
		Matcher m = p.matcher(password);
		if (m.matches()) {
			return true;
		} else {
			throw new RuntimeException("Insufficient password characters");
		}
	}

}
