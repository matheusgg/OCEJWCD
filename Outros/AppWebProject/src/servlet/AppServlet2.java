package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/AppServlet2", asyncSupported = true)
public class AppServlet2 extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7148270222449339404L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.getWriter().println(super.getServletName());
		resp.addHeader("headerTeste", "headerValue");
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.getWriter().println(super.getServletName());
	}

}
