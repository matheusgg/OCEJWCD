package annotations.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/fileDownload")
public class ServletFileDownload extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8861299065515718269L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("/img/img.jpg");
		rd.include(req, resp);
		resp.setContentType("image/jpg");
	}

}
