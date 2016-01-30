package sessionListener;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Um SessionListener serve para monitorar o ciclo de vida de HttpSession.
 * 
 * @author Matheus
 * 
 */
@WebListener
public class AppSessionListener implements HttpSessionListener {

	/**
	 * Método chamado quando o objeto HttpSession é criado.
	 */
	@Override
	public void sessionCreated(HttpSessionEvent se) {
		HttpSession session = se.getSession();
		ServletContext context = session.getServletContext();
		context.log("Sessao criada!");
	}

	/**
	 * Método chamado quando objeto Http Session está prestes a ser destruido.
	 */
	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		HttpSession session = se.getSession();
		ServletContext context = session.getServletContext();
		context.log("Sessao prestes a ser destruida!");
	}

}
