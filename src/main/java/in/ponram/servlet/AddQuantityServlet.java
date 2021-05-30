package in.ponram.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonObject;

import in.ponram.service.ProductManager;
import in.ponram.util.NumberValidator;

/**
 * Servlet implementation class AddQuantityServlet
 */
@WebServlet("/AddQuantityServlet")
public class AddQuantityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String qty = request.getParameter("quantity");
		JsonObject object = new JsonObject();
		ProductManager updateQuantity = new ProductManager();
		try {
			
			PrintWriter out = response.getWriter();
			int productId = NumberValidator.parseInt(id, "Invalid Id");
			int quantity = NumberValidator.parseInt(qty, "Invalid Quantity");
			updateQuantity.increaseQuantity(productId, quantity);
			object.addProperty("infoMessage", "Successfully Added");
			out.println(object);			
			
		} catch (Exception e) {
			
			e.printStackTrace();
			object.addProperty("errorMessage", e.getMessage());
		}
	}

}
