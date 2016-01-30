package filterWrapper;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;

@WebFilter("/map10")
public class BigFilter implements Filter {

	private FilterConfig filterConfig;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig = filterConfig;
		System.out.println("Init de " + this.filterConfig.getFilterName());
	}

	/**
	 * Utilizando o mecanismo de filtro com um custom
	 * HttpServletResponseWrapper.
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		CustomResposeWrapper customResposeWrapper = new CustomResposeWrapper((HttpServletResponse) response);

		chain.doFilter(request, customResposeWrapper);

		if (!customResposeWrapper.isCommitted()) {
			customResposeWrapper.writeDataToClient();
		}
	}

	@Override
	public void destroy() {

	}

}
