package in.ponram.util;

public class NumberValidator {

	private NumberValidator(){
		//Default Constructor
	}
	/**
	 * This method used to check quantity and rate should greater than zero
	 * 
	 * @param value
	 * @return true whether the value is greater then zero
	 */
	public static boolean isValidNumber(int value) {

		boolean valid = false;
		if (value > 0) {
			valid = true;
		}
		return valid;
	}
	
	
	public static int parseInt(String input, String errorMessage) {
		try {
			return  Integer.parseInt(input);
		}
		catch(NumberFormatException e) {
			throw new RuntimeException(errorMessage);
		}
	}
}
