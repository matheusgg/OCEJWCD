package wrappers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import wrappers.request.MyRequestWrapper;
import wrappers.response.MyResponseWrapper;

/**
 * Um ServletRequestWrapper ou ServletResponseWrapper sao classes utilitarias
 * que encapsulam objetos ServletRequest e ServletResponse e sao utilizadas para
 * personalizar os comportamentos de algum desses dois objetos (request ou
 * response). Um bom exemplo seria almentar o tamanho do buffer, tarefa essa que
 * poderia ser feita com um wrapper.
 * 
 * @author Matheus
 * 
 */
@WebServlet(name = "MyServlet", urlPatterns = "/MyServlet")
public class MyServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7026736443732482691L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.getWriter().println("Utilizando um ServletRequestWrapper");

		MyRequestWrapper myRequestWrapper = new MyRequestWrapper(req);
		RequestDispatcher rd = myRequestWrapper.getRequestDispatcher("/folder/file.txt");
		rd.include(myRequestWrapper, resp);

		MyResponseWrapper myResponseWrapper = new MyResponseWrapper(resp);
		myResponseWrapper.addHeader("teste", "valor");

		/*
		 * Nao e possivel chamar getWriter(), pois o metodo include chama o
		 * metodo getOutputStream() para escrever o conteudo do arquivo externo
		 * na resposta caso nenhum writer tenha sido criado ainda. E uma vez que
		 * é permitido chamar apenas um desses dois metodos por requisicao, essa
		 * linha gerara uma excecao. Porem se um writer (getWriter()) ja tenha
		 * sido criado, o include() nao chamara o metodo getOutputStream(), ao
		 * inves disso ele utilizara o writer criado para escrever na resposta.
		 */
		// resp.getWriter().println("Utilizando um ServletRequestWrapper");
	}

}
