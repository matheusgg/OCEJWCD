package request.servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Toda requisicao e toda resposta que chega e sai do servidor é convertida e
 * encapsulada para um objeto ServletRequest ou ServletResponse pelo container.
 * Quando uma requisicao chega na interface do container, o mesmo recupera todas
 * as informacoes dessa requisicao e cria um objeto que encapsula todas essas
 * informacoes. Além disso, o container também cria um objeto de resposta que já
 * encapsula todas as informacoes e protocolo da resposta. Apos criados esses
 * objetos eles sao passados para as servlets como parametros. No processamento
 * da requisicao, todos os componentes web envolvidos recebem os dois objetos
 * que foram criados pelo servidor e que encapsulam as informacoes da requisicao
 * e da resposta. Desta forma, durante o processamento, os componentes web
 * envolvidos podem adicionar ou alterar informacoes da resposta e quando o
 * processamento chegar ao fim, os objetos ServletRequest e ServletResponse sao
 * enviados de volta para o container que por sua vez desencapsula ambos e envia
 * a resposta para o cliente.
 * 
 * @author Matheus
 * 
 */
@WebServlet(name = "AppServlet", urlPatterns = { "/AppServlet" })
public class AppServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6406350029561086107L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/*
		 * Retorna um array com os valores do parametro especificados, já que um
		 * mesmo parametro pode possuir vario valores.
		 */
		String[] param1 = req.getParameterValues("param1");

		/*
		 * Retorna o valor do parametro especificado. Caso esse parametro possua
		 * mais do que um valor, apenas o primeiro valor do array é retornado.
		 */
		String param2 = req.getParameter("param2");

		/*
		 * Retorna um mapa contendo o nome e o valor de todos os parametros
		 * enviados na requisicao.
		 */
		Map<String, String[]> params = req.getParameterMap();

		/*
		 * Retorna a queryString, ou seja, os parametros da URL passados pelo
		 * cliente na requisicao.
		 */
		String queryString = req.getQueryString();

		PrintWriter writer = resp.getWriter();
		writer.write("doGet");
		writer.write("\nParameterValues of param1 size: " + (param1 != null ? param1.length : param1));
		writer.write("\nparam2: " + param2);
		writer.write("\nMapa de parametros: " + params);
		writer.write("\nQueryString: " + queryString + "\n");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String encoding = req.getCharacterEncoding();
		int length = req.getContentLength();
		String contentType = req.getContentType(); // Tipo de dado do corpo da
													// requisicao
		String protocol = req.getProtocol(); // Protocolo: HTTP/1.1
		String scheme = req.getScheme(); // Esquema, ou seja, o que vem antes de
											// ://. Ex.: http, https, ftp
		boolean secure = req.isSecure();

		PrintWriter writer = resp.getWriter();
		writer.println(encoding);
		writer.println(length);
		writer.println(contentType);
		writer.println(protocol);
		writer.println(scheme);
		writer.println(secure);
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/*
		 * Assim como acontece com os metodos getOutputStream e getWriter do
		 * response, assume-se que a aplicacao precisara ou de um InputStream ou
		 * de um Reader, mas nunca de ambos, desta forma, a chamada a ambos os
		 * metodos resultara em uma IllegalStateException.
		 */
		// ServletInputStream inputStream = req.getInputStream();

		/*
		 * BufferedReader nada mais é do que um reader que adiciona o metodo
		 * readLine por conveniencia para leitura de dados textuais.
		 */
		BufferedReader reader = req.getReader();

		PrintWriter writer = resp.getWriter();
		writer.write(reader.readLine());
	}

}
