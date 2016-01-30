package listeners;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

public class AppRequestListener implements ServletRequestListener {

	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		System.out.println("AppRequestListener.requestDestroyed()");
	}

	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		System.out.println("AppRequestListener.requestInitialized()");

		try {
			ServletContext context = sre.getServletContext();
			AppSessionListener appSessionListener = context.createListener(AppSessionListener.class);

			/*
			 * Aqui uma excecao sera lancada, pois nao é possivel adicionar
			 * servlets, filters ou listeners dinamicamente apos o contexto ter
			 * sido totalmente inicializado.
			 */
			context.addListener(appSessionListener);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
