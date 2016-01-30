package response.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "RespServlet", urlPatterns = { "/RespServlet" })
public class RespServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8790095002317109957L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/*
		 * Um detalhe importante, nao existe um metodo para recuperar o content
		 * length da resposta, ja que essa informacao mauitas vezes nao nao
		 * possivel de ser recuperada.
		 */
		// resp.setContentLength(1000);

		/*
		 * Se este metodo for chamado, nenhuma alteracao de character encoding e
		 * content type ocorrera, pois ele causo o commit da resposta para o
		 * cliente, desta forma, nao é possivel alterar as informacoes de MIME
		 * type e encoding.
		 */
		// resp.flushBuffer();

		// Setando o encoding
		resp.setCharacterEncoding("UTF-8");

		/*
		 * É possivel definir o encoding indiretamente atraves do metodo
		 * setContentType, que serve para definir o MIME type da resposta
		 */
		resp.setContentType("text/plain;charset=UTF-8");

		/*
		 * É importante observar que a definicao do character encoding e content
		 * type so se tornarao validas apos a chamada ao metodo getWriter(),
		 * pois esse metodo utiliza as informacoes de MIME type e encoding para
		 * montar um objeto que escrevera a resposta no cliente. Entao definir o
		 * character encoding e o content type apos a chamada desse metodo nao
		 * fara efeito algum.
		 */
		resp.getWriter().write("Método doGet");

		/*
		 * Como no response, é possivel chamar apenas um metodo para obter um
		 * mod de escrever no cliente, getWriter ou getOutputStream, mas nunca
		 * ambos. Como o metodo getOutputStream retorna um OutputStream que é
		 * utilizado para escrever dados binarios, e uma vez que dados binarios
		 * nao possuem encoding, é possivel chamar o metodo setCharacterEncoding
		 * apos a chamada de getOutputStream, mas antes da resposta ser
		 * commitada! Desta forma o encoding ira para o cliente como um campo de
		 * cabecalho.
		 */
		// resp.getOutputStream();
	}

}
