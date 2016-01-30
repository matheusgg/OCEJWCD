package fragment1;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class AppListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("AppListener de Fragmento 1");
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {

	}

}
