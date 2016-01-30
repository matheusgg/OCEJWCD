package asyncTimeout;

import java.io.IOException;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import asyncTimeout.listener.CustomAsyncListener;

@WebServlet(value = "/CustomAsyncServlet", asyncSupported = true)
public class CustomAsyncServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7209965634692313732L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.getWriter().write("Antes de iniciar uma async task");

		final AsyncContext asyncContext = req.startAsync();
		CustomAsyncListener customAsyncListener = asyncContext.createListener(CustomAsyncListener.class);
		asyncContext.addListener(customAsyncListener);

		asyncContext.start(new Thread() {

			@Override
			public void run() {
				try {
					Thread.sleep(5000);
				} catch (Exception e) {
					e.printStackTrace();
				}

				/*
				 * Neste ponto, o tempo de timeout ja foi atingido, com isso o
				 * container ja fez a chamada ao metodo complete() para commitar
				 * a resposta e enviar os dados para o cliente. Desta forma, a
				 * chamada ao metodo complete novamente causara uma excecao.
				 */
				asyncContext.complete(); // Excecao
			}
		});
		asyncContext.setTimeout(3000);
	}
}
