package wrappers.response;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

public class MyResponseWrapper extends HttpServletResponseWrapper {

	public MyResponseWrapper(HttpServletResponse httpServletResponse) {
		super(httpServletResponse);
	}

	@Override
	public void addHeader(String name, String value) {
		if (!name.contains(".")) {
			throw new IllegalArgumentException("O parametro de cabecalho nao segue os padroes da especificacao!");
		}
		super.addHeader(name, value);
	}

}
