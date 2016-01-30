package filterIncludeForward;

import java.io.IOException;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Este filtro sera executado em operacoes de REQUEST e INCLUDE
 * 
 * @author Matheus
 * 
 */
@WebFilter(value = { "/map8", "/map9" }, dispatcherTypes = { DispatcherType.REQUEST, DispatcherType.INCLUDE })
public class MyFilter4 implements Filter {

	private FilterConfig filterConfig;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig = filterConfig;
		System.out.println("Init de MyFilter4");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("Begin doFilter " + this.filterConfig.getFilterName());
		chain.doFilter(request, response);
		System.out.println("End doFilter " + this.filterConfig.getFilterName());
	}

	@Override
	public void destroy() {

	}

}
