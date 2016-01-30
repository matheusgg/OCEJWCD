package asyncServlets.asyncAttrs;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/MyAsyncServlet4", asyncSupported = true)
public class MyAsyncServlet4 extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1034645466825727777L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter writer = resp.getWriter();

		writer.println("<h1>Atributos</h1>");
		writer.println(req.getAttribute("javax.servlet.async.request_uri"));
		writer.println(req.getAttribute("javax.servlet.async.servlet_path"));
		writer.println(req.getAttribute("javax.servlet.async.context_path"));
		writer.println(req.getAttribute("javax.servlet.async.path_info"));
		writer.println(req.getAttribute("javax.servlet.async.query_string"));

		writer.println("<h1>Metodos</h1>");
		writer.println(req.getRequestURI());
		writer.println(req.getServletPath());
		writer.println(req.getContextPath());
		writer.println(req.getPathInfo());
		writer.println(req.getQueryString());
	}

}
