package in.ponram.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import in.ponram.exception.DBException;
import in.ponram.model.Order;
import in.ponram.model.OrderItem;
import in.ponram.model.Product;
import in.ponram.util.ConnectionUtil;

public class ReportDAO {

	 Connection connection = null;
	 PreparedStatement pst = null;
	 ResultSet rs = null;
	
	/**
	 * This method is used to get all the product from database
	 * 
	 * @return product ArrayList
	 */
	public List<Product> findAll() {

		List<Product> productList = new ArrayList<>();

		try {

			// Step 1: Get the connection
			connection = ConnectionUtil.createConnection();

			// Step 2: Query
			String sql = "SELECT product_id,brand_name,product_name,product_category,arrival_date,initial_quantity,available_quantity,rate,active  FROM stock";
			pst = connection.prepareStatement(sql);
			// Step 3: execute query
			rs = pst.executeQuery();
			while (rs.next()) {
				Product product = new Product();
				product.setProductId( rs.getInt("product_id"));
				product.setBrandName(rs.getString("brand_name"));
				product.setProductName(rs.getString("product_name"));
				product.setProductCategory(rs.getString("product_category"));
				LocalDate arrivalDate = (rs.getDate("arrival_date")).toLocalDate();
				product.setArrivalDate(arrivalDate);
				product.setQuantity(rs.getInt("available_quantity"));
				product.setInitialQuantity(rs.getInt("initial_quantity"));
				product.setRate(rs.getInt("rate"));
				product.setStatus(rs.getBoolean("active"));
				productList.add(product);
			}

		} catch (SQLException e) {
			
			e.printStackTrace();
			throw new DBException("Unable to fetch products");
		} finally {
			
			ConnectionUtil.closeConnection(rs, pst, connection);
		}
		return productList;
	}

	/**
	 * 
	 * @param id
	 * @return 
	 */
	public List<Order> findStockByProductId(int id) {
		
		List<Order> reportList = new ArrayList<>();
		String sql = "select o.bill_id as billId,o.user_name as userName,s.brand_name as brandName,s.product_name as productName,s.rate as rate,it.product_quantity as quantity,it.total_amount as totalAmount,o.purchase_date as purchaseDate from orders o, order_item it, stock s where o.bill_id = it.bill_id and it.product_id = s.product_id and it.product_id = ?";
		try {
			
			connection = ConnectionUtil.createConnection();
			pst = connection.prepareStatement(sql); 
			pst.setInt(1, id);
			rs = pst.executeQuery();
			while(rs.next()){
				Order order = new Order();
				OrderItem orderItem = new OrderItem();
				order.setBillNumber(rs.getInt("billId"));
				order.setCustomerName(rs.getString("userName"));
				orderItem.setBrandName(rs.getString("brandName"));
				orderItem.setProductName(rs.getString("productName"));
				orderItem.setRate(rs.getInt("rate"));
				orderItem.setQuantity(rs.getInt("quantity"));
				orderItem.setTotalAmount(rs.getInt("totalAmount"));
				LocalDate date = (rs.getDate("purchaseDate")).toLocalDate();
				order.setPurchaseDate1(date);
				order.setOrderDetail(orderItem);
				reportList.add(order);
			}
			return reportList;
		} catch (SQLException e) {

			throw new DBException(e.getMessage());
		} finally {

			ConnectionUtil.closeConnection(rs,pst, connection);
		}
	}
}
