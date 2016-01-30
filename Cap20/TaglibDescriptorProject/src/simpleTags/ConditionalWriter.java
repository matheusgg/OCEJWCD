package simpleTags;

import java.io.IOException;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.JspTag;
import javax.servlet.jsp.tagext.SimpleTag;

public class ConditionalWriter implements SimpleTag {

	@SuppressWarnings("unused")
	private JspContext jspContext;
	private JspTag parent;
	private JspFragment fragment;
	private boolean test;

	@Override
	public void doTag() throws JspException, IOException {
		if (this.test && this.fragment != null) {
			this.fragment.invoke(null);
		}
	}

	@Override
	public void setParent(JspTag parent) {
		this.parent = parent;
	}

	@Override
	public JspTag getParent() {
		return this.parent;
	}

	@Override
	public void setJspContext(JspContext pc) {
		this.jspContext = pc;
	}

	@Override
	public void setJspBody(JspFragment jspBody) {
		this.fragment = jspBody;
	}

	/**
	 * @return the test
	 */
	public boolean isTest() {
		return test;
	}

	/**
	 * @param test
	 *            the test to set
	 */
	public void setTest(boolean test) {
		this.test = test;
	}

}
