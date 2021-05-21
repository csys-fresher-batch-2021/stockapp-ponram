package in.ponram.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.ponram.exception.DAOException;
import in.ponram.exception.ValidatorException;
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
		String userType = request.getParameter("userType");
		HttpSession session = request.getSession();
		try {
			if (userType.equalsIgnoreCase("admin")) {

				UserManager.adminLogin(userName, password);
				session.setAttribute("USER_NAME", userName);
				session.setAttribute("ROLE", "admin");
			} else {
				
				UserManager.login(userName, password);
				session.setAttribute("USER_NAME", userName);
			}

			response.sendRedirect("ListProduct.jsp");
		} catch (ValidatorException | DAOException e) {

			response.sendRedirect("Login.jsp?errorMessage=" + e.getMessage());
		}
	}

}
