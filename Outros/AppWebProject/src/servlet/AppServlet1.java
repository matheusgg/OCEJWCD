package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.AsyncContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/AppServlet1", asyncSupported = true)
public class AppServlet1 extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7148270222449339404L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		final PrintWriter pw = resp.getWriter();
		final AsyncContext asyncContext = req.startAsync();

		asyncContext.start(new Runnable() {

			@Override
			public void run() {
				asyncContext.dispatch("/AppServlet2");
				pw.println("end");
			}
		});
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.getWriter().println(super.getServletName());

		RequestDispatcher rd = req.getRequestDispatcher("/AppServlet2");
		rd.forward(req, resp);

		// Isto nao sera enviado para o cliente
		resp.getWriter().println(super.getServletName());
		rd.include(req, resp);
	}

}
