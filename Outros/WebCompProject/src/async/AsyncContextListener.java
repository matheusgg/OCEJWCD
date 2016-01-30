package async;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.AsyncEvent;
import javax.servlet.AsyncListener;
import javax.sql.DataSource;

public class AsyncContextListener implements AsyncListener {

	// @Resource(name = "jdbc/app_db")
	@Resource(name = "java:jboss/datasources/MySQL")
	private DataSource dataSource;

	@Override
	public void onComplete(AsyncEvent event) throws IOException {
		System.out.println("AsyncContextListener.onComplete()");
	}

	@Override
	public void onTimeout(AsyncEvent event) throws IOException {
		System.out.println("AsyncContextListener.onTimeout()");
	}

	@Override
	public void onError(AsyncEvent event) throws IOException {
		System.out.println("AsyncContextListener.onError()");
	}

	@Override
	public void onStartAsync(AsyncEvent event) throws IOException {
		System.out.println("AsyncContextListener.onStartAsync()");
	}

}
