package in.ponram.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import in.ponram.model.Order;
import in.ponram.model.OrderItem;
import in.ponram.service.OrderManager;
import in.ponram.util.NumberValidator;

/**
 * Servlet implementation class OrderProducts
 */
@WebServlet("/OrderProductsServlet")

public class OrderProductsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		String order =request.getParameter("dt") ;
		HttpSession session = request.getSession();
		String user = (String)session.getAttribute("USER_NAME");
		List<OrderItem> orderItems = new ArrayList<>();
		JsonArray jsonObject = new JsonParser().parse(order).getAsJsonArray();
		OrderManager orderManagerObj = new OrderManager();
		Order val = new Order();
		try {
			for (JsonElement jsonElement : jsonObject) {
				
				OrderItem item = new OrderItem();
				String obj1 = jsonElement.getAsJsonObject().get("productId").getAsString();
				String obj2 = jsonElement.getAsJsonObject().get("quantity").getAsString();
				int id = NumberValidator.parseInt(obj1,"Invalid id");
				int quantity = NumberValidator.parseInt(obj2,"Invalid id");
				item.setProductId(id);
				item.setQuantity(quantity);
				orderItems.add(item);
			}
			val.setCustomerName(user);
			val.setPurchaseDate();
			val.setOrderDetail(orderItems);
			orderManagerObj.orderProducts(val);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
