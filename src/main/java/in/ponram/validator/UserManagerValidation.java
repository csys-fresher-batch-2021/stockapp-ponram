package in.ponram.validator;

import java.util.List;

import in.ponram.dao.UserDAO;
import in.ponram.model.User;
import in.ponram.util.StringValidator;


public class UserManagerValidation {
	
	private UserManagerValidation() {
		//Default constructor
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
	 * This method is used to validate user name
	 * @param userName
	 * @return
	 */
	public static boolean checkUserName(String userName) {

		if (StringValidator.isValidString(userName)) {

			return StringValidator.isValidUsername(userName);
		} else {
			throw new RuntimeException("User name shouldn't empty");
		}
	}

	/**
	 * This method is used to validate password
	 * @param password
	 * @return
	 */
	public static boolean checkPassword(String password) {

		if (StringValidator.isValidString(password)) {

			return StringValidator.isValidPassword(password);
		} else {
			throw new RuntimeException("password shouldn't empty");
		}
	}
}
