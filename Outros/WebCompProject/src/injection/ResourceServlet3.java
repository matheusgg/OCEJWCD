package injection;

import javax.annotation.PostConstruct;
import javax.annotation.Resources;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;

@WebServlet(urlPatterns = "/Injection/ResourceServlet3", loadOnStartup = 3)
// @Resources({ @Resource(name = "ds/MySQL1", type = DataSource.class,
// mappedName = "java:jboss/datasources/MySQL"),
// @Resource(name = "ds/MySQL2", type = DataSource.class, mappedName = "java:jboss/datasources/MySQL") })
public class ResourceServlet3 extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6066158877430108044L;

	@PostConstruct
	public void post() {
		try {

			System.out.println(InitialContext.<DataSource>doLookup("java:comp/env/" + this.getClass().getAnnotation(Resources.class).value()[0].name()));
			System.out.println(InitialContext.<DataSource>doLookup("java:comp/env/" + this.getClass().getAnnotation(Resources.class).value()[1].name()));

		} catch (Exception e) {
			super.log(e.getMessage(), e);
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {

			resp.getWriter().println("<h1>");
			resp.getWriter().println(InitialContext.<DataSource>doLookup("java:comp/env/" + this.getClass().getAnnotation(Resources.class).value()[0].name()));
			resp.getWriter().println("</h1>");

			resp.getWriter().println("<h1>");
			resp.getWriter().println(InitialContext.<DataSource>doLookup("java:comp/env/" + this.getClass().getAnnotation(Resources.class).value()[1].name()));
			resp.getWriter().println("</h1>");

		} catch (Exception e) {
			throw new ServletException(e);
		}
	}
}
