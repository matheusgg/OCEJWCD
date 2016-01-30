package asyncListener.task;

import javax.servlet.AsyncContext;

public class AsyncTask2 implements Runnable {

	private AsyncContext asyncContext;

	public AsyncTask2(AsyncContext asyncContext) {
		this.asyncContext = asyncContext;
	}

	@Override
	public void run() {
		try {

			Thread.sleep(3000);
			this.asyncContext.complete();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
