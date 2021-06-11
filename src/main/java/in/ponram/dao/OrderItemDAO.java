package in.ponram.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import in.ponram.exception.DBException;
import in.ponram.model.OrderItem;
import in.ponram.util.ConnectionUtil;

public class OrderItemDAO {

	public void save(OrderItem orderItem) {
		
		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String sql = "INSERT INTO order_item (bill_id,product_id,product_quantity,total_amount) values(?,?,?,?)";
		try {
			connection = ConnectionUtil.createConnection();
			pst = connection.prepareStatement(sql);
			pst.setInt(1,orderItem.getBillNumber());
			pst.setInt(2,orderItem.getProductId());
			pst.setInt(3,orderItem.getQuantity());
			pst.setInt(4,orderItem.getTotalAmount());
			pst.executeUpdate();
		} catch (SQLException e) {

			throw new DBException("Product can't be added");
		} finally {

			ConnectionUtil.closeConnection(rs,pst, connection);
		}
	}
}
