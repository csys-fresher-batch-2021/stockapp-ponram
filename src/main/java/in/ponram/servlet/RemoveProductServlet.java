package in.ponram.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.ponram.service.ProductManager;

/**
 * Servlet implementation class RemoveProductServlet
 */
@WebServlet("/RemoveProductServlet.java")
public class RemoveProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("itemName");
		try {
			
			boolean success = ProductManager.deleteProduct(name);
			if(success) {
				String infoMessage = "Product Removed";
				response.sendRedirect("ListProduct.jsp?infoMessage=" + infoMessage);
			}
		}
		catch (Exception e) {

			String errorMessage = e.getMessage();
			response.sendRedirect("ListProduct.jsp?errorMessage=" + errorMessage);
		}
	}


}
