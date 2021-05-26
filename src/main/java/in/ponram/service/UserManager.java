package in.ponram.service;

import in.ponram.dao.UserDAO;
import in.ponram.exception.ServiceException;
import in.ponram.model.User;
import in.ponram.validator.UserManagerValidation;

public class UserManager {
	
	UserDAO userDao = new UserDAO();
	/**
	 * This method is used to call user validation class
	 * Then the validation is success call addUser method to store the details 
	 * @param user
	 * @return true or false
	 */
	public boolean registration(User... users) {
		
		boolean success = false;
		for (User user : users) {
			if (UserManagerValidation.isValideUserDetails(user)) {
				userDao.save(user);
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
	public boolean login(String userName, String password) {

		User admin = userDao.findUser(userName);
		if (UserManagerValidation.isValidLogin(admin,password)) {

			return true;
		} else {

			throw new ServiceException("Invalid user");
		}
	}

	/**
	 * This method is used to call the call Admin login validation to verify the user is admin
	 * @param userName
	 * @param password
	 * @return true if the user exists
	 * @throws Exception
	 */
	public boolean adminLogin(String userName,String password) {

		User admin = userDao.findUser(userName);
		if (UserManagerValidation.isAdminUser(admin,password)) {

			return true;
		} else {

			throw new ServiceException("Invalid user");
		}
	}
	
}
