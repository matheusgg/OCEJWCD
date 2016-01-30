package servlets;

import java.io.IOException;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/AsyncServlet2", asyncSupported = true)
public class AsyncServlet2 extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3064951871426981417L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.getWriter().println(req.getAttribute(AsyncContext.ASYNC_CONTEXT_PATH));
		resp.getWriter().println(req.getAttribute(AsyncContext.ASYNC_REQUEST_URI));
		resp.getWriter().println(req.getAttribute(AsyncContext.ASYNC_SERVLET_PATH));
		resp.getWriter().println(req.getAttribute(AsyncContext.ASYNC_PATH_INFO));
		resp.getWriter().println(req.getAttribute(AsyncContext.ASYNC_QUERY_STRING));
	}

}
