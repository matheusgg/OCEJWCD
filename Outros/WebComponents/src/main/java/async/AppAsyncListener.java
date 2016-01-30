package async;

import java.io.IOException;

import javax.servlet.AsyncEvent;
import javax.servlet.AsyncListener;

public class AppAsyncListener implements AsyncListener {

	@Override
	public void onComplete(AsyncEvent event) throws IOException {
		System.out.println("AppAsyncListener.onComplete()");
	}

	@Override
	public void onTimeout(AsyncEvent event) throws IOException {
		System.out.println("AppAsyncListener.onTimeout()");
	}

	@Override
	public void onError(AsyncEvent event) throws IOException {
		System.out.println("AppAsyncListener.onError()");
	}

	@Override
	public void onStartAsync(AsyncEvent event) throws IOException {
		System.out.println("AppAsyncListener.onStartAsync()");
	}

}
