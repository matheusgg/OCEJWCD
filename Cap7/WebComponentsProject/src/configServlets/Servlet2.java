package configServlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Caso o mapeamento da servlet esteja no web.xml, e esse mapeamento esteja com
 * o mesmo nome da instancia da servlet (ou o nome padrao), é possivel utilizar
 * as duas configuracoes em conjunto. Nesse caso, a servlet foi definida no
 * web.xml com um parametro de inicializacao, ja seu mapeamento foi definido na
 * anotacao. Desta forma, apenas uma instancia dessa servlet foi criada.
 * 
 * @author Matheus
 * 
 */
/**
 * Os parametros de inicializacao tando declarados no web.xml quanto na anotacao
 * da Servlet sao adicionados ao ServletConfig.
 * 
 * @author Matheus
 * 
 */
@WebServlet(value = "/map2", name = "Servlet2", initParams = @WebInitParam(name = "nome", value = "valor"))
public class Servlet2 extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8422863840673942361L;

	@Override
	public void init() throws ServletException {
		System.out.println("Init de " + super.getServletName());
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.getWriter().write("configServlets.Servlet2\n");
		resp.getWriter().write("Parametro definido no web.xml: " + super.getInitParameter("servlet2Param"));
	}

}
