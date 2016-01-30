package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/AppServlet2", loadOnStartup = -1)
public class AppServlet2 extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6406350029561086107L;

	@Override
	public void init() throws ServletException {
		super.init();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (req.getParameter("error") != null) {
			throw new RuntimeException("Parametro de erro encontrado!");
		}
		resp.getWriter().println("AppServlet2");
	}

}
