package async;

import java.io.PrintWriter;

import javax.servlet.AsyncContext;

public class MyAsyncTask3 implements Runnable {

	private AsyncContext asyncContext;
	private PrintWriter writer;

	public MyAsyncTask3(AsyncContext asyncContext, PrintWriter writer) {
		this.asyncContext = asyncContext;
		this.writer = writer;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(3000);

			this.writer.println("Antes do forward em AsyncServlet");

			this.asyncContext.dispatch("/AsyncServlet2");
			/*
			 * Não é permitida a chamada ao metodo complete() depois que o
			 * metodo dispatch() foi invocado, e vice-versa. Agora o metodo
			 * complete() so pode ser invocado novamente caso seja iniciada uma
			 * nova tarefa assincrona. Ou seja, é permitido a chamada de apenas
			 * um dos dois metodos no memso AsyncContext, nunca os dois!
			 */
			// this.asyncContext.complete();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
