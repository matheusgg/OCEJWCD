package includeAndForward;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "RDServlet2", urlPatterns = "/RDServlet2")
public class RDServlet2 extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4799488650582312716L;

	/**
	 * Durante o include, o container adiciona alguns atributos no request que
	 * indicam o caminho do recurso que esta sendo incluido. Os atributos
	 * possuem os mesmos nomes dos seus metodos correspondentes. Esses atributos
	 * refletem os novos valores da url do recurso que esta sendo incluido. O
	 * segundo recurso ainda pode acessar os valores antigos, basta apenas
	 * chamar os metodos do request. Esses atributos so sao adicionados no
	 * request quando o RequestDispatcher é criado a partir do metodo
	 * getRequestDispatcher(), caso o dispatcher tenha sido criado atraves de
	 * getNamedDispatcher(), esses atributos nao serao adicionados no request.
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter writer = resp.getWriter();
		writer.println("Incluindo a RDServlet2");
		writer.println(req.getAttribute("javax.servlet.include.msg"));

		writer.println(req.getAttribute("javax.servlet.include.request_uri"));
		writer.println(req.getAttribute("javax.servlet.include.context_path"));
		writer.println(req.getAttribute("javax.servlet.include.servlet_path"));
		writer.println(req.getAttribute("javax.servlet.include.path_info"));
		writer.println(req.getAttribute("javax.servlet.include.query_string"));
	}

	/**
	 * Quando é feito um forward e o RequestDispatcher foi criado atraves do
	 * metodo getRequestDispatcher, os atributos `javax.servlet.forward.*` sao
	 * adicionados na requisicao. Ao contrario do include(), esses atributos
	 * refletem os valores antigos da URL, ou seja, armazenam o caminho e as
	 * informacoes da Servlet que realizou o forward. Para recuperar os novos
	 * valores, ou seja, os valores refletido do forward, basta chamar os
	 * metodos correspondentes aos nomes dos atributos.
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter writer = resp.getWriter();
		writer.println("Incluindo a RDServlet2");
		writer.println(req.getAttribute("javax.servlet.forward.msg"));

		writer.println(req.getAttribute("javax.servlet.forward.request_uri"));
		writer.println(req.getAttribute("javax.servlet.forward.context_path"));
		writer.println(req.getAttribute("javax.servlet.forward.servlet_path"));
		writer.println(req.getAttribute("javax.servlet.forward.path_info"));
		writer.println(req.getAttribute("javax.servlet.forward.query_string"));
	}

}
