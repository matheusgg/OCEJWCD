package requestDispatcher;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "AppServlet3", urlPatterns = "/AppServlet3")
public class AppServlet3 extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1599993563408449202L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("AppServlet3 - Tentando alterar o cabecalho adicionando o parametro teste");

		/*
		 * Como o writer nao foi montado atraves da chamada ao metodo
		 * getWriter(), porem o metodo getOutputStream() ja foi chamado para
		 * incluir o arquivo na resposta na AppServlet2, a resposta sera
		 * commitada quando o fluxo retornar para essa servlet, entao qualquer
		 * tentativa de recuperar um writer resultara em uma excecao.
		 */
		// resp.getWriter().write("AppServlet3 - Tentando alterar o cabecalho adicionando o parametro teste");

		resp.addHeader("teste", "valor");
	}

}
