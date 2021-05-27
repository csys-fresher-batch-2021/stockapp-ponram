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

import in.ponram.dao.ProductDAO;
import in.ponram.model.Product;
import in.ponram.util.LocalDateAdapter;

/**
 * Servlet implementation class ListProductServlet
 */
@WebServlet("/ListProductServlet")
public class ListProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductDAO listProduct = new ProductDAO();
		List<Product> list = listProduct.findAll();
		Gson gson = new GsonBuilder().setPrettyPrinting()
		        .registerTypeAdapter(LocalDate.class, new LocalDateAdapter()).create();
		String json = gson.toJson(list);
		try {
			PrintWriter out = response.getWriter();
			out.print(json);
			out.flush();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

}
