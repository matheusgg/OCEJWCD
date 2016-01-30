package asyncListener.task;

import javax.servlet.AsyncContext;

public class AsyncTask implements Runnable {

	private AsyncContext asyncContext;

	public AsyncTask(AsyncContext asyncContext) {
		this.asyncContext = asyncContext;
	}

	@Override
	public void run() {
		this.asyncContext.dispatch("/AsyncListener2");
	}

}
