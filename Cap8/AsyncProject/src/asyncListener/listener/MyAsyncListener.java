package asyncListener.listener;

import java.io.IOException;

import javax.servlet.AsyncContext;
import javax.servlet.AsyncEvent;
import javax.servlet.AsyncListener;

/**
 * N�o � poss�vel registrar um AsyncListener atraves de annotations ou pelo
 * web.xml. Esse tipo de listener deve ser registrado utilizando um
 * AsyncContext.
 * 
 * @author Matheus
 * 
 */
public class MyAsyncListener implements AsyncListener {

	/**
	 * M�todo chamado quando complete() for invocado.
	 */
	@Override
	public void onComplete(AsyncEvent event) throws IOException {
		/*
		 * Esses metodos retornaram null se esse listener nao estiver sido
		 * registrado atraves da chamada ao metodo addListener() sobrecarregado
		 * que recebe um Request e um Response.
		 */
		// ServletRequest request = event.getSuppliedRequest();
		// ServletResponse response = event.getSuppliedResponse();

		AsyncContext asyncContext = event.getAsyncContext();
		System.out.println(asyncContext.hasOriginalRequestAndResponse());
	}

	/**
	 * M�todo chamado quando o tempo definido em setTimeout() for alcancado.
	 */
	@Override
	public void onTimeout(AsyncEvent event) throws IOException {
		event.getAsyncContext().complete();
	}

	/**
	 * Metodo chamado quando alguma excecao ou erro ocorrer durante o
	 * processamento de um dispatch feito por uma tarefa assincrona.
	 */
	@Override
	public void onError(AsyncEvent event) throws IOException {
		/*
		 * Quando um erro ou excecao ocorre dentro de um recurso (JSP ou
		 * Servlet) acessado atraves de um dispatch feito por uma tarefa
		 * assincrona o metodo getThrowable() retorna o erro original que
		 * ocorreu. Caso contrario, retornar� null.
		 */
		Throwable throwable = event.getThrowable();
		System.out.println(throwable);
		event.getAsyncContext().complete();
	}

	/**
	 * Metodo chamado na segunda vez que o metodo startAsync() for invocado,
	 * pois na primeira vez que startAsync() � chamado ainda n�o h� nenhum
	 * listener registrado no AsyncContext.
	 */
	@Override
	public void onStartAsync(AsyncEvent event) throws IOException {
		System.out.println("MyAsyncListener.onStartAsync()");
	}

}
