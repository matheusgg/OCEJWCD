package sessionActivationListener;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionEvent;

/**
 * Um HttpSessionActivationListener � um ouvinte para atributos adicionados nos
 * objetos HttpSession. De acordo com a especificacao, quando o container
 * colocar a sessao em estado passivo, o mesmo deve notificar todos os atributos
 * dessa sessao que implementem HttpSessionActivationListener. Dessa forma, os
 * atributos podem realizar tarefas especificas de serializacao. Quando a sessao
 * � ativada, ou seja, saiu do estado passivo, os atributos dos tipos de classes
 * que implementam HttpSessionActivationListener tamb�m devem ser notificados,
 * com isso � possivel realizar tarefas de desserializacao.
 * 
 * @author Matheus
 * 
 */
/**
 * HttpSessionActivationListener nao podem ser mapeados no deployment descriptor
 * ou anotados com WebListener. E apenas os atributos adicionados na sessao que
 * esta sendo ativada ou colocada em modo passivo serao notificados.
 * 
 * @author Matheus
 * 
 */
public class AttrSessionActivationListener implements HttpSessionActivationListener {

	/**
	 * Metodo invocado quando o web container colocar a sessao em modo passivo.
	 */
	@Override
	public void sessionWillPassivate(HttpSessionEvent se) {
		HttpSession session = se.getSession();
		ServletContext context = session.getServletContext();
		context.log("A sessao entrar� em modo passivo!");
	}

	/**
	 * Metodo invocado quando a sessao for ativada.
	 */
	@Override
	public void sessionDidActivate(HttpSessionEvent se) {
		HttpSession session = se.getSession();
		ServletContext context = session.getServletContext();
		context.log("A sessao ser� ativada!");
	}

}
