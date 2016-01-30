package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Servlet4")
public class Servlet4 extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3048264854879987664L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.getWriter().write("<p>Included resource:</p>");
		resp.flushBuffer();
		RequestDispatcher rd = req.getRequestDispatcher("/Servlet5");
		if (rd != null) {
			rd.include(req, resp);
		}
		System.out.println("end");
	}

}
