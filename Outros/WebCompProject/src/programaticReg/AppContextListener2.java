package programaticReg;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class AppContextListener2 implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		sce.getServletContext().addListener(RequestListener.class);
		System.out.println("AppContextListener2.contextInitialized()");
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("AppContextListener2.contextDestroyed()");
	}

}
