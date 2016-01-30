package security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.HttpMethodConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.ServletSecurity.EmptyRoleSemantic;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@ServletSecurity(value = @HttpConstraint(EmptyRoleSemantic.DENY), httpMethodConstraints = { @HttpMethodConstraint(value = "GET", emptyRoleSemantic = EmptyRoleSemantic.PERMIT) })
@WebServlet(name = "AppServlet2", urlPatterns = "/Sec/AppServlet2")
public class AppServlet2 extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3223808212116121935L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String user = req.getParameter("user");
		String password = req.getParameter("pass");

		String operation = req.getParameter("operation");

		if (user != null && password != null && operation != null && operation.equals("login")) {
			req.login(user, password);
			resp.getWriter().println("Logged");
		}

		if (operation != null && operation.equals("logout")) {
			req.logout();
			resp.getWriter().println("Logged out");
		}
	}

}
