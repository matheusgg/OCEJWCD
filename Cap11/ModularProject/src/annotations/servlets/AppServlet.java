package annotations.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Com a especificacao 3.0 de servlets, é possivel utilizar anotacoes para
 * configurar componentes web como servlets, filters, listeners, etc.
 * 
 * @author Matheus
 * 
 */
/**
 * Em @WebServlet, os elementos values e urlPatterns possuem a mesma funcao,
 * porem é possivel declarar apenas um deles ao mesmo tempo, caso contrario o
 * container lancara um excecao. Quando o nome da servlet ou Filtro nao é
 * especificado, o container utiliza o nome totalmente qualificado da classe, ou
 * seja, essa servlets se chamara "annotations.servlets.AppServlet"
 * 
 * @author Matheus
 * 
 */
// @WebServlet(value = "/AppServlet", urlPatterns="/AppServlet") Excecao
@WebServlet(value = "/AppServlet")
public class AppServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9104528613897447577L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.getWriter().write("<h1>" + super.getServletName() + "</h1>");
	}

}
