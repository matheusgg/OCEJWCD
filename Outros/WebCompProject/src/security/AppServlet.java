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

@ServletSecurity(value = @HttpConstraint(EmptyRoleSemantic.DENY), httpMethodConstraints = { @HttpMethodConstraint(value = "GET", rolesAllowed = "admin") })
@WebServlet(name = "AppServlet", urlPatterns = "/Sec/AppServlet")
public class AppServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3223808212116121935L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.getWriter().println("<h1>");
		resp.getWriter().println("User: ");
		resp.getWriter().println(req.getRemoteUser());
		resp.getWriter().println("Admin? ");
		resp.getWriter().println(req.isUserInRole("root"));
		resp.getWriter().println("</h1>");
	}

}
