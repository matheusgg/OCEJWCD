package includeAndForward;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "RDServlet", urlPatterns = "/RDServlet")
public class RDServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4799488650582312716L;

	/**
	 * Utilizando o include() para testar os atributos que o container adiciona
	 * na requisicao
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("javax.servlet.include.msg", "Atributos adicionados quando o RequestDispatcher foi criado com o metodo getRequestDispatcher");
		/*
		 * É possivel passar parametros na criacao de um RD
		 */
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("RDServlet2?teste=teste");
		requestDispatcher.include(req, resp);

		req.setAttribute("javax.servlet.include.msg", "Atributos adicionados quando o RequestDispatcher foi criado com o metodo getNamedDispatcher");
		RequestDispatcher namedDispatcher = super.getServletContext().getNamedDispatcher("RDServlet2");
		namedDispatcher.include(req, resp);
	}

	/**
	 * Utilizando o forward() para testar os atributos que o container adiciona
	 * na requisicao
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String rdType = req.getParameter("rdType");

		if (rdType != null && !rdType.equals("named")) {
			req.setAttribute("javax.servlet.forward.msg", "Atributos adicionados quando o RequestDispatcher foi criado com o metodo getRequestDispatcher");
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("RDServlet2");
			requestDispatcher.forward(req, resp);
		} else {
			/*
			 * Caso o forward() seja feito com o RD criado apartir do metodo
			 * getNamedDispatcher, nenhum atributo é adicionado na requisicao e
			 * a UTL, URI, entc. nao sofrem alteracoes.
			 */
			req.setAttribute("javax.servlet.forward.msg", "Atributos adicionados quando o RequestDispatcher foi criado com o metodo getNamedDispatcher");
			RequestDispatcher namedDispatcher = super.getServletContext().getNamedDispatcher("RDServlet2");
			namedDispatcher.forward(req, resp);
		}
	}

}
