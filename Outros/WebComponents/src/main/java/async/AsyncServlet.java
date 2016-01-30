package async;

import java.io.IOException;

import javax.servlet.AsyncContext;
import javax.servlet.DispatcherType;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/AsyncServlet", asyncSupported = true)
public class AsyncServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8971549866955112699L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (req.getDispatcherType() == DispatcherType.REQUEST) {
			AsyncContext asyncContext = req.startAsync();
			asyncContext.setTimeout(100000);
			asyncContext.addListener(new AppAsyncListener());
			asyncContext.dispatch("/AsyncServlet2?param1=valor");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (req.getDispatcherType() == DispatcherType.REQUEST) {
			AsyncContext asyncContext = req.startAsync();
			asyncContext.setTimeout(100000);
			asyncContext.addListener(new AppAsyncListener());
			asyncContext.dispatch("/AsyncServlet2?param1=valor");

		} else if (req.getDispatcherType() == DispatcherType.ASYNC) {
			resp.getWriter().println("end");
		}
	}

}
