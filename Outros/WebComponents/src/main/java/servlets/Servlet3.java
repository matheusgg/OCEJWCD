package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Servlet3")
public class Servlet3 extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2850877339517661418L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		resp.getWriter().println(req.getMethod());
		resp.getWriter().println("<br />");
		resp.getWriter().println(session.getId());

		if (req.getParameter("redirect1") != null) {
			RequestDispatcher rd = req.getRequestDispatcher("page3.jsp?teste=valor");
			rd.include(req, resp);

		} else if (req.getParameter("redirect2") != null) {
			RequestDispatcher rd = req.getRequestDispatcher("Servlet2?teste=valor");
			rd.include(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.getWriter().println(req.getMethod());
	}

}
