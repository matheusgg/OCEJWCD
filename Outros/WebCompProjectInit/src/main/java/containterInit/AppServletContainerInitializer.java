package containterInit;

import java.util.Set;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.HandlesTypes;

import programaticReg.ApplicationContextListener;

@HandlesTypes({ ApplicationContextListener.class })
public class AppServletContainerInitializer implements ServletContainerInitializer {

	@SuppressWarnings("unchecked")
	@Override
	public void onStartup(Set<Class<?>> classes, ServletContext ctx) throws ServletException {
		System.out.println("AppServletContainerInitializer.onStartup()");

		if (classes != null) {
			for (Class<?> clazz : classes) {
				if (ApplicationContextListener.class.isAssignableFrom(clazz)) {
					ctx.addListener((Class<ApplicationContextListener>) clazz);
				}
			}
		}
	}

}
