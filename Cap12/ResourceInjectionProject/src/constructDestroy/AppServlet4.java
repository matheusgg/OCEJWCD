package constructDestroy;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * M�todo anotados com PostConstruct e PreDestroy devem ser void e nao devem
 * possuir parametros.
 * 
 * @author Matheus
 * 
 */
@WebServlet("/AppServlet4")
public class AppServlet4 extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -831336533673565535L;

	// Jboss
	@Resource(name = "java:jboss/datasources/MySQL")
	// @Resource(name = "java:comp/env/app_db") // tomcat
	private DataSource dataSource;

	/**
	 * � possivel utilizar a annotation PostConstruct para especificar um metodo
	 * que realizara tarefas de inicializacao. Este metodo � executado depois
	 * que a classe foi instanciada e os recursos foram injetados, por�m antes
	 * do metodo init da servlet.
	 */
	@PostConstruct
	public void initialisation() {
		System.out.println("AppServlet4.initialisation()");
	}

	/**
	 * O m�todo init � executado depois do metodo anotado com PostConstruct
	 */
	@Override
	public void init() throws ServletException {
		System.out.println("AppServlet4.init()");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.getWriter().println("<h1>DataSource: " + this.dataSource + "</h1>");
	}

	/**
	 * O m�todo anotado com PreDestroy � executado ap�s o m�todo destroy da
	 * servlet e antes da instancia ser descartada pelo GC.
	 */
	@PreDestroy
	public void clean() {
		System.out.println("AppServlet4.clean()");
	}

	/**
	 * O m�todo destroy � executado antes do metodo anotado com PreDestroy.
	 */
	@Override
	public void destroy() {
		System.out.println("AppServlet4.destroy()");
	}

}
