package async;

import java.io.IOException;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/async/test", asyncSupported = true)
public class AsyncServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8971549866955112699L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		AsyncContext asyncContext = req.startAsync();
		asyncContext.setTimeout(-1);

		AsyncContextListener listener = asyncContext.createListener(AsyncContextListener.class);
		asyncContext.addListener(listener);

		asyncContext.start(new AsyncTask(asyncContext));
		resp.getWriter().println("Async started");
	}

}
