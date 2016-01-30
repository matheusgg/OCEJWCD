package asyncDispatcher;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import async.MyAsyncTask3;

@WebServlet(value = "/AsyncServlet", asyncSupported = true)
public class AsyncServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5953625757773098793L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter writer = resp.getWriter();
		writer.println("Criando um AsyncContext em AsyncServlet...");

		/*
		 * Nao é possivel chamar startAsync() depois que a resposta esteja
		 * commitada.
		 */
		AsyncContext asyncContext = req.startAsync();
		MyAsyncTask3 task3 = new MyAsyncTask3(asyncContext, writer);
		asyncContext.start(task3);
	}

}
