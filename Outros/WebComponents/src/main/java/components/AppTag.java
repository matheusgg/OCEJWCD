package components;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.DynamicAttributes;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class AppTag extends SimpleTagSupport implements DynamicAttributes {

	private String msg;

	@Override
	public void doTag() throws JspException, IOException {
		super.getJspContext().getOut().println(this.msg != null ? this.msg : "Test Tag");
	}

	@Override
	public void setDynamicAttribute(String uri, String localName, Object value) throws JspException {
		System.out.println("Dynamic attr " + localName);
	}

	/**
	 * @return the msg
	 */
	public String getMsg() {
		return msg;
	}

	/**
	 * @param msg
	 *            the msg to set
	 */
	public void setMsg(String msg) {
		this.msg = msg;
	}

}
