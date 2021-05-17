package in.ponram.service;

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
	public static boolean login(String userName, String password) throws Exception {
		
		if (UserManagerValidation.isValidLogin(userName, password)) {
			
			return true;
		} else {
			
			throw new Exception("User is not exists");
		}
	}
	
}
