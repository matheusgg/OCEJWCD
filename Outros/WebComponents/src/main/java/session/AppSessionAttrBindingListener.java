package session;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

@WebListener
public class AppSessionAttrBindingListener implements HttpSessionAttributeListener, HttpSessionBindingListener {

	@Override
	public void valueBound(HttpSessionBindingEvent event) {
		System.out.println("AppSessionAttrBindingListener.valueBound()");
	}

	@Override
	public void valueUnbound(HttpSessionBindingEvent event) {
		System.out.println("AppSessionAttrBindingListener.valueUnbound()");
	}

	@Override
	public void attributeAdded(HttpSessionBindingEvent event) {
		System.out.println("AppSessionAttrBindingListener.attributeAdded()");
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent event) {
		System.out.println("AppSessionAttrBindingListener.attributeRemoved()");
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent event) {
		System.out.println("AppSessionAttrBindingListener.attributeReplaced()");
	}

}
