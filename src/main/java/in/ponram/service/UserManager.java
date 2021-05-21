package in.ponram.service;

import in.ponram.dao.UserDAO;
import in.ponram.exception.ServiceException;
import in.ponram.model.User;
import in.ponram.validator.UserManagerValidation;

public class UserManager {
	
	private UserManager() {
		//Default constructor
	}
	/**
	 * This method is used to call user validation class
	 * Then the validation is success call addUser method to store the details 
	 * @param user
	 * @return true or false
	 */
	public static boolean registration(User... users) {
		
		boolean success = false;
		for (User user : users) {
			if (UserManagerValidation.isValideUserDetails(user)) {
				UserDAO.addUser(user);
				success = true;
			}
		}
		return success;
	}
	
	/**
	 * This method is used to call the call login validation to verify the user
	 * @param userName
	 * @param password
	 * @return true if the user exists
	 * @throws Exception 
	 */
	public static boolean login(String userName, String password) {

		boolean exists = false;
		if (UserManagerValidation.isValidLogin(userName, password)) {

			exists = true;
		}
		return exists;
	}

	/**
	 * This method is used to call the call Admin login validation to verify the user is admin
	 * @param userName
	 * @param password
	 * @return true if the user exists
	 * @throws Exception
	 */
	public static boolean adminLogin(String userName,String password) {

		if (UserManagerValidation.isAdminUser(userName, password)) {

			return true;
		} else {

			throw new ServiceException("User is not an admin");
		}
	}
	
}
