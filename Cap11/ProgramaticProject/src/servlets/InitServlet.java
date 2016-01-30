package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import containerInitializer.ReadOnInit;

@ReadOnInit(initParams = { @WebInitParam(name = "param1", value = "teste") }, urlPatterns = "/InitServlet")
public class InitServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5723791346133721598L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.getWriter().println(super.getServletName());
		resp.getWriter().println("Init param: param1/" + super.getInitParameter("param1"));
	}
}
