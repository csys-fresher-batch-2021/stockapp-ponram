package in.ponram.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import in.ponram.exception.DBException;
import in.ponram.model.Order;
import in.ponram.util.ConnectionUtil;

public class OrdarDAO {

	public int save(Order order) {
		
		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		int val = 0;
		String sql = "INSERT INTO orders (user_name,purchase_date) values(?,?)";
		try {
			connection = ConnectionUtil.createConnection();
			pst = connection.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
			pst.setString(1,order.getCustomerName());
			pst.setDate(2,Date.valueOf(order.getPurchaseDate()));
			pst.executeUpdate();
			rs=pst.getGeneratedKeys();
			if(rs.next()){
				val = rs.getInt(1);
				   
			}
			return val;
		} catch (SQLException e) {

			throw new DBException("Can't able to generate a bill");
		} finally {

			ConnectionUtil.closeConnection(rs,pst, connection);
		}
	}
	
	/**
	 * This method is used to update the total bill amount in the database
	 */
	public void updateBillAmount(int billId, int total) {
		
		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String sql = "UPDATE orders SET total_bill_amount = ? WHERE bill_id = ?;";
		try {

			connection = ConnectionUtil.createConnection();
			pst = connection.prepareStatement(sql);
			pst.setInt(1, total);
			pst.setInt(2, billId);
			pst.executeUpdate();
		} catch (SQLException e) {

			throw new DBException("Can't able to ubdate a total amount");
		} finally {

			ConnectionUtil.closeConnection(rs,pst, connection);
		}
	}

}
