package in.ponram.validator;

import java.util.List;

import in.ponram.dao.UserDAO;
import in.ponram.exception.UserDetailException;
import in.ponram.model.User;
import in.ponram.util.EmailValidator;
import in.ponram.util.NumberValidator;
import in.ponram.util.PasswordValidator;
import in.ponram.util.StringValidator;


public class UserManagerValidation {
	
	private UserManagerValidation() {
		//Default constructor
	}
	/**
	 * This method is used to check user details like user name, mobile number, gender, address, email and password
	 * @param user
	 * @return true or false
	 */
	public static boolean isValideUserDetails(User user) {
		boolean success = false;
		if (checkUserName(user.getUserName()) && checkMobileNumber(user.getMobileNumber())
				&& checkGender(user.getGender()) && checkAddress(user.getAddress()) && checkEmail(user.getEmail())
				&& checkPassword(user.getPassword())) {
			success = true;
		}
		return success;
	}
	/**
	 * This method is used to validate login user by,
	 * Check user name and password should not empty
	 * And check the user is exists 
	 * @param userName
	 * @param password
	 * @return
	 */
	public static boolean isValidLogin(String userName, String password) {
		List<User> users = UserDAO.getAllUsers();
		boolean success = false;
		if (checkUserName(userName) && checkPassword(password)) {
			for (User user : users) {
				if(isUserExist(userName, password, user)) {
					success = true;
					break;
				}
			}
		}
		return success;
	}

	/**
	 * This method is used to check user is exists
	 * @param userName
	 * @param password
	 * @param user
	 * @return
	 */
	public static boolean isUserExist(String userName, String password, User user) {
		boolean exist = false;

		if(user.getUserName().equals(userName) && user.getPassword().equals(password)) {
			exist = true;
		}
		return exist;
	}
	
	/**
	 * This method is used to check user name doesn't be empty 
	 * And validate user name
	 * @param userName
	 * @return
	 */
	public static boolean checkUserName(String userName) {

		if (StringValidator.isValidString(userName)) {

			return StringValidator.isValidUsername(userName);
		} else {
			throw new UserDetailException("User name shouldn't empty");
		}
	}

	/**
	 * This method is used to check address doesn't be empty 
	 * And validate address
	 * @param address
	 * @return
	 */
	public static boolean checkAddress(String address) {

		if (StringValidator.isValidString(address)) {

			return StringValidator.isValidAddress(address);
		} else {
			throw new UserDetailException("Address shouldn't empty");
		}
	}
	
	/**
	 * This method is used to check gender doesn't be empty 
	 * And validate gender
	 * @param gender
	 * @return
	 */
	public static boolean checkGender(String gender) {

		if (StringValidator.isValidString(gender)) {

			return StringValidator.isValidGender(gender);

		} else {
			throw new UserDetailException("Gender shouldn't empty");
		}
	}
	/**
	 * This method is used to check mobile number doesn't be empty 
	 * And validate mobile number
	 * @param mobileNumber
	 * @return
	 */
	public static boolean checkMobileNumber(long mobileNumber) {

		String value = Long.toString(mobileNumber);
		if (StringValidator.isValidString(value)) {

			return NumberValidator.isValidMobileNumber(value);
		} else {
			throw new UserDetailException("Mobile number shouldn't empty");
		}

	}
	/**
	 * This method is used to check email doesn't be empty 
	 * And validate email
	 * @param email
	 * @return
	 */
	public static boolean checkEmail(String email) {

		if (StringValidator.isValidString(email)) {

			return EmailValidator.isValidEmail(email);
		} else {
			throw new UserDetailException("Email shouldn't empty");
		}
	}
	
	/**
	 * This method is used to check Password doesn't be empty 
	 * And validate Password
	 * @param password
	 * @return
	 */
	public static boolean checkPassword(String password) {

		if (StringValidator.isValidString(password)) {

			return PasswordValidator.isValidPassword(password);
		} else {
			throw new UserDetailException("Password shouldn't empty");
		}
	}

}
