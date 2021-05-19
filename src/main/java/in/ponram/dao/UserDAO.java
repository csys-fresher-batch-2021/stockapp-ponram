package in.ponram.dao;

import java.util.ArrayList;
import java.util.List;

import in.ponram.model.User;

public class UserDAO {

	private static final List<User> userList = new ArrayList<>();
	
	private UserDAO() {
		//Default constructor
	}
	/**
	 * This method is used to add registered user in the list
	 * @param user
	 */
	public static void addUser(User user) {
		
		userList.add(user);
	}
	
	/**
	 * This method is used to return total registered user list
	 * @return list
	 */
	public static List<User> getAllUsers(){
		
		return userList;
	}
}
