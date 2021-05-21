package in.ponram.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import in.ponram.exception.DAOException;
import in.ponram.exception.ServiceException;
import in.ponram.exception.UtilException;

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
	public static boolean isValidNumber(int value,String message) {

		if (value <= 0) {
			throw new UtilException(message);
		} else {

			return true;
		}
	}
	
	/**
	 * This method is used to convert the string into integer
	 * @param input
	 * @param errorMessage
	 * @return
	 */
	public static int parseInt(String input, String errorMessage) {
		try {
			return  Integer.parseInt(input);
		}
		catch(NumberFormatException e) {
			throw new DAOException(errorMessage);
		}
	}
	
	/**
	 * This method is used to convert the string into Long
	 * @param input
	 * @param errorMessage
	 * @return
	 */
	public static long parseLong(String input, String errorMessage) {
		try {
			return  Long.parseLong(input);
		}
		catch(NumberFormatException e) {
			throw new DAOException(errorMessage);
		}
	}
	
	/**
	 * Mobile number should not be empty Mobile number should be starting digit in 6
	 * to 9 After 9 number should be any digit between 0 to 9
	 * 
	 * @param mobileNumber
	 * @return true or false
	 */
	public static boolean isValidMobileNumber(String mobileNumber) {

		Pattern p = Pattern.compile("[6-9][0-9]{9}");
		Matcher m = p.matcher(mobileNumber);
		if (m.matches()) {

			return true;
		} else {
			throw new ServiceException("Mobile number format is invalid");
		}
	}
}
