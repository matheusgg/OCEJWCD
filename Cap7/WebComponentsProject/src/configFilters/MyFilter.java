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
 * Apenas uma instancia desse filtro sera criada. O mapeamento se encontra aqui,
 * ja a definicao esta no web.xml. Porem um mapeamento também se encontra no
 * web.xml, nesta caso, o que prevalece é o que esta no web.xml.
 * 
 * @author Matheus
 * 
 */
// Esse mapeamento sera ignorado
@WebFilter(filterName = "MyFilter", value = "/*")
public class MyFilter implements Filter {

	private FilterConfig filterConfig;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig = filterConfig;
		System.out.println("Init de " + this.filterConfig.getFilterName());
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		chain.doFilter(request, response);

		HttpServletResponse resp = (HttpServletResponse) response;
		resp.addHeader("filterInitParam", this.filterConfig.getInitParameter("name"));
	}

	@Override
	public void destroy() {
		System.out.println("Destroy de " + this.filterConfig.getFilterName());
	}

}
