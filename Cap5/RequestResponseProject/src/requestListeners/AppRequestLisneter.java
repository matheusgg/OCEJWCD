package requestListeners;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;

/**
 * É importante deixar bem claro que nao existem listeners para objetos
 * Response, já que os mesmos estao totalmente sobre controle da thread onde
 * estao sendo manipulados, ou seja, objetos response nao sofrem problemas de
 * concorrencia e podem ser alterados a qualquer momento na requisicao, desta
 * forma, nao há necessidade de existir listeners para responses, já que os
 * listener para request existem, e um request sempre esta associado a um
 * response, entao nao faz sentido monitorar um response.
 * 
 * @author Matheus
 * 
 */
/**
 * Este listener sera notificado a cada fase do ciclo de vida de um objeto
 * request. 1) O container preenche o objeto request > 2) O objeto request fica
 * disponivel para os componentes web durante o processamento > 3) O container
 * limpa o objeto response
 * 
 * @author Matheus
 * 
 */
@WebListener
public class AppRequestLisneter implements ServletRequestListener {

	/**
	 * Metodo chamado quando o container cria e preenche um objeto request com
	 * as informacoes da requisicao.
	 */
	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		HttpServletRequest httpServletRequest = (HttpServletRequest) sre.getServletRequest();
		System.out.println("ServletRequest preenchido: " + httpServletRequest);
	}

	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		HttpServletRequest httpServletRequest = (HttpServletRequest) sre.getServletRequest();
		System.out.println("ServletRequest prestes a ser limpo (destruido): " + httpServletRequest);
	}

}
