package servlets;

import java.io.IOException;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/AsyncServlet", asyncSupported = true)
public class AsyncServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3064951871426981417L;

	@Override
	protected void doGet(HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
		resp.getWriter().println("Iniciando AsyncContext...");

		final AsyncContext asyncContext = req.startAsync();
		asyncContext.setTimeout(0);

		Thread t = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					resp.getWriter().println("Dentro da tarefa assincrona");
					Thread.sleep(3000);

					asyncContext.dispatch("/AsyncServlet2");

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

		t.start();
	}

}
