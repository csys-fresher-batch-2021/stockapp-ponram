package in.ponram.dao;

import java.util.ArrayList;
import java.util.List;

import in.ponram.exception.DAOException;
import in.ponram.model.User;

public class UserDAO {

	private static final List<User> userList = new ArrayList<>();
	
	private UserDAO() {
		//Default constructor
	}
	static {
		userList.add(new User("Admin",8888888888L,"Thoothukudi","Male",true,"Admin@gmail.com","Admin@123"));
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
	
	/**
	 * This method is used to search user from list
	 * @return user
	 */
	public static User searchUser(String name) {
		
		User user = null;
		for(User searchUser : userList) {
			if(searchUser.getUserName().equals(name)) {
				
				user = searchUser;
				break;
			}
			
		}
		
		if(user ==null) {
			throw new DAOException("User not found");
		}
		
		return user;
	}
}
