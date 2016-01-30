package wrappers.request;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class MyRequestWrapper extends HttpServletRequestWrapper {

	public MyRequestWrapper(HttpServletRequest httpServletRequest) {
		super(httpServletRequest);
	}

	@Override
	public void setCharacterEncoding(String enc) throws UnsupportedEncodingException {
		if (enc == null) {
			throw new IllegalArgumentException("O encoding nao pode ser nulo!");
		}
		super.setCharacterEncoding(enc);
	}

}
