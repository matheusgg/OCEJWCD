package sessionAttributeListener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

/**
 * Com HttpSessionAttributeListener � possivel receber notificacoes de eventos
 * de adicao, remocao e substituicao de atributos de qualquer objeto
 * HttpSession.
 * 
 * @author Matheus
 * 
 */
@WebListener
public class AppSessionAttributeListener implements HttpSessionAttributeListener {

	/**
	 * M�todo chamado quando um novo atributos � adicionado
	 */
	@Override
	public void attributeAdded(HttpSessionBindingEvent event) {
		System.out.println("Atrubuto [Nome: " + event.getName() + " / Valor: " + event.getValue() + "] adicionado!");
	}

	/**
	 * M�todo chamado quando um atributo � removido
	 */
	@Override
	public void attributeRemoved(HttpSessionBindingEvent event) {
		System.out.println("Atrubuto [Nome: " + event.getName() + " / Valor antigo: " + event.getValue() + "] removido!");
	}

	/**
	 * M�todo chamado quando um atributo � substituido
	 */
	@Override
	public void attributeReplaced(HttpSessionBindingEvent event) {
		System.out.println("Atrubuto [Nome: " + event.getName() + " / Valor antigo: " + event.getValue() + " / Novo valor: "
				+ event.getSession().getAttribute(event.getName()) + "] substituido!");
	}

}
