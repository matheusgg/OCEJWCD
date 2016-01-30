package annotations.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Na configuracao de filtros, em servletNames, é possivel utilizar o caracter
 * coring "*" para informar que este filtro esta mapeado para todas as servlets
 * da aplicacao.
 * 
 * @author Matheus
 * 
 */
@WebFilter(servletNames = "AppServlet")
public class AppFilter implements Filter {

	private FilterConfig filterConfig;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig = filterConfig;
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		response.getWriter().println(this.filterConfig.getFilterName());
		chain.doFilter(request, response);
		response.getWriter().println(this.filterConfig.getFilterName());
	}

	@Override
	public void destroy() {

	}

}
