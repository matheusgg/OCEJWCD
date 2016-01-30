package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/MyServlet", name = "MyServlet")
public class MyServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4821121089141927458L;

	/**
	 * Nao é possivel iniciar uma tarefa assincrona de um recurso que foi
	 * solicitado atraves de um dispatcher de um web component que nao possui
	 * suporte assincrono.
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("/MyAsyncServlet2");

		/*
		 * Quando MyAsyncServlet2 tentar iniciar a tarefa assincrona uma
		 * IllegalStateException ocorrera, pois MyServlet nao é uma servlet
		 * assincrona.
		 */
		resp.flushBuffer();
		rd.forward(req, resp);
	}

}
