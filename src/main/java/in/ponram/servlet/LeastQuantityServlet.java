package in.ponram.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import in.ponram.model.Product;
import in.ponram.service.ProductManager;
import in.ponram.util.LocalDateAdapter;
import in.ponram.util.NumberValidator;

/**
 * Servlet implementation class LeastQuantityServlet
 */
@WebServlet("/LeastQuantityServlet")
public class LeastQuantityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String value = request.getParameter("quantity");
		PrintWriter out = response.getWriter();
		ProductManager listProduct = new ProductManager();
		try {
			
			int quantity = NumberValidator.parseInt(value, "Invalid Quantity");
			List<Product> list = listProduct.getStockByQuantity(quantity);
			Gson gson = new GsonBuilder().setPrettyPrinting()
					.registerTypeAdapter(LocalDate.class, new LocalDateAdapter()).create();
			String json = gson.toJson(list);

			out.print(json);
			
		} catch (Exception e) {

			out.print(e.getMessage());
			
		}
		out.flush();
	}

}
