package classicTags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.IterationTag;
import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;

public class Loop extends TagSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 759051180421012190L;

	private int begin;
	private int end;
	private int step;
	private String var;
	private int count;
	private Object originalVar;

	@Override
	public int doStartTag() throws JspException {
		if (!this.indexesValid()) {
			throw new JspException("Os indices informado nao sao validos!");
		}

		if (this.step < 1) {
			this.step = 1;
		}

		this.count = 0;
		this.originalVar = super.pageContext.getAttribute(this.var);

		super.pageContext.setAttribute(this.var, this.count);

		return Tag.EVAL_BODY_INCLUDE;
	}

	@Override
	public int doAfterBody() throws JspException {
		this.count += this.step;
		super.pageContext.setAttribute(this.var, this.count);

		if (this.count > this.end) {
			return Tag.SKIP_BODY;
		}

		return IterationTag.EVAL_BODY_AGAIN;
	}

	@Override
	public int doEndTag() throws JspException {
		super.pageContext.removeAttribute(this.var);
		super.pageContext.setAttribute(this.var, this.originalVar);

		return super.doEndTag();
	}

	private boolean indexesValid() {
		return this.begin <= this.end;
	}

	/**
	 * @return the begin
	 */
	public int getBegin() {
		return begin;
	}

	/**
	 * @param begin
	 *            the begin to set
	 */
	public void setBegin(int begin) {
		this.begin = begin;
	}

	/**
	 * @return the end
	 */
	public int getEnd() {
		return end;
	}

	/**
	 * @param end
	 *            the end to set
	 */
	public void setEnd(int end) {
		this.end = end;
	}

	/**
	 * @return the step
	 */
	public int getStep() {
		return step;
	}

	/**
	 * @param step
	 *            the step to set
	 */
	public void setStep(int step) {
		this.step = step;
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

}
