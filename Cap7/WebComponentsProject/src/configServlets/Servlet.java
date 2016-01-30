package configServlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Quando um mapeamento de Servlet esta definido na anotacao e no web.xml, o que
 * prevalece é a configuracao do web.xml
 * 
 * @author Matheus
 * 
 */
// Esse mapeamento sera ignorado
@WebServlet(value = "/*", name = "configServlets.Servlet")
public class Servlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 51590072289617649L;

	@Override
	public void init() throws ServletException {
		System.out.println("Init de " + super.getServletName());
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.getWriter().write("configServlets.Servlet");
	}

}
