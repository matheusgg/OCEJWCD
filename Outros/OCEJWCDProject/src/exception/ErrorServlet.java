package exception;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/error")
public class ErrorServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -798533045758798453L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (req.getParameter("error") != null) {
			throw new ServletException("Erro");

		} else if (req.getParameter("error2") != null) {
			resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Erro");
		}
	}

}
