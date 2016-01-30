package filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class AppFilter implements Filter {

	private FilterConfig filterConfig;

	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig = filterConfig;
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		this.filterConfig.getServletContext().log("Before doFilter!");

		chain.doFilter(request, response);

		this.filterConfig.getServletContext().log("After doFilter!");
	}

	public void destroy() {
		this.filterConfig.getServletContext().log("Destroy!");
	}
}
