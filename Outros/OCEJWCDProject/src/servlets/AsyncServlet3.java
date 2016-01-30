package servlets;

import java.io.IOException;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/AsyncServlet3/*", asyncSupported = false)
public class AsyncServlet3 extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3064951871426981417L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.getWriter().println("AsyncServlet3");

		final AsyncContext asyncContext = req.startAsync();

		asyncContext.start(new Runnable() {

			@Override
			public void run() {
				asyncContext.complete();
			}
		});
	}

}
