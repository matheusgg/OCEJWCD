package async;

import java.io.IOException;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/AsyncServlet2", asyncSupported = true)
public class AsyncServlet2 extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8971549866955112699L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.getWriter().println(super.getServletName());
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.getWriter().println(super.getServletName());

		AsyncContext ac = req.startAsync();
		ac.dispatch("/AsyncServlet?param2=teste");
	}

}
