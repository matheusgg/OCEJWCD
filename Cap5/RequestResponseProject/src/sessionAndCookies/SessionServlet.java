package sessionAndCookies;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = { "/SessionServlet" })
public class SessionServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8183973455059984410L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/*
		 * Recupera o objeto associado a sessao atual do cliente, caso a sessao
		 * ainda nao esteja criada, retorna a chamada ao metodo getSession(true)
		 */
		HttpSession session = req.getSession();

		/*
		 * Cria uma nova sessao e a retorna, caso o parametro fosse false, o
		 * retorno seria null
		 */
		// session = req.getSession(true);

		/*
		 * Retorna o JSESSIONID associado a sessao atual
		 */
		String jSessionID = req.getRequestedSessionId();

		/*
		 * Retorna true caso o JSESSIONID esteja armazenado em um cookie
		 */
		boolean requestedSessionIdFromCookie = req.isRequestedSessionIdFromCookie();

		/*
		 * Retorna true caso o JSESSIONID faça parte da URL
		 */
		boolean requestedSessionIdFromURL = req.isRequestedSessionIdFromURL();

		/*
		 * Retorna true se o JSESSIONID ainda for valido para o objeto session
		 * armazenado no container
		 */
		boolean requestedSessionIdValid = req.isRequestedSessionIdValid();

		/*
		 * Retorna os cookies armazenados pela aplicacao no cliente
		 */
		Cookie[] cookies = req.getCookies();

		PrintWriter writer = resp.getWriter();
		writer.println(session);
		writer.println(jSessionID);
		writer.println(requestedSessionIdFromCookie);
		writer.println(requestedSessionIdFromURL);
		writer.println(requestedSessionIdValid);
		writer.println(cookies);
	}

}
