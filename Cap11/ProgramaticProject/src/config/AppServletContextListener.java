package config;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.annotation.WebListener;

import listeners.AppRequestListener;
import servlets.AppServlet;
import filters.AppFilter;

/**
 * O registro programatico de Servlets, Filters e Listeners so
 * pode ser feito antes do ServletContext ter sido totalmente inicializado,
 * qualquer tentativa de adicao de Servlets, Filters ou Listeners
 * depois de o ServletContext ter sido inicializado resultara em uma
 * IllegalStateException. Desta forma, existem duas maneiras de registrar esses 
 * componentes web dinamicamente, atraves de um
 * ServletContextListener ou de um ServletContainerInitializer.
 * 
 * @author Matheus
 * 
 */
/**
 * Caso ocorra uma tentativa de registro ou configuracao de servlets, filters ou
 * liseners dentro de um ServletContextListener que nao foi registrado no
 * web.xml ou anotado, uma excecao também sera lancada.
 * 
 * @author Matheus
 * 
 */
/**
 * Apesar de nao ser possivel registrar filters e servlets programaticamente em
 * tempo de execucao, ainda sim, é possível configurar esses componentes dentro
 * de outros componentes em tempo de execucao.
 * 
 * @author Matheus
 * 
 */
@WebListener
public class AppServletContextListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ServletContext context = sce.getServletContext();

		try {
			this.registerServlet(context);

			this.registerFilter(context);

			this.registerListener(context);

			/*
			 * O metodo getServletRegistration() retorna um objeto do tipo
			 * ServletRegistration que serve para configurar a servlet
			 * registrada informada.
			 */
			ServletRegistration servletRegistration = context.getServletRegistration("config.ServletConfig");

			Map<String, String> initParams = new HashMap<>();
			initParams.put("param1", "teste 2");
			initParams.put("param2", "teste 3");

			/*
			 * Adicionando parametros de inicializacao para a Servlet
			 * representada pela ServletRegistration informada. Caso algum
			 * parametro de inicializacao nao possa ser adicionado (ja exista ou
			 * ja foi adicionado), o metodo setInitParameters() retorna um set
			 * de Strings contendo os parametros que nao puderam ser
			 * adicionados. Além disso todos os outros parametros do mapa também
			 * nao sao adicionados, porém nao sao adicionados no set retornado
			 * pelo metodo.
			 */
			Set<String> failedParams = servletRegistration.setInitParameters(initParams);
			System.out.println(failedParams);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void registerListener(ServletContext context) throws ServletException {
		/*
		 * Criando um listener atraves do metodo createListener(Class)
		 * adicionando assim, suporte a injecao de dependencias dentro desse
		 * listener.
		 */
		AppRequestListener appRequestListener = context.createListener(AppRequestListener.class);

		/*
		 * A adicao dinamica de listener nao retorna um Registration pois
		 * listener nao possuem configuracoes como filters ou servlets.
		 */
		context.addListener(appRequestListener);

		/*
		 * Isso registrara esse listener 2 vezes, ou seja, esse sempre sera
		 * chamado 2 vezes.
		 */
		// context.addListener(appRequestListener);

		/*
		 * Registrando outro ServletContextListener, desta vez uma excecao sera
		 * lancada, pois nao é possivel registrar mais nenhum outro
		 * ServletContextListener depois que o primeiro ServletContextListener
		 * foi chamado.
		 */
		// context.addListener(new AppContextListener()); // Lancara uma excecao
	}

	/**
	 * Adicao de um filtro dinamicamente.
	 * 
	 * @param context
	 * @throws ServletException
	 */
	private void registerFilter(ServletContext context) throws ServletException {
		/*
		 * Como o metodo createFilter nao foi utilizado, o suporte para injecao
		 * de dependencias dentro de AppFilter nao foi habilitado.
		 */
		FilterRegistration.Dynamic filterDynamic = context.addFilter("AppFilter", AppFilter.class);

		/*
		 * Adicionando mapeamento dinamico ao filtro. O metodo
		 * addMappingForServletNames mapeia este filtro para as servlets
		 * informados e para as requisicoes especificadas. O parametro booleano
		 * indica se este filtro deve ser adicionado antes ou depois dos outros
		 * filtros registrados, ou seja, indica se este filtro deve ser o
		 * primeiro ou o ultimo na rede (chain).
		 */
		filterDynamic.addMappingForServletNames(EnumSet.allOf(DispatcherType.class), true, "/AppServlet");
		filterDynamic.setAsyncSupported(true);

		/*
		 * A segunda adicao desse listener nao tera efeito algum, assim como
		 * servlets nao é possivel registrar o mesmo listener duas vezes, caso
		 * isso ocorra, somente o primeiro registro é considerado.
		 */
		// FilterRegistration.Dynamic filterDynamic2 =
		// context.addFilter("AppFilter", AppFilter.class);
	}

	/**
	 * Registro dinamico de uma Servlet.
	 * 
	 * @param context
	 * @throws ServletException
	 */
	private void registerServlet(ServletContext context) throws ServletException {
		/*
		 * O metodo createServlet recebe um class e habilita o suporta para
		 * injecao de dependencias na classe informada retornando uma instancia
		 * da servlet passada como argumento.
		 */
		AppServlet appServlet = context.createServlet(AppServlet.class);

		/*
		 * O metodo addServlet() é sobrecarregado para receber um class, uma
		 * string ou um objeto que estenda Servlet, e serve para registrar uma
		 * servlet dinamicamente no contexto da aplicacao. Este metodo retorna
		 * um objeto do tipo ServletRegistration.Dynamic que é utilizado para
		 * configurar essa nova servlet que acabou de ser registrada.
		 */
		ServletRegistration.Dynamic servletDynamic = context.addServlet("AppServlet", appServlet);

		/*
		 * Adicionando o mapeamento da servlet dinamicamente. O metodo
		 * addMapping pode retornar um Set de String caso alguma URL ja esteja
		 * mapeada para outra servlet, neste caso, o mapa contera todas as URl
		 * que nao puderam ser adicionada ao mapeamento.
		 */
		servletDynamic.addMapping("/AppServlet");
		servletDynamic.setLoadOnStartup(0);
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {

	}

}
