package async;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/async/test2", asyncSupported = true)
public class AsyncServlet2 extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8971549866955112699L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		final AsyncContext asyncContext = req.startAsync();
		AsyncContextListener listener = asyncContext.createListener(AsyncContextListener.class);
		asyncContext.addListener(listener);
		
		final PrintWriter writer = resp.getWriter();

		writer.println("Async almost end");

		asyncContext.start(new Runnable() {

			@Override
			public void run() {
				writer.println("async ended");
				asyncContext.complete();
			}
		});

	}

}
