package requestListeners;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ListenerServlet", urlPatterns = { "/ListenerServlet" })
public class ListenerServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -843941828411761903L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String operacao = req.getParameter("addAttr");
		req.setAttribute("br.com.servlet.request.atributo", "Teste");

		switch (operacao) {
		case "remove":
			req.removeAttribute("br.com.servlet.request.atributo");
			break;

		case "replace":
			req.setAttribute("br.com.servlet.request.atributo", "Teste 2");
			break;

		case "replaceNull":
			req.setAttribute("br.com.servlet.request.atributo", null);
			break;
		}

		resp.getWriter().write(operacao + " >>>>> " + req.getAttribute("br.com.servlet.request.atributo"));
	}

}
