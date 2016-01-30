package filters;

import java.io.IOException;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletResponse;

/**
 * Um Filtro � um mecanismo utilizado para interceptar requisicoes feitas pelo
 * cliente ou por outros componentes web com o objetivo de alterar a requisicao
 * ou a resposta.
 * 
 * @author Matheus
 * 
 */
/**
 * � poss�vel criar um filtro com anotacoes ou atraves do web.xml. O valor do
 * atributo value de WebFilter representa as urlPatterns para as quais este
 * filtro est� mapeado e interceptara as requisicoes. DispatcherTypes serve para
 * especificar para quais tipos de requisicoes esse filtro ser� utilizado e deve
 * ser invocado, por padrao ele esta mapeado para REQUEST, mas pode ser chamado
 * para INCLUDE, FORWARD, ASYNC e ERROR.
 * 
 * @author Matheus
 * 
 */
/**
 * O ciclo de vida de um filtro � semelhante ao ciclo de vida de uma Servlet, a
 * nao ser pelo fato de que as instancias dos filtros sao criadas na implatacao
 * da aplicacao no container por padrao: ClassLoader carrega a classe do filtro
 * > Uma instancia do filtro � criada > O Filtro � inicializado e populado
 * atraves da chamada ao metodo init() > O M�todo doFilter() � chamado durante a
 * fase de servico do filtro, ou seja, quando o filtro intercepta uma
 * requisicao, o metodo doFilter() � chamado > Quando a aplicacao � removida do
 * container, o metodo destroy() � invocado para desalocar recursos que foram
 * alocados pelo filtro.
 * 
 * @author Matheus
 * 
 */
/**
 * Quando nao especificado, o nome padrao do filtro � formado pelo nome do
 * pacote + nome da classe, ficando filters.MyFilter. � possivel especificar o
 * mapeamento para Filtros informando sobre quais servlets ou quais URL eles
 * serao plugados (invocados).
 * 
 * @author Matheus
 * 
 */
@WebFilter(servletNames = { "servlets.MyServlet" }, value = "/*", dispatcherTypes = { DispatcherType.REQUEST, DispatcherType.INCLUDE, DispatcherType.FORWARD }, initParams = { @WebInitParam(name = "filterParam", value = "Teste") })
public class MyFilter implements Filter {

	private String filterParam;

	/**
	 * Quando a aplicacao � implantada no container, o ClassLoader carrega essa
	 * classe e cria uma instancia desse filtro atraves da chamada ao contrutor
	 * padrao da classe. Logo, o contrutor � executado.
	 */
	public MyFilter() {
		System.out.println("Instancia do filtro criada!");
	}

	/**
	 * Ap�s a criacao da instancia do filtro, o mesmo � inicializado e populado
	 * atraves da chamada ao metodo init(). O parametro FilterConfig possui
	 * informacoes sobre esse filtro, informacoes de inicializacao, parametros
	 * de inicializacao, nome do filtro, etc.
	 */
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterParam = filterConfig.getInitParameter("filterParam");
		System.out.println(filterConfig.getFilterName());
	}

	/**
	 * O m�todo doFilter() � chamado a cada vez que o filtro intercepta uma
	 * requicicao, aqui deve ser realizado o processamento desejado. Neste
	 * metodo, pode ser realizada logica para determinar se o proximo filtro da
	 * chain deve ser invocado ou se o recurso (Servlet, JSP, etc) que foi
	 * solicitado deve ser chamado.
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		request.setAttribute("filterParam", this.filterParam);

		/*
		 * A chamada a doFilter() de FilterChain faz com que o proximo filtro na
		 * chain seja invocado.
		 */
		chain.doFilter(request, response);

		/*
		 * Apos a execucao de todos os filtros depois desse na chain, o
		 * processamento volta para esse filtro. Aqui pode ser realizado alguma
		 * logica antes da resposta ser enviada para o cliente.
		 */
		HttpServletResponse resp = (HttpServletResponse) response;
		if (resp.containsHeader("myHead")) {
			resp.getWriter().write("MyFilter diz: MyServlet adicionou o campo de cabecalho myHead!");
		}
	}

	/**
	 * O metodo destroy() � invocado pelo container para desalocar os recursos
	 * utilizados por este filtro quando a aplicacao � desemplantada do
	 * container.
	 */
	@Override
	public void destroy() {
		System.out.println("Filter destroy!");
	}

}
