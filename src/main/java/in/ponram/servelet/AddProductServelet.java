package in.ponram.servelet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.ponram.model.Product;
import in.ponram.service.ProductManager;

/**
 * Servlet implementation class AddProductServelet
 */
@WebServlet("/AddProductServelet")
public class AddProductServelet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String itemId = request.getParameter("itemId");
		String brandName = request.getParameter("brandName");
		String itemName = request.getParameter("itemName");
		String itemCategory = request.getParameter("itemCategory");
		int rate = Integer.parseInt(request.getParameter("rate"));
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		
		Product product1 = new Product(itemId, brandName, itemName, itemCategory, rate, quantity);
		
		boolean success = ProductManager.addStock(product1);
		if(success){
			String infoMessage = "Product Added Successfully";
			response.sendRedirect("add_product.jsp?infoMessage=" + infoMessage);
		}
		else{
			String errorMessage="Invalid product";
			response.sendRedirect("add_product.jsp?errorMessage=" + errorMessage);
		}
	}

}
