package fragment2;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class AppListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("AppListener de Fragmento 2");
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {

	}

}
