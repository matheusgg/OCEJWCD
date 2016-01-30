package programaticConf;

import java.io.IOException;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/programaticConf/AppServlet1")
public class AppServlet1 extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5008037125562823942L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ServletRegistration servletRegistration = super.getServletContext().getServletRegistration("programaticConf.AppServlet1");
		FilterRegistration filterRegistration = super.getServletContext().getFilterRegistration("programaticConf.AppFilter");

		Set<String> mapeamentosNaoAdicionados = new HashSet<>();
		Map<String, String[]> requestMap = req.getParameterMap();

		for (Entry<String, String[]> entry : requestMap.entrySet()) {
			if (entry.getKey().contains("map")) {
				mapeamentosNaoAdicionados.addAll(servletRegistration.addMapping(entry.getValue()[0]));
				filterRegistration.addMappingForUrlPatterns(EnumSet.allOf(DispatcherType.class), true, entry.getValue()[0]);
			}
		}

		resp.getWriter().println(mapeamentosNaoAdicionados);
	}

}
