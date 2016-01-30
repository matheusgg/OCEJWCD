package async;

import java.io.PrintWriter;

import javax.servlet.AsyncContext;

public class MyAsyncTask implements Runnable {

	private AsyncContext asyncContext;
	private PrintWriter writer;

	public MyAsyncTask(AsyncContext asyncContext, PrintWriter writer) {
		this.asyncContext = asyncContext;
		this.writer = writer;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(3000);

			this.writer.println("Resposta da tarefa assincrona!");

			/*
			 * O metodo complete() informa para o container que a tarefa foi
			 * finalizada, porem a resposta nao é commitada e enviada para o
			 * cliente ate a finalizacao do metod run, deste modo, ainda é
			 * possivel escrever na resposta.
			 */
			this.asyncContext.complete();

			// Isso nao sera escrito na resposta se o time out se esgotar, caso
			// contrario, sera enviado para o cliente.
			this.writer.println("Tarefa assincrona finalizada!");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
