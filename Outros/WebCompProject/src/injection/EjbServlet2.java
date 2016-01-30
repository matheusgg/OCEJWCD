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

@WebServlet(value = "/Injection/EjbServlet2", loadOnStartup = 5)
// @EJB(beanName = "Cliente", name = "ejb/client1", beanInterface =
// ClienteBean.class)
// @EJBs({ @EJB(name = "ejb/client2", beanInterface = ClienteBean.class),
// @EJB(beanName = "Cliente", name = "ejb/client3", beanInterface =
// ClienteBean.class) })
public class EjbServlet2 extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6729538187230414487L;

	private ClienteBean cliente;

	@PostConstruct
	public void post() {
		try {

			System.out.println(this.cliente);
			System.out.println(InitialContext.<ClienteBean>doLookup("java:comp/env/ejb/client"));
			// System.out.println(InitialContext.doLookup("java:comp/env/ejb/client1"));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.getWriter().println(this.cliente);
	}

	/**
	 * @return the cliente
	 */
	public ClienteBean getCliente() {
		return cliente;
	}

	/**
	 * @param cliente
	 *            the cliente to set
	 */
	// @EJB(name = "ejb/client")
	public void setCliente(ClienteBean cliente) {
		this.cliente = cliente;
	}

}
