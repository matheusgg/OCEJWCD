package configFilters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;

/**
 * Com filtros, caso o mapeamento esteja no web.xml e na classe, e a definicao
 * estena na anotacao da classe, os dois mapeamentos sao utilizados.
 * 
 * @author Matheus
 * 
 */
@WebFilter(filterName = "MyFilter2", value = "/map4")
public class MyFilter2 implements Filter {

	private FilterConfig filterConfig;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig = filterConfig;
		System.out.println("Init de " + this.filterConfig.getFilterName());
	}

	/**
	 * Caso o metod doFilter nao seja chamado, a rede é interrompida e o proximo
	 * filtro da chain nao é invocado, consequentemente o recurso alvo
	 * solicitado nao sera executado.
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletResponse resp = (HttpServletResponse) response;
		resp.addHeader("filterName", this.filterConfig.getFilterName());
	}

	@Override
	public void destroy() {

	}

}
