package in.ponram.dao;

import java.util.ArrayList;
import java.util.List;

import in.ponram.model.User;

public class UserDAO {

	private static final List<User> userList = new ArrayList<User>();
	
	static {
		userList.add(new User("Ponram","Ponram@123"));
		userList.add(new User("Siva","SiVa#123"));
	}
	
	public static List<User> getAllUsers(){
		return userList;
	}
}
