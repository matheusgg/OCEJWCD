package programaticReg;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

public class RequestListener implements ServletRequestListener {

	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		// System.out.println("RequestListener.requestDestroyed()");
	}

	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		// System.out.println("RequestListener.requestInitialized()");
	}

}
