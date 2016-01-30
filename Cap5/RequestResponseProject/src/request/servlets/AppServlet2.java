package request.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "AppServlet2", urlPatterns = { "/AppServlet2" })
public class AppServlet2 extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8668603249883780855L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/*
		 * ServletResponse possui um metodo para recuperar um RequestDispatcher
		 * também, porem diferentemente do metodo de ServletContext, o metodo de
		 * ServletResponse aceita tambem um caminho relativo além do caminho a
		 * partir da raiz da aplicacao (iniciado por '/').
		 */
		RequestDispatcher dispatcher = req.getRequestDispatcher("AppServlet");
		dispatcher.include(req, resp);

		/*
		 * Esse metodo de ServletContext aceita apenas um caminho relativo de
		 * contexto (iniciado com '/').
		 */
		RequestDispatcher requestDispatcher = super.getServletContext().getRequestDispatcher("/res/file.txt");
		requestDispatcher.include(req, resp);
	}

}
