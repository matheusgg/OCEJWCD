package servletContext;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servContext")
public class AppServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1613019587944501072L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.getWriter().println("MIME Type: " + super.getServletContext().getMimeType("/inicial.xhtml"));
	}

}
