package injection;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@WebServlet(urlPatterns = "/Injection/ResourceServlet2", loadOnStartup = 2)
public class ResourceServlet2 extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6066158877430108044L;

	// @Resource(name = "java:jboss/datasources/MySQL")
	private DataSource ds;

	@PostConstruct
	public void post() {
		System.out.println(this.ds);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.getWriter().println("<h1>");
		resp.getWriter().println(this.ds);
		resp.getWriter().println("</h1>");
	}
}
