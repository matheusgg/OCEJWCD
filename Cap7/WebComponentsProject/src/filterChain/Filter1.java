package filterChain;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Nao é possivel definir a ordem de execucao dos filtros quando se utiliza
 * anotacoes, apenas quando mapeamento é declarado no web.xml. Dessa forma a
 * ordem de execucao segue a ordem de declaracao no arquivo.
 * 
 * @author Matheus
 * 
 */
@WebFilter
public class Filter1 implements Filter {

	private FilterConfig filterConfig;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig = filterConfig;
		System.out.println("Filter1 da chain inicializado!");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		request.setAttribute("attrFilter1", this.filterConfig.getFilterName());
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {

	}

}
