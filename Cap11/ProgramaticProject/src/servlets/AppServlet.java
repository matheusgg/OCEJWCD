package servlets;

import java.io.IOException;
import java.util.EnumSet;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AppServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7744391153685027972L;

	@Override
	public void init() throws ServletException {
		System.out.println("AppServlet.init()");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.getWriter().println(super.getServletName());

		/*
		 * É possivel realizar a configuracao de filtros e servlets
		 * programaticamente em tempo de execucao fora de um
		 * ServletContextListener ou em ServletContainerInitializer.
		 */
		FilterRegistration filterRegistration = super.getServletContext().getFilterRegistration("AppFilter");

		/*
		 * Configurando esse filtro para ser executado antes de qualquer outro
		 * filtro em qualquer mapeamento de qualquer servlet.
		 */
		filterRegistration.addMappingForServletNames(EnumSet.allOf(DispatcherType.class), false, "*");
	}

}
