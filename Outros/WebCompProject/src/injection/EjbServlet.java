package injection;

import injection.ejb.ClienteBean;

import javax.annotation.PostConstruct;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/Injection/EjbServlet", loadOnStartup = 4)
public class EjbServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6729538187230414487L;

	// @EJB(beanName = "Cliente", name = "ejb/client")
	private ClienteBean cliente;

	@PostConstruct
	public void post() {
		try {

			System.out.println(this.cliente);
			System.out.println(InitialContext.<ClienteBean>doLookup("java:comp/env/ejb/client"));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.getWriter().println(this.cliente);
	}

}
