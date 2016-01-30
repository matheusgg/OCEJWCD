package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * O ciclo de vida de uma servlet � bem definido. Primeiro a classe � carregada
 * pelo ClassLoader, depois uma instancia da servlet � criada, ap�s isso o
 * m�todo init � chamado para inicializar a servlet e preenche-la com os dados
 * necess�rios. Depois, quando a servlet receber uma requisicao, o m�todo
 * service � chamado para verificar qual o tipo de requisicao, depois disso, de
 * acordo com o tipo de requisicao, o m�todo correto ser� chamado. Por fim, o
 * m�todo destroy ser� invocado quando o container for remover a servlet e o
 * garbage collector for destruir essa instancia. Caso ocorra alguma exce��o
 * durante a inicializacao da servlet (init), o m�todo destroy n�o ser� chamado,
 * uma vez que seu proposito � liberar possiveis recursos utilizados pela
 * servlet, se o erro ocorreu no m�todo init, que serve justamente para alocar
 * esses recursos, n�o faz sentido chamar o m�todo destroy para liber�-los. Por
 * padr�o nenhum m�todo http � implementado. A hierarquia de classe come�a com a
 * interface Servlet > depois a classe abstrada GenericServlet que implementa
 * Servlet > e por fim, HttpServlet que estende GenericServlet.
 * 
 * @author Matheus
 * 
 */
public class MyServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6430136515361479489L;

	// private static boolean disponivel;

	/**
	 * Os m�todos doHead, doOptions e doTrace j� possuem implementacoes padrao,
	 * desta forma nao � necess�rio implementa-los, a nao ser que seja uma caso
	 * muito especifico. � importante saber que o m�todo doHead verifica o
	 * cabecalho da requisicao atraves da chamada ao metodo doGet.
	 */
	public MyServlet() {
		this.getClass();
	}

	/**
	 * Caso uma UnavailableException ocorra no metodo init, o container nao
	 * permitira que outra requisicao ocorra para essa servlet durante o tempo
	 * determinado na excecao, isto �, o cliente receber� um erro 4xx indicando
	 * que o recurso nao existe durante o periodo de tempo especificado.
	 */
	@Override
	public void init() throws ServletException {
		// if (!MyServlet.disponivel) {
		// MyServlet.disponivel = true;
		// throw new UnavailableException("Indispon�vel");
		// } else {
		super.init();
		super.log("Log init");
		// }
	}

	/**
	 * Caso ocorra uma UnavailableException no metodo service, o container
	 * marcara essa servlet como indisponivel pelo periodo de tempo
	 * especificado. Derante esse periodo, qualquer requisicao para essa servlet
	 * resultara em um erro 5xx informado que o recurso nao esta disponivel.
	 * Por�m, n�o � uma boa pratica implementar o metodo service, ja que uma
	 * implementacao padrao � provida pelas superclasses.
	 */
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// throw new UnavailableException("Indispon�vel", 30);
		super.service(req, resp);
	}

	/**
	 * Para prover suporte para um m�todo basta apenas implementar o m�todo
	 * correspondente de HttpServlet. Por conversao e boas praticas, o metodo
	 * service(HttpServletRequest,HttpServletResponse) e todos os metodos doXXX
	 * sao protected, pois desta forma o container nao possui acesso direto a
	 * eles. O container invoca o metodo service(ServletRequest,ServletResponse)
	 * herdado de Servlet em qualquer requisicao, e dentro de service a tarefa �
	 * delegada para o metodo correto, por este motido � uma boa pratica manter
	 * os metodos doXXX protegidos, inclusive essa pratica esta na guideline da
	 * especificacao de servlets.
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter writer = resp.getWriter();
		writer.write("<h1>Metodo GET</h1>");
	}

	/**
	 * Invocado quando o container remover essa servlet para deixa-la disponivel
	 * para o garbage collector. Essa remocao pode ocorrer devido a um grande
	 * periodo de tempo sem utilizacao da servlet ou quando a aplicacao for
	 * desimplantada do container.
	 */
	@Override
	public void destroy() {
		super.destroy();
	}
}
