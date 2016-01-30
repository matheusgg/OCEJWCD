package session;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/session")
public class SessionServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3112918428344891454L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();

		resp.setContentType("text/html");
		resp.getWriter().println("<h3>");
		resp.getWriter().println("Session ID");
		resp.getWriter().println("</h3>");
		resp.getWriter().println("<h3>");
		resp.getWriter().println(session.getId());
		resp.getWriter().println("</h3>");
		resp.getWriter().println("<h3>");
		resp.getWriter().println("Cookies: ");
		resp.getWriter().println(req.getHeaders("Cookie").nextElement());
		resp.getWriter().println("</h3>");
	}

}
