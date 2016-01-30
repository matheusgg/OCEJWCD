package filterIncludeForward;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/map9")
public class Servlet2 extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8372112416063968331L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.getWriter().println("Servlet de mapeamento " + req.getAttribute("javax.servlet.include.servlet_path") + " executada!");
	}

}
