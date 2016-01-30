package init;

import java.util.Set;

import javax.servlet.Servlet;
import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.annotation.HandlesTypes;
import javax.servlet.annotation.WebInitParam;

import containerInitializer.ReadOnInit;

/**
 * Com um ServletContainerInitializer, é possivel registrar e configurar
 * componentes web dinamicamente. Esta classe é escaneada pelo container na
 * implantacao da aplicacao. Deve estar contida dentro de um JAR na pasta
 * WEB-INF/lib. Dentro deste jar deve haver uma pasta META-INF/services com um
 * arquivo chamado "javax.servlet.ServletContainerInitializer" (qua nada mais é
 * do que o nome completo da interface). Este arquivo deve conter o nome
 * totalmente qualificado da classe que implementa ServletContainerInitializer e
 * que deve ser invocada pelo container. Durante a implantacao da aplicacao, o
 * container escaneia todos os arquivos jars da aplicacao verificando se os
 * mesmos possuem o arquivo "javax.servlet.ServletContainerInitializer" dentro
 * da pasta META-INF/services. Caso encontre algum jar que possua esse arquivo
 * nesta estrutura, o container realiza a leitura do arquivo em busca do nome da
 * classe que devera ser invocada para realizar alguma logica de inicializacao
 * do container. Desta forma, este um lugar ideal para registro e
 * configuracao dinamica de componentes web.
 * 
 * @author Matheus
 * 
 */
/**
 * Um ServletContainerInitializer é executando antes de qualquer
 * ServletContextListener.
 * 
 * @author Matheus
 * 
 */

/**
 * Com HandlesTypes é possivel especificar quais tipos de classes o container
 * devera escanear e inserir no set de classes que sera passado como argumento
 * para o metodo onStartup. É possivel especificar classes, interfaces ou
 * anotacoes.
 * 
 * @author Matheus
 * 
 */
/**
 * Nao é possivel mapear mais do que um ServletContainerInitializer para o mesmo
 * arquivo JAR, caso mais de uma classe seja especificada no arquivo
 * javax.servlet.ServletContainerInitializer, o container nao invocara nenhuma
 * delas.
 * 
 * @author Matheus
 * 
 */
@HandlesTypes({ ReadOnInit.class, Servlet.class })
public class AppContainerInitializer implements ServletContainerInitializer {

	/**
	 * Este metodo é invocado na inicializacao do container para realizar alguma
	 * logica de configuracao. O Container passa como parametro o contexto da
	 * aplicacao (ServletContext) e um Set de classes contendo todas as classes
	 * encontradas pelo container que estao assinadas para as classes informadas
	 * na anotacao HandlesTypes, caso o container nao ache nenhuma classe
	 * relacionada as classes informadas em HandlesTypes, ou a anotacao
	 * HandlesTypes nao esteja presente, este parametro estara null.
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void onStartup(Set<Class<?>> classes, ServletContext ctx) throws ServletException {
		System.out.println("ServetContext Path: " + ctx.getContextPath());

		for (Class<?> clazz : classes) {
			if (Servlet.class.isAssignableFrom(clazz) && clazz.isAnnotationPresent(ReadOnInit.class)) {
				this.registerServlets((Class<Servlet>) clazz, ctx);
			}
		}

		System.out.println("Classes registradas: " + classes);
	}

	private void registerServlets(Class<Servlet> clazz, ServletContext ctx) throws ServletException {
		ReadOnInit readOnInit = clazz.getAnnotation(ReadOnInit.class);
		Servlet servlet = ctx.createServlet(clazz);

		ServletRegistration.Dynamic dynamic = ctx.addServlet(clazz.getName(), servlet);
		dynamic.addMapping(readOnInit.urlPatterns());

		for (WebInitParam param : readOnInit.initParams()) {
			dynamic.setInitParameter(param.name(), param.value());
		}
	}

}
