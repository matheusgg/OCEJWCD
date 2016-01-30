package asyncTimeout.listener;

import java.io.IOException;

import javax.servlet.AsyncEvent;
import javax.servlet.AsyncListener;

public class CustomAsyncListener implements AsyncListener {

	@Override
	public void onComplete(AsyncEvent event) throws IOException {
		System.out.println("CustomAsyncListener.onComplete()");
	}

	/**
	 * Quando o tempo de timeout é alcancado, o container chama o metodo
	 * onTomeout() de todos os listener registrados no AsyncContext, e caso
	 * algum não chame metodo complete() ou dispatch(), o containder deve chamar
	 * o metodo complete() de AsyncContext automaticamente, desta forma, após o
	 * timeout, qualquer tentativa de chamada ao metodo complete() gerara uma
	 * excecao.
	 */
	@Override
	public void onTimeout(AsyncEvent event) throws IOException {
		System.out.println("CustomAsyncListener.onTimeout()");
	}

	@Override
	public void onError(AsyncEvent event) throws IOException {
		System.out.println("CustomAsyncListener.onError()");
	}

	@Override
	public void onStartAsync(AsyncEvent event) throws IOException {
		System.out.println("CustomAsyncListener.onStartAsync()");
	}

}
