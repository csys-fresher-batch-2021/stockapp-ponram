package in.ponram.service;

import java.util.List;

import in.ponram.dao.ReportDAO;
import in.ponram.model.Order;
import in.ponram.model.Product;

public class ReportManager {

	private ReportDAO reportDao = new ReportDAO();
	
	public List<Product> getFullStockReport(){
		
		return reportDao.findAll();
	}
	public List<Order> getProductSalesReport(int id){
		
		return reportDao.findStockByProductId(id);
	}
}
