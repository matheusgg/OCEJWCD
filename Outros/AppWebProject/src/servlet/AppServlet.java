package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AppServlet")
@MultipartConfig(fileSizeThreshold = 100000)
public class AppServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6754492442988593988L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// req.getSession();
		//
		// resp.flushBuffer();
		//
		// HttpSession session = req.getSession();
		// resp.getWriter().println(session.getId());

		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/pageTest.jsp");
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.getOutputStream().println(req.getParts() + ": Size - " + req.getParts().size());
	}

}
