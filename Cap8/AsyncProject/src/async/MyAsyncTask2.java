package async;

import java.io.PrintWriter;

import javax.servlet.AsyncContext;

public class MyAsyncTask2 implements Runnable {

	private AsyncContext asyncContext;
	private PrintWriter writer;

	public MyAsyncTask2(AsyncContext asyncContext, PrintWriter writer) {
		this.asyncContext = asyncContext;
		this.writer = writer;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(3000);

			this.writer.println("Antes do forward em MyAsyncTask2");

			/*
			 * Quando dispatch() é chamado, o container assume que apos a
			 * execucao do recurso solicitado a resposta deve ser commitada e
			 * enviada para o cliente, deste modo nao é necessario chamar co
			 * metodo complete(). Caso seja chamado, uma excecao ocorrera.
			 */
			this.asyncContext.dispatch("/MyAsyncServlet4");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
