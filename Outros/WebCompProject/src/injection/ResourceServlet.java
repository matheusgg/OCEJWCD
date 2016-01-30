package injection;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@WebServlet(urlPatterns = "/Injection/ResourceServlet", loadOnStartup = 1)
public class ResourceServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6066158877430108044L;

	private DataSource ds;

	private DataSource ds2;

	@PostConstruct
	public void post() {
		System.out.println(this.ds);
		System.out.println(this.ds2);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.getWriter().println("<h1>");
		resp.getWriter().println(this.ds);
		resp.getWriter().println("</h1>");

		resp.getWriter().println("<h1>");
		resp.getWriter().println(this.ds2);
		resp.getWriter().println("</h1>");
	}
}
