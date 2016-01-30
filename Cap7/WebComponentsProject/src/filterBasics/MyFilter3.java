package filterBasics;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

/**
 * Os parametros de inicializacao dos filtros tando declarados no web.xml quanto
 * na propria classe sao adicionados no FilterConfig.
 * 
 * @author Matheus
 * 
 */
@WebFilter(filterName = "MyFilter3", initParams = { @WebInitParam(name = "nameTeste", value = "valueTeste") })
public class MyFilter3 implements Filter {

	private FilterConfig filterConfig;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig = filterConfig;
		System.out.println("Init de MyFilter3");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		chain.doFilter(request, response);

		response.getWriter().println("Parametro de init 'name' adicionado no web.xml: " + this.filterConfig.getInitParameter("name"));
		response.getWriter().println("Parametro de init 'nameTeste' adicionado na classe: " + this.filterConfig.getInitParameter("nameTeste"));
	}

	@Override
	public void destroy() {

	}

}
