package async;

import java.io.IOException;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/async3", asyncSupported = true)
public class AsyncServlet3 extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8971549866955112699L;

	/**
	 * Quando o contexto assincrono atinge o time out, o container deve seguir
	 * os seguintes passos:
	 */
	/**
	 * 1) Chamar o metodo onTimeout() de todos os listener registrados;
	 */
	/**
	 * 2) Caso nenhum listener chame o metodo dispatch() ou complete(), o
	 * container procurara uma pagina de erro configurada no web.xml mapeada com
	 * o codigo 500 (SC_INTERNAL_SERVER_ERROR);
	 */
	/**
	 * 3) Caso o container nao encontre uma pagina de erro configurada com o
	 * codigo 500, ele devera invocar o metodo complete() para enviar a resposta
	 * para o cliente.
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		AsyncContext ac = req.startAsync();
		ac.setTimeout(1000);
	}

}
