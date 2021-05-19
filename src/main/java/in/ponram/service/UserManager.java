package in.ponram.service;

import in.ponram.dao.UserDAO;
import in.ponram.exception.UserDetailException;
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
		
		if (UserManagerValidation.isValidLogin(userName, password)) {
			
			return true;
		} else {
			
			throw new UserDetailException("User is not exists");
		}
	}
	
}
