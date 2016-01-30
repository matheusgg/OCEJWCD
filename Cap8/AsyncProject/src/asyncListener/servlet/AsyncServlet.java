package asyncListener.servlet;

import java.io.IOException;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import asyncListener.listener.MyAsyncListener;
import asyncListener.task.AsyncTask;

@WebServlet(value = "/AsyncListener", asyncSupported = true)
public class AsyncServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3604753869450861155L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.getWriter().write(super.getServletName());

		AsyncContext asyncContext = req.startAsync();
		asyncContext.setTimeout(0);

		/*
		 * O metodo createListener() cria um listener da classe informada que
		 * deve extender AsyncListener. Este metodo adiciona suporte para a
		 * notacoes e injecao de dependencias dentro do listener criado, deste
		 * modo, objetos sao injetados dentro desse listener depois que ele é
		 * criado.
		 */
		MyAsyncListener myAsyncListener = asyncContext.createListener(MyAsyncListener.class);

		/*
		 * O metodo addListener(AsyncListener) registra o listener informado ao
		 * AsyncContext em questao.
		 */
		asyncContext.addListener(myAsyncListener);

		/*
		 * O metodo addListener() é sobrecarregado para receber um
		 * ServletRequest e um ServletResponse, que podem ser recuperados mais
		 * tarde dentro do listener atraves dos metodos getSuppliedRequest() e
		 * getSuppliedResponse() de AsyncEvent.
		 */
		// asyncContext.addListener(myAsyncListener, null, null);

		AsyncTask task = new AsyncTask(asyncContext);
		asyncContext.start(task);
	}

}
