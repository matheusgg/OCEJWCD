package includeAndForward;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "RDServlet3", urlPatterns = "/RDServlet3")
public class RDServlet3 extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4799488650582312716L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter writer = resp.getWriter();
		writer.println("Incluindo o arquivo externo");

		/*
		 * Forward faz o redirecionamento para o recurso associado ao RD. Porém
		 * antes disso, o buffer é resetado, ito é, limpado, desta forma, tudo
		 * que estava no buffer e que nao foi commitado para a resposta sera
		 * perdido.
		 */
		RequestDispatcher rd = req.getRequestDispatcher("/folder/file.txt");
		rd.forward(req, resp);

		/*
		 * Como forward() faz o commit do response, nao é mais possivel escrever
		 * na resposta.
		 */
		writer.println("Arquivo externo incluido!");
	}

}
