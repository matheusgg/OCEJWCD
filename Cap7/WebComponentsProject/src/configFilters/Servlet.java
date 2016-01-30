package configFilters;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet({ "/map3", "/map4", "/map6" })
public class Servlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 491255490675925969L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.getWriter().println(req.getRequestURI());
	}

}
