package config;

import java.io.IOException;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.SessionTrackingMode;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Com a especificacao de servlets 3.0, além da configuracao por anotacoes e
 * web-fragments, é possivel também registrar e configurar componentes web
 * (servlets, filters e listener) programaticamente atraves dos novos metodos
 * adicionados na interface ServletContext.
 * 
 * @author Matheus
 * 
 */
@WebServlet(value = "/ServletConfig", initParams = @WebInitParam(name = "param1", value = "teste"))
public class ServletConfig extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -795610272452682885L;

	/**
	 * A versao 3.0 da API de servlets adicionou alguns metodo utilitarios na
	 * interface ServletContext para recuperar informacoes da aplicacao e do
	 * container.
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/*
		 * O metodo getDefaultSessionTrackingModes() de ServletContext retorna
		 * um Set de SessionTrackingMode com os modos de rastreamento de sessao
		 * padroes do container.
		 */
		Set<SessionTrackingMode> modosSessaoPadrao = super.getServletContext().getDefaultSessionTrackingModes();
		resp.getWriter().println("Default Session Tracking Modes: " + modosSessaoPadrao);

		/*
		 * getEffectiveSessionTrackingModes() de ServletContext retorna um Set
		 * de SessionTrackingMode contendo os modos de rastreamento de sessao
		 * utilizados atualmente pelo container.
		 */
		Set<SessionTrackingMode> modosSessaoEmUtilizacao = super.getServletContext().getEffectiveSessionTrackingModes();
		resp.getWriter().println("Effective Session Tracking Modes: " + modosSessaoEmUtilizacao);

		/*
		 * getEffectiveMajorVersion() retorna a versao da API de servlets
		 * suportada pela aplicacao e que o ServletContext esta baseado.
		 */
		int effectiveMajorVersion = super.getServletContext().getEffectiveMajorVersion();
		resp.getWriter().println("Effective Major Version: " + effectiveMajorVersion);

		/*
		 * getEffectiveMinorVersion() retorna a versao minima da API de servlets
		 * suportada pela aplicacao.
		 */
		int effectiveMinorVersion = super.getServletContext().getEffectiveMinorVersion();
		resp.getWriter().println("Effective Minor Version: " + effectiveMinorVersion);

		/*
		 * Retorna a versao da API de servlets suportada pelo container.
		 */
		resp.getWriter().println("Major Version: " + super.getServletContext().getMajorVersion());

		/*
		 * Retorna a versao minima da API de servlets suportada pelo container.
		 */
		resp.getWriter().println("Minor Version: " + super.getServletContext().getMinorVersion());

		/*
		 * Informacoes do container como nome e versao.
		 */
		resp.getWriter().println("Server Info: " + super.getServletContext().getServerInfo());
	}

}
