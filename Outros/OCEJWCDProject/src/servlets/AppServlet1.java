package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet(value = "/foo", loadOnStartup = 1, name = "AppServlet1")
public class AppServlet1 extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5201378398482314742L;

	@Override
	public void init() throws ServletException {
		super.init();
	}

}
