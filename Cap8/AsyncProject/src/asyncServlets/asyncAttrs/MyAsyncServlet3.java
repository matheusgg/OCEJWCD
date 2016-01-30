package asyncServlets.asyncAttrs;

import java.io.IOException;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import async.MyAsyncTask2;

@WebServlet(value = "/MyAsyncServlet3", asyncSupported = true)
public class MyAsyncServlet3 extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1034645466825727777L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		AsyncContext asyncContext = req.startAsync();
		MyAsyncTask2 task2 = new MyAsyncTask2(asyncContext, resp.getWriter());
		asyncContext.start(task2);
	}

}
