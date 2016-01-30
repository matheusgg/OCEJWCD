package async;

import java.io.PrintWriter;

import javax.servlet.AsyncContext;

public class MyAsyncTask4 implements Runnable {

	private AsyncContext asyncContext;
	private PrintWriter writer;

	public MyAsyncTask4(AsyncContext asyncContext, PrintWriter writer) {
		this.asyncContext = asyncContext;
		this.writer = writer;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(3000);

			this.writer.println(this.asyncContext.getRequest().getAttribute(AsyncContext.ASYNC_CONTEXT_PATH));
			this.writer.println(this.asyncContext.getRequest().getAttribute(AsyncContext.ASYNC_REQUEST_URI));
			this.writer.println(this.asyncContext.getRequest().getAttribute(AsyncContext.ASYNC_SERVLET_PATH));
			this.writer.println(this.asyncContext.getRequest().getAttribute(AsyncContext.ASYNC_PATH_INFO));
			this.writer.println(this.asyncContext.getRequest().getAttribute(AsyncContext.ASYNC_QUERY_STRING));

			/*
			 * Como uma nova tarefa assincrona foi criada em AsyncServlet2, é
			 * possivel chamar o metodo complete() para informar que essa
			 * segunda tarefa foi finalizada. A chamada ao metodo complete()
			 * depois que a resposta foi commitada causara uma excecao.
			 */
			this.asyncContext.complete();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
