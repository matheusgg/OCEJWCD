package listeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class AppContextListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("AppContextListener.contextInitialized()");
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("AppContextListener.contextDestroyed()");
	}

}
