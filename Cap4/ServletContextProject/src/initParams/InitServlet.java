package initParams;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Existem dois tipos de parametros de inicializacao: Os parametros de
 * inicializacao de contexto e os parametros de inicializacao de servlet. Os
 * parametros de inicializacao de contexto sao declarados dentro da tag
 * <context-param> no web.xml, já os parametros de inicializacao de servlet sao
 * declarados dentro de <init-param> dentro de <servlet> no web.xml. Para
 * recuperar os parametros de inicializacao de contexto, utiliza-se o metodo
 * getInitParameter(String) da classe ServletContext, já que esta representa o
 * contexto da aplicacao, faz todo sentido ser responsavel pela recuperacao dos
 * parametros de inicializacao de contexto. Já os parametros de inicializacao de
 * servlet sao recuperados pela mesmo metodo getInitParameter porem dentro da
 * classe ServletConfig. Todas as servlets possuem a mesma instancia de
 * ServletContext, porém é possivel inicializar cada servlet com detalhes e
 * parametros diferentes, desta forma, cada servlet possui uma instancia
 * diferente de ServletConfig, que por sua vez encapsula o ServletConfig e
 * possuir detalhes sobre a servlet em questao. A diferenca entre os parametros
 * de inicializacao de contexto e de servlet, é que estes ultimos podem ser
 * acessados apenas pela servlet onde foram declarados, já os parametros de
 * inicializacao de contexto podem ser acessados por todas as servlets da
 * aplicacao.
 * 
 * @author Matheus
 * 
 */
public class InitServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3132079847713573947L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter writer = resp.getWriter();
		writer.write("Parametros de inicializacao de contexto (ServletContext):");
		writer.write("\n" + super.getServletContext().getInitParameter("contextParam1"));

		writer.write("\nParametros de inicializacao de servlet (ServletConfig):");

		// Recupera o nome logico da servlet declarado no web.xml
		writer.write("\nNome da servlet: " + super.getServletConfig().getServletName());
		writer.write("\n" + super.getServletConfig().getInitParameter("param1"));

		/*
		 * A classe generic servlet encapsula o ServletConfig e disponibiliza
		 * metodos convenientes para recuperar informacoes da servlet atual que
		 * equivalem a chamada aos metodos de ServletConfig. As duas linhas
		 * abaixo fazem a mesma tarefa das duas linhas de cima.
		 */
		writer.write("\nNome da servlet: " + super.getServletName());
		writer.write("\n" + super.getInitParameter("param2"));
	}

}
