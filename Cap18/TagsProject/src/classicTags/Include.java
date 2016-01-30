package classicTags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

/**
 * TagSupport toma conta da implementacao padrao incluindo metodos getter e
 * setter para pageContext e parent, alem de outros metodo convenientes.
 * TagSupport implementa InterationTag, que possui metodo utilitario para
 * avaliacao do corpo da tag mais de uma vez.
 * 
 * @author Matheus
 * 
 */
public class Include extends TagSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8277547017339794876L;

	private String url;

	@Override
	public int doEndTag() throws JspException {
		try {
			this.pageContext.include(this.url);
		} catch (Exception e) {
			throw new JspException(e);
		}
		return super.doEndTag();
	}

	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url
	 *            the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}

}
