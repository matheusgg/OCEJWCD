package asyncServlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import async.MyAsyncTask;

@WebServlet(value = "/MyAsyncServlet2", asyncSupported = true)
public class MyAsyncServlet2 extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1034645466825727777L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter writer = resp.getWriter();

		/*
		 * Nessa linha ocorrera uma IllegalStateException se essa servlet for
		 * solicitada (ser realizado um dispatcher) atraves de outra servlet nao
		 * assincrona.
		 */
		AsyncContext asyncContext = req.startAsync();
		MyAsyncTask task = new MyAsyncTask(asyncContext, writer);
		asyncContext.start(task);

		writer.println(super.getServletName());
	}

}
