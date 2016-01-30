package asyncListener.servlet;

import java.io.IOException;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import asyncListener.task.AsyncTask2;

@WebServlet(value = "/AsyncListener2", asyncSupported = true)
public class AsyncServlet2 extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3604753869450861155L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/*
		 * Se essa excecao ocorrer, o metodo onError do listener
		 * (MyAsyncListener) registrado anteriormente para o AsyncContext será
		 * chamado.
		 */
		if ((Math.random() * 100) > 50) {
			throw new RuntimeException("Excecao de teste");
		}

		resp.getWriter().write(super.getServletName());

		AsyncContext asyncContext = req.startAsync();
		asyncContext.setTimeout(0);
		AsyncTask2 task2 = new AsyncTask2(asyncContext);
		asyncContext.start(task2);
	}

}
