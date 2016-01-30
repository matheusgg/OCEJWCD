package resumo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "AppServlet", urlPatterns = { "/AppServlet" }, initParams = { @WebInitParam(name = "appParam", value = "appValue") })
public class AppServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5139780306244746980L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String forward = req.getParameter("forward");

		/*
		 * É possivel recuperar um RequestDispatcher que pode ser utilizado para
		 * realizar o redirecionamento para um determinado recuroso ou inclui-lo
		 * na resposta. O metodo getNamedDispatcher(String) recupera um
		 * dispatcher para o web componente informado (servlet, jsp, etc). Ja o
		 * metodo getRequstDispatcher recupera um dispatcher para um recurso
		 * normalmente estatico.
		 */
		RequestDispatcher namedDispatcher = super.getServletContext().getNamedDispatcher("MyServlet");

		if (forward != null && forward.equals("true")) {
			namedDispatcher.forward(req, resp);
		} else {
			namedDispatcher.include(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter writer = resp.getWriter();

		ServletContext servletContext = super.getServletContext();
		writer.println(servletContext.getServletContextName());
		writer.println(servletContext.getServerInfo());
		writer.println(servletContext.getInitParameter("contextParam1"));

		ServletConfig servletConfig = super.getServletConfig();
		writer.println(servletConfig.getServletName());
		writer.println(servletConfig.getInitParameter("appParam"));
	}

}
