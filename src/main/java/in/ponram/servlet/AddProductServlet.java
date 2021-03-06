package in.ponram.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.ponram.model.Product;
import in.ponram.service.ProductManager;
import in.ponram.util.NumberValidator;

/**
 * Servlet implementation class AddProductServelet
 */
@WebServlet("/AddProductServlet")
public class AddProductServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException,IOException {
		String brandName = request.getParameter("brandName");
		String itemName = request.getParameter("itemName");
		String itemCategory = request.getParameter("itemCategory");
		String qty = request.getParameter("quantity");
		String rate = request.getParameter("rate");
		int prize = 0;
		int quantity = 0;
		try {
			
			prize = NumberValidator.parseInt(rate, "Invalid rate");

			quantity = NumberValidator.parseInt(qty, "Invalid quantity");

			Product product1 = new Product(brandName, itemName, itemCategory, prize, quantity);

			ProductManager addProduct = new ProductManager();
			boolean success = addProduct.addStock(product1);
			if (success) {

				String infoMessage = "Product Added Successfully";
				response.sendRedirect("AddProduct.jsp?infoMessage=" + infoMessage);
			} else {

				String errorMessage = "Invalid product";
				response.sendRedirect("AddProduct.jsp?errorMessage=" + errorMessage);
			}

		}

		catch (Exception e) {

			String errorMessage = e.getMessage();
			response.sendRedirect("AddProduct.jsp?errorMessage=" + errorMessage);
		}
	}

}
