package filterIncludeForward;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/map8")
public class Servlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7977898683464802992L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.getWriter().println("Antes do include");

		RequestDispatcher rd = req.getRequestDispatcher("/map9");
		rd.include(req, resp);

		resp.getWriter().println("Depois do include");
	}

}
