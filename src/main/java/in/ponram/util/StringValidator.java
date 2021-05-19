package in.ponram.util;



import in.ponram.exception.UserDetailException;

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
	 * User name should contain minimum of 3 character and max 10 character
	 * 
	 * @param userName
	 * @return
	 */
	public static boolean isValidUsername(String userName) {

		boolean valid = false;
		if (userName.length() >= 3 && userName.length() <= 10) {
			valid = true;
		} else {
			throw new UserDetailException("Insufficient user name length(min 4 and max 10)");
		}
		return valid;
	}
	
	/**
	 * Address should contain minimum of 4 character and max 10 character
	 * @param address
	 * @return
	 */
	public static boolean isValidAddress(String address) {
		
		if (address.length() >= 4 && address.length() <= 20) {
			return true;
		} else {
			throw new UserDetailException("Invalid Address format");
		}
	}

	/**
	 * Gender does't be empty Gender should be either male or female
	 * 
	 * @param gender
	 * @return
	 */
	public static boolean isValidGender(String gender) {

		boolean valid = false;
		if (isValidString(gender)) {
			if (gender.equalsIgnoreCase("male") || gender.equalsIgnoreCase("female")) {
				valid = true;
			}
		} else {
			throw new UserDetailException("Invalid gender type");
		}
		return valid;
	}
}
