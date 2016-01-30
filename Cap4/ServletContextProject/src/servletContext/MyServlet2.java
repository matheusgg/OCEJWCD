package servletContext;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "MyServlet2", urlPatterns = { "/MyServlet2" })
public class MyServlet2 extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4821121089141927458L;

	/**
	 * A classe ServletContext contém todas as informacoes da applicacao que
	 * esta sendo executada no servidor. É uma classe utilitaria que possui
	 * vários mecanismos para obter informacoes sobre a aplicacao atual. Com ela
	 * é possivel recuperar ServletContexts de outras aplicacoes que estejam
	 * sendo executadas no servidor. Cada aplicacao tem uma ServletContext. O
	 * container cria um objeto ServletContext quando a aplicacao é inicializada
	 * pela primeira vez e preenche esse objeto com informacoes do descritor de
	 * implantacao (web.xml). A ServletContext representa o contexto atual da
	 * aplicacao, por isso é possivel definir atributos com escopo de aplicacao.
	 * Desta forma todas as servlets da applicacao conseguirao acessar esses
	 * atributos, já que todas possuem acesso a ServletContext.
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Recuperando a instancia da ServletContext
		ServletContext servletContext = super.getServletContext();

		String attr = req.getParameter("externalFile");

		if (attr != null && attr.equals("true")) {
			/*
			 * É possível incluir um recurso estatico na resposta utilizando um
			 * RequestDispatcher, para isso basta chamar o metodo include e
			 * passar o path do recurso que deve ser incluido na resposta. O
			 * método include serve para incluir o conteudo de recursoso
			 * estaticos na resposta para o cliente.
			 */
			RequestDispatcher requestDispatcher = super.getServletContext().getRequestDispatcher("/pasta/file.txt");
			requestDispatcher.include(req, resp);

			/*
			 * Escrevendo o conteudo de um arquivo externo na resposta de um
			 * jeito de macho! getOutputStream retorna um ServletOutputStream
			 * para realizar a tarefa de escrever dados binarios na resposta,
			 * porém nao é possivel chamar getOutputStream e getWriter para
			 * escrever na resposta. É possivel utilizar apenas um metodo, nao
			 * os dois. Caso algum deles ja tenha sido chamado, uma excecao sera
			 * lancada.
			 */
			// InputStream inputStream =
			// servletContext.getResourceAsStream("/pasta/file.txt");
			// byte[] array = new byte[inputStream.available()];
			// inputStream.read(array);
			// resp.getOutputStream().write(array);
		} else {
			/*
			 * Recuperando o atributo que foi definido em MyServlet
			 */
			resp.getWriter().print(servletContext.getAttribute("br.com.servletContext.atributo"));

			// Sobrescrita do atributo
			servletContext.setAttribute("br.com.servletContext.atributo", "Teste 2");

			/*
			 * Caso um atributo seja sobrescrito com valor null, obtem-se o
			 * mesmo comportamento de remocao de atributo, ou seja, o atributo é
			 * removido.
			 */
			// servletContext.setAttribute("br.com.servletContext.atributo",
			// null);

			// Remocao do atributo
			servletContext.removeAttribute("br.com.servletContext.atributo");
		}
	}
}
