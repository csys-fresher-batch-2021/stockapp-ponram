package in.ponram.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import in.ponram.exception.UserDetailException;

public class EmailValidator {

	private EmailValidator() {
		//Default constructor
	}
	/**
	 * Email format should be, digits�0 to 9 lower case and upper letters � a to z
	 * and A to Z Some special characters After @ symbol use domain name for email
	 * address with same alphabet and digit's criteria Furthermore, the domain name
	 * section of the email address may consist of, digits�0 to 9 lower case and
	 * upper letters � a to z
	 * 
	 * @param email
	 * @return
	 */
	public static boolean isValidEmail(String email) {

		String check = "^[a-zA-Z0-9_!#$%&.-]+@[a-zA-Z0-9.-]+$";
		Pattern p = Pattern.compile(check);
		Matcher m = p.matcher(email);		
		if (m.matches()) {
			return true;
		} else {
			throw new UserDetailException("Invalid email format");
		}
	}
}
