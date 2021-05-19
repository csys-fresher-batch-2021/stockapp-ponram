package in.ponram.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.ponram.model.User;
import in.ponram.service.UserManager;
import in.ponram.util.NumberValidator;

/**
 * Servlet implementation class Register
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userName = request.getParameter("userName");
		String gender = request.getParameter("gender");
		String address = request.getParameter("address");
		String mblNmbr = request.getParameter("mobileNumber");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		try {
			long mobileNumber = NumberValidator.parseLong(mblNmbr, "Invalid Mobile number");
			
			User user = new User(userName,mobileNumber,address,gender,email,password);
			boolean success = UserManager.registration(user);
			if (success) {

				response.sendRedirect("Login.jsp");
			} else {

				String errorMessage = "Register failed";
				response.sendRedirect("Register.jsp?errorMessage=" + errorMessage);
			}
		}
		catch (Exception e) {

			String errorMessage = e.getMessage();
			response.sendRedirect("Register.jsp?errorMessage=" + errorMessage);
		}
	}

}
