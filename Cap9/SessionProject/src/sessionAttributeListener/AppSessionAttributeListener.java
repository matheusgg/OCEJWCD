package sessionAttributeListener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

/**
 * Com HttpSessionAttributeListener é possivel receber notificacoes de eventos
 * de adicao, remocao e substituicao de atributos de qualquer objeto
 * HttpSession.
 * 
 * @author Matheus
 * 
 */
@WebListener
public class AppSessionAttributeListener implements HttpSessionAttributeListener {

	/**
	 * Método chamado quando um novo atributos é adicionado
	 */
	@Override
	public void attributeAdded(HttpSessionBindingEvent event) {
		System.out.println("Atrubuto [Nome: " + event.getName() + " / Valor: " + event.getValue() + "] adicionado!");
	}

	/**
	 * Método chamado quando um atributo é removido
	 */
	@Override
	public void attributeRemoved(HttpSessionBindingEvent event) {
		System.out.println("Atrubuto [Nome: " + event.getName() + " / Valor antigo: " + event.getValue() + "] removido!");
	}

	/**
	 * Método chamado quando um atributo é substituido
	 */
	@Override
	public void attributeReplaced(HttpSessionBindingEvent event) {
		System.out.println("Atrubuto [Nome: " + event.getName() + " / Valor antigo: " + event.getValue() + " / Novo valor: "
				+ event.getSession().getAttribute(event.getName()) + "] substituido!");
	}

}
