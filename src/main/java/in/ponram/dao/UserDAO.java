package in.ponram.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import in.ponram.exception.DBException;
import in.ponram.model.User;
import in.ponram.util.ConnectionUtil;

public class UserDAO {

	Connection connection = null;
	PreparedStatement pst = null;
	ResultSet rs = null;

	/**
	 * This method is used to add registered user in the list
	 * 
	 * @param user
	 */
	public void save(User user) {

		String sql = "insert into user_details(user_name,mobile_number,gender,address,email,admin_user,user_password ) values ( ?,?,?,?,?,?,?)";
		try {

			connection = ConnectionUtil.createConnection();
			pst = connection.prepareStatement(sql);
			pst.setString(1, user.getUserName());
			pst.setLong(2, user.getMobileNumber());
			pst.setString(3, user.getGender());
			pst.setString(4, user.getAddress());
			pst.setString(5, user.getEmail());
			pst.setBoolean(6, user.getAdmin());
			pst.setString(7, user.getPassword());
			pst.executeUpdate();
		} catch (SQLException e) {

			throw new DBException("Can't able to register");
		} finally {

			ConnectionUtil.closeConnection(rs, pst, connection);
		}
	}

	/**
	 * This method is used to search user from list
	 * @return user
	 */
	public User findUser(String name) {
		
		User user = new User();
		String sql = "SELECT user_name,admin_user,user_password FROM user_details where user_name = ?;";
		try {

			connection = ConnectionUtil.createConnection();
			pst = connection.prepareStatement(sql);
			pst.setString(1, name);
			rs = pst.executeQuery();
			while(rs.next()) {
				String userName = rs.getString("user_name");
				Boolean isAdmin = rs.getBoolean("admin_user");
				String password = rs.getString("user_password");
				user.setUserName(userName);
				user.setAdmin(isAdmin);
				user.setPassword(password);
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			throw new DBException("Unable to fetch user");
		} finally {
			
			ConnectionUtil.closeConnection(rs, pst, connection);
		}
		
		return user;
	}
}
