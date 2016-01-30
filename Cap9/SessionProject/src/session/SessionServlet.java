package session;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sessionActivationListener.AttrSessionActivationListener;
import sessionBindingListener.SessionBindingAttr;

/**
 * O mecanismo de sessao é uma forma de manter informacoes de um cliente atraves
 * varias requisicoes diferentes. Cada cliente esta associado a uma sessao, e
 * cada requisicao feita por este cliente percente a este mesma sessao. 
 * 
 * @author Matheus
 */
/**
 * Quando o cliente realiza uma requisicao pela primeira vez para o servidor, o
 * Web Container envia um parametro de volta para o cliente chamado jsessionid,
 * isto é, o web container cria uma sessao no servidor e a associa a um
 * identificador (ID de sessao, ou jsessionid), esse identificador é enviado de
 * volta para o cliente. Entao, durante as requisicoes subsequentes, o cliente
 * sempre envia essa informacao de ID de sessao (jsessionid) de volta para o
 * servidor, este por sua vez, recupera o objeto session associado ao ID
 * recebido.
 * 
 * @author Matheus
 * 
 */
/**
 * O jsessionid pode ser armazenado em cookies ou incluido na URL. Caso os
 * cookies estejam habilitados, o jsessionid é armazenado em um e enviado para o
 * servidor toda vez que o cliente realiza uma requisicao. Se os cookies
 * estiverem desabilitados, o Web Container, reescreve todos os links da
 * aplicacao adicionando o jsessionid na URL, desta forma, quando o cliente
 * realizar uma requisicao, o jsessionid sera incluido como um parametro na URL
 * para ser enviado para o servidor. O problema dessas solucoes é que o
 * mecanismo de cookies nao deve ser utilizado como ferramenta principal, uma
 * vez que podem ser desabilitados pelo cliente. A solucao da inclusao do
 * jsessionid na URL tambem possui falhas, uma vez que o cliente pode remover o
 * jsessionid da URL quando for fazer uma requisicao, desta forma, o cliente
 * sera associado a uma nova sessao, pois o servidor pensara que é a primeira
 * vez que ele acessa a aplicacao, criando assim uma nova sessao e um novo
 * jsessionid, com isso, todas as informacoes associadas a sessao anterior sao
 * descartadas e perdidas.
 * 
 * @author Matheus
 * 
 */
/**
 * O Web Container utiliza um mecanismo de passivation quando trabalha com
 * sessoes. Ou seja, quando um novo cliente acessa a aplicacao, o web container
 * cria um objeto session e o armazena na memoria, porem se varios clientes
 * acessam a aplicacao, varios objetos serao criados, aumentando assim o consumo
 * de memoria do servidor. Não ha como saber se o cliente finalizou a sua sessao
 * ou nao, o que se pode fazer é definir um timeout, desta forma, o servidor
 * verifica os objetos sessions que estam inativos a muito tempo, porem ainda
 * estao dentro do timeout, e realiza a serializacao desses objetos salvando em
 * um diretorio temporario no disco, liberando assim espaco da memoria RAM. Esse
 * processo é conhecido como passivation. Quando uma requisicao é feita a um
 * objeto session com estado passivo (serializado), o mesmo deve ser ativado,
 * com isso, o web container desserializa esse objeto e o ativa novamente
 * colocando-o na memoria, uma vez que nao é possivel trabalhar com objetos
 * serializados inativos.
 * 
 * @author Matheus
 * 
 */
@WebServlet("/SessionServlet")
public class SessionServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5201378398482314742L;

	/**
	 * Caso o cliente esteja com cookies habilitados e a resposta tenha sido
	 * commitada e enviada antes da chamada aos metodos getSession() e
	 * getSession(true), uma excecao sera lancada.
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.getWriter().println("Informacoes da Sessao");

		/*
		 * Se este metodo for chamado antes da sessao ser criada, uma
		 * IllegalStateSxception será lancada. Nao e possivel cria uma sessao
		 * apos a resposta ter sido commitada.
		 */
		// resp.flushBuffer();

		/*
		 * O metodo getSession() retorna a sessao associada ao cliente, caso
		 * nenhuma sessao exista ainda, delega a chamda ao metodo
		 * getSession(true), retornando assim uma nova sessao.
		 */
		HttpSession session = req.getSession();
		resp.getWriter().println("getSession() - jsessionid: " + session.getId());

		/*
		 * req.getSession(true) retorna a sessao corrente do usuario, caso nao
		 * haja nenhuma sessao criada ainda e o parametro for true, uma nova
		 * sessao é criada e retornada. Ou Seja, uma nova sessao só é criada
		 * quando nao há nenhuma sessao corrente.
		 */
		// Isso retornara a sessao ja criada anteriormente
		session = req.getSession(true);
		resp.getWriter().println("getSession(true) - jsessionid: " + session.getId());

		// Retorna true na primeira vez que o cliente acessa a aplicacao e a
		// sessao é criada
		resp.getWriter().println("isNew() - " + session.isNew());

		resp.getWriter().println("getCriationTime() - " + new Date(session.getCreationTime()));
		resp.getWriter().println("getLastAccessedTime() - Ultimo acesso: " + new Date(session.getLastAccessedTime()));
		resp.getWriter().println("getMaxInactiveInterval() - " + session.getMaxInactiveInterval());

		resp.getWriter().println("jsessionid na URL? " + req.isRequestedSessionIdFromURL());
		resp.getWriter().println("jsessionid em cookies? " + req.isRequestedSessionIdFromCookie());

		/*
		 * Para desabilitar o timeout basta informar o valor 0 ou negativo.
		 */
		// session.setMaxInactiveInterval(0);
		// session.setMaxInactiveInterval(-1);

		/*
		 * O metodo invalidade() invalida a sessao forcando o container a
		 * destruir o objeto HttpSession corrente e cria outra sessao. Depois
		 * que HttpSession é invalidado, todos as chamados aos seus metodos
		 * lancarao uma IllegalStateException.
		 */
		// session.invalidate();

		resp.getWriter().println("Adicionando atributo...");
		/*
		 * Adicionando um atributo do tipo HttpSessionActivationListener, com
		 * isso, quando o servidor colocar essa sessao em modo passivo ou
		 * ativa-la, esse atributo sera notificado.
		 */
		session.setAttribute("myAttr", new AttrSessionActivationListener());

		resp.getWriter().println("Alterando atributo...");
		session.setAttribute("myAttr", "teste");
		// session.setAttribute("myAttr", null); // Remocao

		resp.getWriter().println("Removendo atributo...");
		session.removeAttribute("myAttr");

		/*
		 * HttpSessionBindingListener
		 */
		SessionBindingAttr attr = new SessionBindingAttr();

		resp.getWriter().println("Adicionando um HttpSessionBindingAttr...");
		session.setAttribute("sessionbindingattr", attr);

		resp.getWriter().println("Alterando um HttpSessionBindingAttr...");
		// Atributo é removido
		// session.setAttribute("sessionbindingattr", null);

		/*
		 * Caso um atributo do tipo HttpSessionBindingListener seja removido ou
		 * substituido, o metodo valueUnbound() do listener é chamado e esse
		 * atributo nao recebera mais notificacoes dessa sessao até ser
		 * adicionado novamente.
		 */
		session.setAttribute("sessionbindingattr", "teste");

		resp.getWriter().println("Removendo um HttpSessionBindingAttr...");
		session.removeAttribute("sessionbindingattr");
	}

}
