package listeners;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletException;

public class AppContextListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("AppContextListener.contextInitialized()");

		ServletContext context = sce.getServletContext();

		try {
			AppSessionListener appSessionListener = context.createListener(AppSessionListener.class);
			context.addListener(appSessionListener);

		} catch (ServletException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("AppContextListener.contextDestroyed()");
	}

}
