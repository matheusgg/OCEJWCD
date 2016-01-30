package sessionBindingListener;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

/**
 * Um HttpSessionBindingListener é semelhante a um HttpSessionActivationListener
 * e serve para receber notificacoes de adicao (bound) ou remocao (unbound) de
 * atributos de um determinado objeto HttpSession. Nao deve ser mapeado no DD ou
 * anotado com WebListener, uma vez que é um listener de atributos. Quando um
 * atributo que implementa HttpSessionBindingListener é adicionado ou removida
 * de qualquer HttpSession, ele recebe uma notificacao dessa sessao
 * automaticamente.
 * 
 * @author Matheus
 * 
 */
/**
 * Um HttpSessionBindignListener é chamado antes de qualquer
 * HttpSessionAttributeListener.
 * 
 * @author Matheus
 * 
 */
public class SessionBindingAttr implements HttpSessionBindingListener {

	/**
	 * Metodo chamado quando o atributo é adicionado ao objeto HttpSession
	 */
	@Override
	public void valueBound(HttpSessionBindingEvent event) {
		System.out.println("Atributo " + event.getName() + " adicionado (bound) na sessao " + event.getSession().getId());
	}

	/**
	 * Metodo chamado quando o atributo é removido do objeto HttpSession
	 */
	@Override
	public void valueUnbound(HttpSessionBindingEvent event) {
		System.out.println("Atributo " + event.getName() + " removido (unbound) da sessao " + event.getSession().getId());
	}

}
