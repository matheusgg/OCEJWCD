package statusCodes;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "SCServlet", urlPatterns = { "/SCServlet" })
public class SCServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4684636472822075166L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String errorParam = req.getParameter("errorParam");
		String redirectParam = req.getParameter("redirectParam");

		/*
		 * Caso o response ja estiver sido commitado, esses metodos lancarao uma
		 * excecao.
		 */
		if (errorParam != null) {
			resp.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "Parametro de erro encontrado!");
		}

		if (redirectParam != null) {
			// resp.sendRedirect("PathServlet/teste");
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("PathServlet/teste");
			requestDispatcher.include(req, resp);
		}

		Cookie cookie = new Cookie("RequestResponseProject", "Capitulo 5");
		cookie.setMaxAge(5);
		resp.addCookie(cookie);

		resp.getWriter().write("Nenhum parametro encontrado e cookie adicionado!");
	}

}
