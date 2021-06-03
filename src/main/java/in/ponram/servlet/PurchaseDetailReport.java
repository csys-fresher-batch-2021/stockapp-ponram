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

import in.ponram.model.Order;
import in.ponram.service.ReportManager;
import in.ponram.util.LocalDateAdapter;
import in.ponram.util.NumberValidator;

/**
 * Servlet implementation class PurchaseDetailReport
 */
@WebServlet("/PurchaseDetailReport")
public class PurchaseDetailReport extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("productId");
		ReportManager reportManager = new ReportManager();
		
		Gson gson = new GsonBuilder().setPrettyPrinting()
		        .registerTypeAdapter(LocalDate.class, new LocalDateAdapter()).create();
		
		try {
			int productId = NumberValidator.parseInt(id, "Invalid Product id");
			List<Order> reportList = reportManager.getProductSalesReport(productId);
			String json = gson.toJson(reportList);
			PrintWriter out = response.getWriter();
			out.print(json);
			out.flush();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

}
