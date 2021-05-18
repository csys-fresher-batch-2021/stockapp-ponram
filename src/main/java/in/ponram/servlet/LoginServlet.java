package in.ponram.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.ponram.exception.UserDetailException;
import in.ponram.service.UserManager;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		try {
			boolean valid = UserManager.login(userName, password);
			if (valid) {
				HttpSession session = request.getSession();
				session.setAttribute("USER_NAME", userName);
				response.sendRedirect("list_products.jsp");
			}
		} catch (UserDetailException e) {

			String errorMessage = e.getMessage();
			response.sendRedirect("Login.jsp?errorMessage=" + errorMessage);
		}
	}

}
