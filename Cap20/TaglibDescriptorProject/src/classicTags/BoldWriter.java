package classicTags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;

public class BoldWriter extends TagSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6768122325413739569L;

	@Override
	public int doStartTag() throws JspException {
		try {
			super.pageContext.getOut().println("<b>");
		} catch (Exception e) {
			throw new JspException(e);
		}

		return Tag.EVAL_BODY_INCLUDE;
	}

	@Override
	public int doEndTag() throws JspException {
		try {
			super.pageContext.getOut().println("</b>");
		} catch (Exception e) {
			throw new JspException(e);
		}

		return Tag.EVAL_PAGE;
	}

}
