package servletContext;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "MyServlet", urlPatterns = { "/MyServlet" })
public class MyServlet extends HttpServlet {

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

		/*
		 * Adicionando um atributo no contexto da aplicacao. A especificacao de
		 * servlets diz que é uma boa pratica colocar o nome completo do dominio
		 * da empresa como identificador do atributo. Desta forma é mais dificil
		 * que haja problemas de atributos com o mesmo identificador. Caso isso
		 * aconteca os atributos serao sobrescritos.
		 */
		servletContext.setAttribute("br.com.servletContext.atributo", "Teste");

		resp.getWriter().write("Atributo adicionado com sucesso!");
		resp.getWriter().write("\nServletContext name (nome da aplicacao): " + servletContext.getServletContextName());
		resp.getWriter().write("\nReal Path: " + servletContext.getRealPath("pasta"));
		resp.getWriter().write("\nMIME type do arquivo file.txt: " + servletContext.getMimeType("/pasta/file.txt"));

		/*
		 * getResourcePaths deve começar com uma '/' e retorna um Set com todos
		 * os caminhos dos arquivos ou diretorios de primeiro nivel que estao no
		 * path especificado.
		 */
		resp.getWriter().write("\nGet Resource Paths: " + servletContext.getResourcePaths("/pasta/file.txt"));

		/*
		 * Esse método retorna o ServletContext da aplicacao especificada pela
		 * url informada. Caso a aplicacao nao exista no container ou o mesmo
		 * restringa o acesso, esse metodo retornara null
		 */
		ServletContext anotherServletContext = servletContext.getContext("/MyServletProject");
		resp.getWriter().write("\nServletContext de outra aplicacao implantada no container: " + anotherServletContext);
	}

	@Override
	public void destroy() {
		System.out.println(super.getServletName() + " está prestes a ser destruída!");
	}
}
