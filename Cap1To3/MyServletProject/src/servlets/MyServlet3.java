package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class MyServlet3 extends GenericServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2391690005409664679L;

	public MyServlet3() {
		System.out.println("Construtor");
	}

	@Override
	public void init() throws ServletException {
		super.log("init");
	}

	/**
	 * O unico metodo obrigatorio e que tem que ser implementado na classe
	 * abstrata GenericServlet é o metodo service.
	 */
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		PrintWriter writer = res.getWriter();
		writer.write("Metodo Service");
	}

}
