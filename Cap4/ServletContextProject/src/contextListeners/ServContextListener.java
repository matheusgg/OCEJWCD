package contextListeners;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Um ServletContext tem um cliclo de vida bem definido. Depois de ser criado na
 * implantacao da aplicacao ele � inicializado com as informacoes do dd. Ap�s
 * isso, o ServletContext fica disponivel para todas as servlets at� o momento
 * da sua destruicao, que ocorre somente apos todos os componentes web terem
 * sido destruidos. Inicializacao > Tempo de Vida > Destruicao
 */
/**
 * Existem varios tipos de listeners na api Java EE. Um ServletContextListener �
 * uma classe que pode ser utilizada para monitorar alteracoes no contexto da
 * aplicacao, ou seja, no ServletContext. Quando o ServletContext sofre uma
 * alteracao pelo container, este por sua vez notifica os listeners registrados
 * da aplicacao. Para registar um ServletContextListener basta anota-lo ou
 * declara-lo no web.xml.
 * 
 * @author Matheus
 * 
 */
@WebListener
public class ServContextListener implements ServletContextListener {

	/**
	 * M�todo chamado logo apos o ServletContext ter sido criado e inicializado
	 * pelo container.
	 */
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ServletContext servletContext = sce.getServletContext();
		System.out.println(servletContext.getServletContextName() + ": ServletContext criado e inicializado!");
	}

	/**
	 * M�todo chamado anter do ServletContext se tornar disponivel para o
	 * GarbageCollector. A ServletContext s� � destruida quanto todas as
	 * servlets tiverem sido destruidas.
	 */
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		ServletContext servletContext = sce.getServletContext();
		System.out.println(servletContext.getServletContextName() + ": ServletContext prestes a ser destruido!");
	}

}
