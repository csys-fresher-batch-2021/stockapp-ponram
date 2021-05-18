package in.ponram.service;

import in.ponram.exception.UserDetailException;
import in.ponram.validator.UserManagerValidation;

public class UserManager {
	
	private UserManager() {
		//Default constructor
	}
	/**
	 * 
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
