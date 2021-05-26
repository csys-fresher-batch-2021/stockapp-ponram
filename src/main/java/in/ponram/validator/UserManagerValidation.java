package in.ponram.validator;


import in.ponram.exception.ValidatorException;
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
	 * This method is used to check user is Admin
	 * 
	 * @param userName
	 * @param password
	 * @param user
	 * @return
	 */
	public static boolean isAdminUser(User admin, String password) {
		boolean success = false;
		if (rejectIfValueEmpty(admin.getUserName(), admin.getPassword())) {
			if (admin.getPassword().equals(password) && admin.getAdmin()) {

				success = true;
			}
		}
		return success;

	}

	/**
	 * This method is used to validate login user by, Check user name and password
	 * should not empty And check the user is exists
	 * 
	 * @param userName
	 * @param password
	 * @return
	 */
	public static boolean isValidLogin(User user, String password) {

		boolean success = false;
		if (rejectIfValueEmpty(user.getUserName(), user.getPassword())) {
			if (user.getPassword().equals(password)) {
				success = true;
			}
		}
		return success;
	}

	/**
	 * This method is used check whether the user name and password is empty
	 * 
	 * @param name
	 * @param password
	 * @return true
	 */
	public static boolean rejectIfValueEmpty(String name, String password) {
		boolean isEmpty = false;
		try {
			boolean validName = StringValidator.isValidString(name, "User name shouldn't empty");
			boolean validPassword = StringValidator.isValidString(password, "Password shouldn't empty");

			if (validName && validPassword) {
				isEmpty = true;
			}

		} catch (Exception e) {
			throw new ValidatorException(e.getMessage());
		}

		return isEmpty;
	}

	/**
	 * This method is used to check user name doesn't be empty And validate user
	 * name
	 * 
	 * @param userName
	 * @return
	 */
	public static boolean checkUserName(String userName) {

		boolean valid = false;
		if (StringValidator.isValidString(userName, "User name shouldn't empty")) {

			valid = StringValidator.isValidUsername(userName);
		}

		return valid;
	}

	/**
	 * This method is used to check address doesn't be empty And validate address
	 * 
	 * @param address
	 * @return
	 */
	public static boolean checkAddress(String address) {

		boolean valid = false;

		if (StringValidator.isValidString(address, "Address shouldn't empty")) {

			valid = StringValidator.isValidAddress(address);
		}

		return valid;

	}

	/**
	 * This method is used to check gender doesn't be empty And validate gender
	 * 
	 * @param gender
	 * @return
	 */
	public static boolean checkGender(String gender) {

		boolean valid = false;

		if (StringValidator.isValidString(gender, "Gender shouldn't empty")) {

			valid = StringValidator.isValidGender(gender);

		}
		return valid;

	}

	/**
	 * This method is used to check mobile number doesn't be empty And validate
	 * mobile number
	 * 
	 * @param mobileNumber
	 * @return
	 */
	public static boolean checkMobileNumber(long mobileNumber) {

		boolean valid = false;
		String value = Long.toString(mobileNumber);

		if (StringValidator.isValidString(value, "Mobile number shouldn't empty")) {

			valid = NumberValidator.isValidMobileNumber(value);
		}

		return valid;
	}

	/**
	 * This method is used to check email doesn't be empty And validate email
	 * 
	 * @param email
	 * @return
	 */
	public static boolean checkEmail(String email) {

		boolean valid = false;

		if (StringValidator.isValidString(email, "Email shouldn't empty")) {

			valid = EmailValidator.isValidEmail(email);
		}
		return valid;
	}

	/**
	 * This method is used to check Password doesn't be empty And validate Password
	 * 
	 * @param password
	 * @return
	 */
	public static boolean checkPassword(String password) {

		boolean valid = false;
		if (StringValidator.isValidString(password, "Password shouldn't empty")) {

			valid = PasswordValidator.isValidPassword(password);
		}
		return valid;
	}

}
