package filter1;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter(value = "/map1", filterName = "map1")
public class AppFilter implements Filter {

	@PostConstruct
	public void post() {
		System.out.println("AppFilter.post()");
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("AppFilter.init()");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		System.out.println("AppFilter.destroy()");
	}

	@PreDestroy
	public void pre() {
		System.out.println("AppFilter.pre()");
	}

}
