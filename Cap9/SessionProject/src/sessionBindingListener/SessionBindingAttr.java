package sessionBindingListener;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

/**
 * Um HttpSessionBindingListener � semelhante a um HttpSessionActivationListener
 * e serve para receber notificacoes de adicao (bound) ou remocao (unbound) de
 * atributos de um determinado objeto HttpSession. Nao deve ser mapeado no DD ou
 * anotado com WebListener, uma vez que � um listener de atributos. Quando um
 * atributo que implementa HttpSessionBindingListener � adicionado ou removida
 * de qualquer HttpSession, ele recebe uma notificacao dessa sessao
 * automaticamente.
 * 
 * @author Matheus
 * 
 */
/**
 * Um HttpSessionBindignListener � chamado antes de qualquer
 * HttpSessionAttributeListener.
 * 
 * @author Matheus
 * 
 */
public class SessionBindingAttr implements HttpSessionBindingListener {

	/**
	 * Metodo chamado quando o atributo � adicionado ao objeto HttpSession
	 */
	@Override
	public void valueBound(HttpSessionBindingEvent event) {
		System.out.println("Atributo " + event.getName() + " adicionado (bound) na sessao " + event.getSession().getId());
	}

	/**
	 * Metodo chamado quando o atributo � removido do objeto HttpSession
	 */
	@Override
	public void valueUnbound(HttpSessionBindingEvent event) {
		System.out.println("Atributo " + event.getName() + " removido (unbound) da sessao " + event.getSession().getId());
	}

}
