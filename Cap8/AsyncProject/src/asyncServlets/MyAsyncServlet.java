package asyncServlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import async.MyAsyncTask;

/**
 * Na especificacao de Servlets 3.0 foi introduzida a API assincrona, utilizada
 * para processar varias requisicoes (tarefas) paralelamente. Para habilitar o
 * suporte a requisicoes assincronas em servlets ou filtros basta informar o
 * atributo asyncSupported da anotacao WebServlet ou WebFilter. Ou informar a
 * tag async-supported no web.xml.
 * 
 * @author Matheus
 * 
 */
/**
 * UM DETALHE IMPORTANTE É QUE WEB COMPONENTES SINCRONOS NAO PODEM FAZER
 * DISPATCHERS PARA WEB COMPONENTES ASSINCRONOS. Porem o contrario é permitido,
 * ou seja, componentes assincronos podem realizar dispatcher para web
 * componenentes sincronos.
 * 
 * @author Matheus
 * 
 */
/**
 * O fluxo de uma requisicao assincrona é um pouco diferente do fluxo de uma
 * requisicao sincrona. O cliente faz a requisicao > O metodo service é chamado
 * e pode delegar para outros metodos (doGet por exemplo) > Quando o metodo
 * service é finalizado, a resposta nao é commitada e enviada imediatamente para
 * o cliente, pois o servidor que espera a tarefa assincrona seja executada e
 * invoque o metodo complete(). > Somente depois de complete() foi chamado e que
 * o metod run da tarefa foi finalizado, a resposta é commitada e enviada para o
 * servidor.
 * 
 * @author Matheus
 * 
 */
// Habilitando o suporte a requisicoes assincronas
@WebServlet(asyncSupported = true, value = "/MyAsyncServlet")
public class MyAsyncServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9022492546480072330L;

	/**
	 * Caso o response ja esteja fechado ou o metodo startAsync() ja tenha sido
	 * chamado, uma nova invocacao resultara em uma IllegalStateException.
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter writer = resp.getWriter();

		writer.println("Antes de iniciar a tarefa assincrona");

		/*
		 * Para iniciar uma requisicao assincrona, basta chamar o metodo
		 * startAsync de ServletRequest. O metodo startAsync é sobrecarregado
		 * para receber um ServletRequest e um ServletResponse, desta forma é
		 * possivel passar wrappers para ele. Caso o metodo startAsync seja
		 * chamado, os objetos ServletRequest e Response originais serao
		 * utilizados.
		 */
		AsyncContext asyncContext = req.startAsync();

		MyAsyncTask asyncTask = new MyAsyncTask(asyncContext, writer);

		/*
		 * O tempo padrao de time out depende do container, geralmente está
		 * entre 5 e 10 segundos. Para desabilitar o time out basta informar um
		 * valor negativo ou 0. Esse metodo pode ser chamado antes ou depois do
		 * metodo start().
		 */
		asyncContext.setTimeout(-1);

		/*
		 * A Interface AsyncContext possui metodos para configurar a tarefa
		 * assincrona e inicializar a mesma. O metodo estart recebe um runnable
		 * que sera responsavel por realizar o processamento da tarefa
		 * assincrona. Quando esse metodo é chamado, o processamento é realizado
		 * por outra Thread do pool de Threads do servidor.
		 */
		asyncContext.start(asyncTask);

		/*
		 * Depois do start() da tarefa assincrona, o fluxo continua normalmente,
		 * e quando o metodo service() é encerrado, a resposta nao é commitada
		 * enquanto o metodo complete() de AsyncContext não for chamado. Desta
		 * forma, o container processa a tarefa assincrona um background em
		 * outra Thread.
		 */
		writer.println("Depois de iniciar a tarefa assincrona");

		/*
		 * Retorna o AsyncContext inicializado para esse request. Caso o metodo
		 * startAsync() ainda nao tenha sido chamado, uma IllegalStateException
		 * ocorrera.
		 */
		req.getAsyncContext();
	}

}
