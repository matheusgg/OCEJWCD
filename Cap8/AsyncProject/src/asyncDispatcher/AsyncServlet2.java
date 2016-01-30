package asyncDispatcher;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import async.MyAsyncTask4;

@WebServlet(value = "/AsyncServlet2", asyncSupported = true)
public class AsyncServlet2 extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5953625757773098793L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter writer = resp.getWriter();
		writer.println("Criando um AsyncContext em AsyncServlet2...");

		/*
		 * Aqui uma nova tarefa assincrona é criada.
		 */
		AsyncContext asyncContext = req.startAsync();
		MyAsyncTask4 task4 = new MyAsyncTask4(asyncContext, writer);
		asyncContext.start(task4);
	}

}
