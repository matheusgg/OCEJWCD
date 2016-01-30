package filterWrapper;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

public class CustomResposeWrapper extends HttpServletResponseWrapper {

	private ByteArrayOutputStream outputStream;
	private PrintWriter pw;

	public CustomResposeWrapper(HttpServletResponse httpServletResponse) {
		super(httpServletResponse);
	}

	@Override
	public ServletOutputStream getOutputStream() throws IOException {
		if (this.pw != null) {
			throw new IllegalStateException("getWriter já foi chamado!");
		}
		return super.getOutputStream();
	}

	@Override
	public PrintWriter getWriter() throws IOException {
		if (this.pw == null) {
			this.outputStream = new ByteArrayOutputStream();
			this.pw = new PrintWriter(this.outputStream, true);
		}
		return this.pw;
	}

	public void writeDataToClient() {
		try {
			this.outputStream.writeTo(super.getOutputStream());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
