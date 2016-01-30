package requestDispatcher;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "AppServlet2", urlPatterns = "/AppServlet2")
public class AppServlet2 extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1599993563408449202L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/*
		 * A segunda forma de se recuperar um RequestDispatcher no
		 * ServletContext é atraves do metodo getRequestDispatcher, que recebe o
		 * caminho relativo ao contexto do recurso, ou seja, deve sempre comecar
		 * com uma `/`.
		 */
		RequestDispatcher rd = super.getServletContext().getRequestDispatcher("/folder/file.txt");

		/*
		 * O metodo include() inclui o recurso na resposta e retorna o fluxo
		 * para a primeira Servlet que chamou o include. Caso outra servlet
		 * esteja sendo incluida, o metodo correto (get, post, put, etc), sera
		 * chamado na segunda servlet, porem esta nao podera alterar o cabecalho
		 * e o status da requisicao. Qualquer tentativa de alteracao desses
		 * valores nao tera efeito. O metodo include pode ser chamado antes ou
		 * depois de um writer ser recuperado, pois ele nao commita a resposta.
		 */
		rd.include(req, resp);

		/*
		 * A terceira forma de se obter um RequestDispatcher é atraves do objeto
		 * HttpServletRequest. O metodo getRequestDispatcher recebe o caminho do
		 * recurso. A diferenca desse metodo para o da classe ServletContext, é
		 * que este pode receber o caminho relativo do recurso, ou seja, nao
		 * precisa iniciar com uma `/`. Aqui, a servlet tentara alterar o
		 * cabecalho da resposta, mas nao conseguira.
		 */
		RequestDispatcher rd1 = req.getRequestDispatcher("AppServlet3");
		rd1.include(req, resp);

		System.out.println("AppServlet2 - Depois da chamada ao include() de um RD");
		System.out.println("Verificando se o parametro teste foi adicionado no cabecalho: " + resp.getHeader("teste"));
	}

}
