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

/**
 * Caso nao seja utilizado o atributo asyncSupported=true, se alguma servlet
 * tentar iniciar um contexto assincrono (startAsync()), uma excecao sera
 * gerada, pois nao é possivel iniciar uma operacao assincrona em uma servlet
 * (assincrona ou nao), que foi requisitada a partir de outra servlet (ou
 * filtro) que nao possui suporte assincrono. Porem a situacao contraria é
 * permitida.
 */
@WebFilter(value = "/*", dispatcherTypes = { DispatcherType.ASYNC, DispatcherType.REQUEST }, asyncSupported = true)
public class AsyncFilter implements Filter {

	private FilterConfig filterConfig;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig = filterConfig;
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		response.getWriter().println("Init - " + this.filterConfig.getFilterName());
		chain.doFilter(request, response);
		response.getWriter().println("End - " + this.filterConfig.getFilterName());
	}

	@Override
	public void destroy() {

	}

}
