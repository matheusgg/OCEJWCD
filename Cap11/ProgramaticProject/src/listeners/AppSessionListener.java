package listeners;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class AppSessionListener implements HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		System.out.println("AppSessionListener.sessionCreated()");
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		System.out.println("AppSessionListener.sessionDestroyed()");
	}

}
