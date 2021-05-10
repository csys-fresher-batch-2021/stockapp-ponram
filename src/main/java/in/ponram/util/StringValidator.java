package in.ponram.util;

public class StringValidator {

	/**
	 * This method used to check string should not empty and null
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
}

