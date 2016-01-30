package scriptVariable;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.IterationTag;
import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;

public class ScriptVariableTag extends TagSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -417786189062215521L;

	private String var;
	private int count;
	private int end;

	@Override
	public int doStartTag() throws JspException {
		this.updateVar();
		return Tag.EVAL_BODY_INCLUDE;
	}

	@Override
	public int doAfterBody() throws JspException {
		if (this.count < this.end) {
			this.count++;
			this.updateVar();
			return IterationTag.EVAL_BODY_AGAIN;

		}
		return super.doAfterBody();
	}

	private void updateVar() {
		super.pageContext.setAttribute(this.var, this.count);
	}

	@Override
	public int doEndTag() throws JspException {
		this.count = 0;
		return super.doEndTag();
	}

	/**
	 * @return the var
	 */
	public String getVar() {
		return var;
	}

	/**
	 * @param var
	 *            the var to set
	 */
	public void setVar(String var) {
		this.var = var;
	}

	/**
	 * @return the end
	 */
	public int getEnd() {
		return end;
	}

	/**
	 * @param end the end to set
	 */
	public void setEnd(int end) {
		this.end = end;
	}

}
