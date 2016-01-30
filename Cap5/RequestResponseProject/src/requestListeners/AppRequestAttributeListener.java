package requestListeners;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.http.HttpServletRequest;

/**
 * RequestAttributeListener declarado no web.xml. Como o ServletRequestListener,
 * nao existe um ServletResponseAttributeListener, uma vez que um objeto
 * response nao armazena atributos.
 * 
 * @author Matheus
 * 
 */
// @WebListener
public class AppRequestAttributeListener implements ServletRequestAttributeListener {

	/**
	 * Metodo chamado quando um novo atributo é adicionado no objeto response
	 */
	@Override
	public void attributeAdded(ServletRequestAttributeEvent srae) {
		HttpServletRequest httpServletRequest = (HttpServletRequest) srae.getServletRequest();
		System.out.println("Atributo [Nome: " + srae.getName() + " / Valor: " + srae.getValue() + "] adicionado no request " + httpServletRequest);
	}

	/**
	 * Metodo chamado quando atributo é removido ou sobrescrito com o valor null
	 */
	@Override
	public void attributeRemoved(ServletRequestAttributeEvent srae) {
		HttpServletRequest httpServletRequest = (HttpServletRequest) srae.getServletRequest();
		System.out.println("Atributo [Nome: " + srae.getName() + " / Valor antigo: " + srae.getValue() + "] removido no request " + httpServletRequest);
	}

	/**
	 * Metodo chamado quando um atributo é alterado no objeto request
	 */
	@Override
	public void attributeReplaced(ServletRequestAttributeEvent srae) {
		HttpServletRequest httpServletRequest = (HttpServletRequest) srae.getServletRequest();
		System.out.println("Atributo [Nome: " + srae.getName() + " / Novo valor: " + httpServletRequest.getAttribute(srae.getName()) + " / Valor antigo: "
				+ srae.getValue() + "] alterado no request " + httpServletRequest);
	}

}
