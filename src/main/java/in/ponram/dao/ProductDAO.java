package in.ponram.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import in.ponram.exception.DBException;
import in.ponram.model.Product;
import in.ponram.util.ConnectionUtil;

public class ProductDAO {
	/**
	 * This method is used to add the product in the Database
	 * 
	 * @param product
	 * @throws Exception
	 */
	public void save(Product product){

		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String sql = "INSERT INTO stock(brand_name,product_name,product_category,arrival_date,initial_quantity,available_quantity,rate ) values ( ?,?,?,?,?,?,? )";
		try {

			connection = ConnectionUtil.createConnection();
			pst = connection.prepareStatement(sql);
			pst.setString(1, product.getBrandName());
			pst.setString(2, product.getProductName());
			pst.setString(3, product.getProductCategory());
			pst.setDate(4, Date.valueOf(product.getArrivalDate()));
			pst.setInt(5, product.getQuantity());
			pst.setInt(6, product.getQuantity());
			pst.setInt(7, product.getRate());
			pst.executeUpdate();
		} catch (SQLException e) {

			throw new DBException("Product can't be added");
		} finally {

			ConnectionUtil.closeConnection(rs,pst, connection);
		}

	}

	/**
	 * This method is used to get all the product from database
	 * 
	 * @return product ArrayList
	 */
	public List<Product> findAll() {
		
		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		List<Product> productList = new ArrayList<>();

		try {

			// Step 1: Get the connection
			connection = ConnectionUtil.createConnection();

			// Step 2: Query
			String sql = "SELECT product_id,brand_name,product_name,product_category,arrival_date,available_quantity,rate  FROM stock WHERE active = true ORDER BY product_id ASC";
			pst = connection.prepareStatement(sql);
			// Step 3: execute query

			rs = pst.executeQuery();
			while (rs.next()) {
				Product product = toRow(rs);
				// Store all products in list
				productList.add(product);

			}

		} catch (SQLException e) {
			
			throw new DBException("Unable to fetch products");
		} finally {
			
			ConnectionUtil.closeConnection(rs, pst, connection);
		}
		return productList;
	}
	
	/**
	 * This method is used to get all the product by quantity from database
	 * 
	 * @return product ArrayList
	 */
	public List<Product> findByQuantity(int quantity) {

		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		List<Product> productList = new ArrayList<>();
		String sql = "SELECT product_id,brand_name,product_name,product_category,arrival_date,available_quantity,rate  FROM stock WHERE active = true AND available_quantity<= ? ORDER BY product_id ASC";
		try {
			// Step 1: Get the connection
			connection = ConnectionUtil.createConnection();
			pst = connection.prepareStatement(sql);
			pst.setInt(1, quantity);
			rs = pst.executeQuery();
			while (rs.next()) {
				Product product = toRow(rs);
				productList.add(product);

			}

		} catch (SQLException e) {
			
			throw new DBException("Unable to fetch products");
		} finally {
			
			ConnectionUtil.closeConnection(rs, pst, connection);
		}
		return productList;
	}

	public Product toRow(ResultSet rs) throws SQLException {
		int id = rs.getInt("product_id");
		String brandName = rs.getString("brand_name");
		String productName = rs.getString("product_name");
		String productCategory = rs.getString("product_category");
		LocalDate arrivalDate = (rs.getDate("arrival_date")).toLocalDate();
		int quantity = rs.getInt("available_quantity");
		int rate = rs.getInt("rate");

		return new Product(id, brandName, productName, productCategory, arrivalDate, quantity, rate);
	}

	/**
	 * This method is used to remove the product from the database
	 */
	public void remove(String product) {
		
		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String sql = "UPDATE stock SET active = false WHERE product_name = ?;";
		try {

			connection = ConnectionUtil.createConnection();
			pst = connection.prepareStatement(sql);
			pst.setString(1, product);
			pst.executeUpdate();
		} catch (SQLException e) {

			throw new DBException("Product can't be deleted");
		} finally {

			ConnectionUtil.closeConnection(rs,pst, connection);
		}
	}
	
	/**
	 * This method is used to update product quantity by using product id from database
	 * @param brand
	 * @return
	 */
	public void updateAddQuantity(int id, int quantity) {
		
		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String sql = "update stock set initial_quantity = initial_quantity + ?, available_quantity = available_quantity + ? where product_id = ?";
		try {
			
			connection = ConnectionUtil.createConnection();
			pst = connection.prepareStatement(sql);
			pst.setInt(1, quantity);
			pst.setInt(2, quantity);
			pst.setInt(3, id);
			pst.executeUpdate();
		} catch (SQLException e) {

			throw new DBException("Quantity can't be updated");
		} finally {

			ConnectionUtil.closeConnection(rs,pst, connection);
		}
	}

	/**
	 * This method is used to update product quantity by using product id from database
	 * @param brand
	 * @return
	 */
	public void updateReduceQuantity(int id, int quantity) {
		
		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String sql = "update stock set available_quantity = available_quantity - ? where product_id = ?";
		try {
			
			connection = ConnectionUtil.createConnection();
			pst = connection.prepareStatement(sql);
			pst.setInt(1, quantity);
			pst.setInt(2, id);
			pst.executeUpdate();
		} catch (SQLException e) {

			throw new DBException("Quantity can't be updated");
		} finally {

			ConnectionUtil.closeConnection(rs,pst, connection);
		}
	}
	
}
