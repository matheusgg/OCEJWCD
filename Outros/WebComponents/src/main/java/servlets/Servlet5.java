package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Servlet5")
public class Servlet5 extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3048264854879987664L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.addHeader("headerTest", "value");
		resp.addCookie(new Cookie("cookieTest", "cookieValue"));
		resp.getWriter().println(super.getServletName());
	}

}
