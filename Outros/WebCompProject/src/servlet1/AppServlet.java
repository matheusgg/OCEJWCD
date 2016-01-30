package servlet1;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/map1", name = "map1")
public class AppServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5035317550197097740L;

	@PostConstruct
	public void post() {
		System.out.println("AppServlet.post()");
	}

	@Override
	public void init() throws ServletException {
		super.init();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.getWriter().println("<h1>");
		resp.getWriter().println(super.getServletName());
		resp.getWriter().println("</h1>");
	}

	@Override
	public void destroy() {
		super.destroy();
	}

	@PreDestroy
	public void pre() {
		System.out.println("AppServlet.pre()");
	}

}
