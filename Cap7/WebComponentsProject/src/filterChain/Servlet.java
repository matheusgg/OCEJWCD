package filterChain;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/map7")
public class Servlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1871118443677283394L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Enumeration<String> attrNames = req.getAttributeNames();

		while (attrNames.hasMoreElements()) {
			resp.getWriter().println(attrNames.nextElement());
		}
	}

}
