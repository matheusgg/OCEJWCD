package listeners;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

public class AppRequestListener implements ServletRequestListener {

	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		sre.getServletContext().log("Listener initialized!");
	}

	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		sre.getServletContext().log("Listener destroyed!");
	}

}
