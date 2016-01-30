package requestDispatcher;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * RequestDispatcher é um mecanismo utilizado para redirecionar ou incluir um
 * segundo recurso estatico ou dinamico na resposta. É um mecanismo recomendado
 * e padronizado para se utilizar.
 * 
 * @author Matheus
 * 
 */
/**
 * Os métodos include() e forward() chamam por padrao o metodo
 * getOutputStream(). O metodo forward() commita a resposta, ja o metodo
 * include() nao commita a resposta. Se apos esses dois metodos houver uma
 * tentativa de chamada a getWriter(), uma excecao acontecera, pois
 * getOutputStream() ja foi chamado, e é possivel chamar apenas um desses dois
 * metodos por requisicao. Porém, se antes de um include() ou forward(), o
 * metodo getWriter() for chamado, os dois metodos passarao a utilizar esse
 * writer para escrever na resposta, ou seja, eles nao chamarao
 * getOutputStream().
 * 
 * @author Matheus
 * 
 */
@WebServlet(name = "AppServlet", urlPatterns = "/AppServlet")
public class AppServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1599993563408449202L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/*
		 * Existe tres formas de recuperar um RequestDispatcher. Duas delas é
		 * atraves do ServletContext. O metodo getNamedDispatcher recebe o nome
		 * do recurso. Desta forma é possivel passar o nome logico do recurso
		 * (Servlet ou JSP) para esse metodo para criacao do RD.
		 */
		RequestDispatcher rd = super.getServletContext().getNamedDispatcher("AppServlet2");

		/*
		 * O metodo forward realiza o redirecionamento do fluxo da requisicao
		 * para o recurso apontado pelo RD utilizado. Esse metodo faz com que a
		 * resposta seja commitada apenas no retorno para essa servlet, desta
		 * forma, o fluxo retorna para a primeira Servlet, mas a mesma nao pode
		 * mais alterar a resposta. É recomendado que seja chamado depois que um
		 * writer foi recuperado. Caso esse metodo for chamado depois que a
		 * resposta estiver sido commitada, uma excecao sera lancada. Quando o
		 * metodo forward é chamado o response nao pode mais ser commitado.
		 */
		rd.forward(req, resp);

		/*
		 * Outra chamada a forward causara uma IllegalStateException, pois a
		 * resposta ja esta commitada e forward faz um commit da resposta.
		 */
		// rd.forward(req, resp);

		/*
		 * Como forward chama getOutputStream() e commita a resposta, caso haja
		 * uma tentativa de criar um writer, uma excecao ocorrera
		 */
		resp.getWriter().write("Isso nao sera enviado para a resposta!");
		this.getClass();
	}

}
