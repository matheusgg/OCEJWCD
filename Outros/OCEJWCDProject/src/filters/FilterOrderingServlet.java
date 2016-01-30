package filters;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/FilterOrdering", name = "FilterOrderingServlet")
public class FilterOrderingServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6511668841087979657L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.getWriter().println("<h1>");
		resp.getWriter().println(super.getServletName());
		resp.getWriter().println("</h1>");
	}

}
