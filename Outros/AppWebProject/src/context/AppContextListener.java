package context;

import java.util.EnumSet;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebListener;

@WebListener
public class AppContextListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ServletContext servletContext = sce.getServletContext();

		try {
			ContextFilter1 filter1 = servletContext.createFilter(ContextFilter1.class);
			ContextFilter2 filter2 = servletContext.createFilter(ContextFilter2.class);

			FilterRegistration.Dynamic fr1 = servletContext.addFilter("ContextFilter1", filter1);
			FilterRegistration.Dynamic fr2 = servletContext.addFilter("ContextFilter2", filter2);

			fr1.addMappingForUrlPatterns(EnumSet.allOf(DispatcherType.class), true, "/ContextServlet");
			fr2.addMappingForServletNames(EnumSet.allOf(DispatcherType.class), false, "context.ContextServlet");

		} catch (ServletException e) {
			servletContext.log(e.getMessage(), e);
		}
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {

	}

}
