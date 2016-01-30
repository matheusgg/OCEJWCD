package contextListeners;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;

/**
 * Um ServletContextAttributeListener é utilizado para ser notificado quando
 * ocorre alguma alteracao nos atributos do contexto, isto é, quando um atributo
 * de escopo de aplicacao for adicionado, alterado ou removido.
 * 
 * @author Matheus
 * 
 */
// @WebListener
public class ServContextAttrListener implements ServletContextAttributeListener {

	/**
	 * Método chamado quando um novo atributo é adicionado no contexto. Um
	 * ServletContextAttributeEvent que extende ServletContextEvent é passado
	 * como parametro e contem informacoes do evento.
	 */
	@Override
	public void attributeAdded(ServletContextAttributeEvent scab) {
		System.out.println("Atributo adicionado!\nNome: " + scab.getName() + " / Valor: " + scab.getValue());
	}

	/**
	 * Esse metodo é chamado quando logo apos que um atributo de contexto foi
	 * removido. Dentro de ServletContextAttributeEvent estao informacoes sobre
	 * o evento e o valor antido do atributo que foi removido.
	 */
	@Override
	public void attributeRemoved(ServletContextAttributeEvent scab) {
		System.out.println("Atributo removido!\nNome: " + scab.getName() + " / Valor antigo: " + scab.getValue());
	}

	/**
	 * Método invocado quando um atributo de contexto é sobrescrito.
	 * ServletContextAttributeEvent traz informacoes sobre o eventos, assim
	 * também como uma referencia so ServletContext da aplicacao e o valor
	 * antido do atributo que foi sobrescrito.
	 */
	@Override
	public void attributeReplaced(ServletContextAttributeEvent scab) {
		System.out.println("Atributo sobrescrito!\nNome: " + scab.getName() + " / Valor antigo: " + scab.getValue() + " / Novo valor: "
				+ scab.getServletContext().getAttribute(scab.getName()));
	}

}
