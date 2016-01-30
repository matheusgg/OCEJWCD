package filterWrapper;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/map10")
public class Servlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2215504489638979757L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (req.getParameter("redirect") != null) {
			resp.sendRedirect("/FilterProject/MyServlet");
			return;
		}
		resp.getWriter().println("Servlet with custom response writer and filter mechanism");
	}

}
