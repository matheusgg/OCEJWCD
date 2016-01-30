package request.headers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Header sao especificos do protocolo HTTP e nada mais sao do que metadados
 * sobre a requisicao, ou seja, informacoes sobre a requisicao. Um parametro de
 * header pode ter multiplos valores. Os headers sao case-insensitive.
 * 
 * @author Matheus
 * 
 */
@WebServlet(name = "AppServlet3", urlPatterns = { "/AppServlet3/*" })
public class AppServlet3 extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4365160230180708841L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/*
		 * Recuperando o nome de todos os headers da requisicao.
		 */
		Enumeration<String> headerNames = req.getHeaderNames();
		StringBuilder hNames = new StringBuilder("Headers:\n");
		while (headerNames.hasMoreElements()) {
			hNames.append(headerNames.nextElement() + "\n");
		}

		/*
		 * Recuperando os valores do header hTeste. Os valores dos parametros de
		 * cabecalhos vem em uma lista separados por virgula (,). Ou seja, caso
		 * haja mais de um valor, eles virao na forma val1,val2, etc.
		 */
		Enumeration<String> headerTeste = req.getHeaders("hTeste");
		StringBuilder hTeste = new StringBuilder("hTeste:\n");
		while (headerTeste.hasMoreElements()) {
			hTeste.append(headerTeste.nextElement() + "\n");
		}

		/*
		 * Recuperando o valor do parametro header Accept. Como os header sao
		 * case-insensitive, nao ha problemas em passar o nome do header em
		 * caixa baixa.
		 */
		String accept = req.getHeader("accept");

		/*
		 * metodo conveniente que recupera o header testeInt e realiza o cast
		 * para um numero inteiro.
		 */
		int headerInt = req.getIntHeader("testeInt");

		/*
		 * Os métodos setHeader e addheader aceitam duas Strings como
		 * parametros.
		 */
		// resp.addHeader("br.com.servlets.header", "header Test");
		// resp.setHeader("br.com.servlets.header", "header Test");

		PrintWriter writer = resp.getWriter();
		writer.write(hNames.toString());
		writer.write("\n==================================\n");
		writer.write(hTeste.toString());
		writer.write("\n==================================\n");
		writer.write(accept);
		writer.write("\n==================================\n");
		writer.write(headerInt);

	}

}
