package paths;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "PathServlet", urlPatterns = { "/PathServlet/*" })
public class PathServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4442361895412577839L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/*
		 * Retorna o caminho da requisicao a partir da raiz do servidor sem a
		 * queryString. Ex.: /Aplicacao/Servlet/caminho...
		 */
		String requestURI = req.getRequestURI();

		/*
		 * Retorna o endereco da URL completo com schema, server, port, porem
		 * nao retorna a queryString. Ex.: http://localhost/Aplicacao/Servlet
		 */
		String requestURL = req.getRequestURL().toString();

		/*
		 * Retorna qualquer informacao extra (se existir) da URL a partir do
		 * caminho mapeada para a servlet até a queryString. Ex.: para a servlet
		 * mapeada para /PathServlet/path, o resultado retornado sera /path
		 */
		String pathInfo = req.getPathInfo();

		/*
		 * Retorna o retorno do metod getPathInfo convertido para um caminho
		 * fisico. Ex.: para /path, o retorno sera: c://Users/Downloads/path por
		 * exemplo.
		 */
		String pathTranslated = req.getPathTranslated();

		/*
		 * Retorna o caminho mapeado para a servlet, neste caso o retorno sera
		 * /PathServlet, pois essa servlet foi mapeada para qualquer endereco
		 * depois de /PathServlet. Nao inclui informacoes extras e nem a
		 * queryString.
		 */
		String servletPath = req.getServletPath();

		resp.getWriter().write(requestURI + "\n");
		resp.getWriter().write(requestURL + "\n");
		resp.getWriter().write(pathInfo + "\n");
		resp.getWriter().write(pathTranslated + "\n");
		resp.getWriter().write(servletPath + "\n");
	}

	/**
	 * A diferenca entre encodeURL e encodeRedirectURL é que encodeRedirectURL
	 * geralmente é utilizado com o método sendRedirect e possui lógica para
	 * determinar se o JSESSIONID deve ser incluido na URL. Já o método
	 * encodeURL pode adicionar também o JSESSIONID na URL porém isso só
	 * acontece quando o cliente nao possui os cookies habilitados. Além disso,
	 * encodeRedirectURL nao adiciona o JSESSIONID na URL caso um
	 * redirecionamento para um contexto de outra aplicacao (externo) seja
	 * feito.
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/*
		 * Pode codificar a URL incluindo o JSESSIONID desde que o cliente nao
		 * esteja com os cookies habilitados.
		 */
		String encodeURL = resp.encodeURL("ListenerServlet");

		/*
		 * Possui lógica para determinar se o JSESSIONID deve ou nao ser
		 * incluido na URL e é utilizado em conjunto com o metodo sendRedirect.
		 */
		String encodeRedirectURL = resp.encodeRedirectURL("ListenerServlet");

		resp.getWriter().println(encodeRedirectURL);
		resp.getWriter().println(encodeURL);
	}

}
