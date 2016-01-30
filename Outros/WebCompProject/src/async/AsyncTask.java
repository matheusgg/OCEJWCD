package async;

import javax.servlet.AsyncContext;

public class AsyncTask implements Runnable {

	private AsyncContext asyncContext;

	public AsyncTask(AsyncContext asyncContext) {
		this.asyncContext = asyncContext;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(5000);

			this.asyncContext.getResponse().getWriter().println("dispatching");
			this.asyncContext.dispatch("/async/test2");
			this.getClass();

		} catch (Exception e) {
			this.asyncContext.getRequest().getServletContext().log(e.getMessage());
		}
	}

}
