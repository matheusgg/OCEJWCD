package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ErrorMapping")
public class ExceptionServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2992562699053281955L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.getWriter().println(RequestDispatcher.ERROR_EXCEPTION + " - " + req.getAttribute(RequestDispatcher.ERROR_EXCEPTION));
		resp.getWriter().println(RequestDispatcher.ERROR_EXCEPTION_TYPE + " - " + req.getAttribute(RequestDispatcher.ERROR_EXCEPTION_TYPE));
		resp.getWriter().println(RequestDispatcher.ERROR_MESSAGE + " - " + req.getAttribute(RequestDispatcher.ERROR_MESSAGE));
		resp.getWriter().println(RequestDispatcher.ERROR_REQUEST_URI + " - " + req.getAttribute(RequestDispatcher.ERROR_REQUEST_URI));
		resp.getWriter().println(RequestDispatcher.ERROR_SERVLET_NAME + " - " + req.getAttribute(RequestDispatcher.ERROR_SERVLET_NAME));
		resp.getWriter().println(RequestDispatcher.ERROR_STATUS_CODE + " - " + req.getAttribute(RequestDispatcher.ERROR_STATUS_CODE));
	}

}
