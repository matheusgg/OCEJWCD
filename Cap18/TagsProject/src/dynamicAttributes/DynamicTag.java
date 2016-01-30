package dynamicAttributes;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.DynamicAttributes;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 * A classe SimpleTagSupport encapsula algumas tarefas de SimpleTag como o
 * armazenamento do JspContext e JspBody. Para uma tag possuir supor a atributos
 * dinamicos, e necessario implementar a interface DynamicAttributes. Quando um
 * atributo dinamico for encontardo pelo container, o metodo setDynamicAttribute
 * sera invocado.
 * 
 * @author Matheus
 * 
 */
public class DynamicTag extends SimpleTagSupport implements DynamicAttributes {

	private Map<String, Object> dynamicAttributes;

	@Override
	public void setJspContext(JspContext pc) {
		super.setJspContext(pc);
		this.dynamicAttributes = new HashMap<>();
	}

	@Override
	public void doTag() throws JspException, IOException {
		if (super.getJspBody() != null) {
			super.getJspBody().invoke(null);

			for (Entry<String, Object> entry : this.dynamicAttributes.entrySet()) {
				super.getJspContext().getOut().print(entry.getKey() + " - " + entry.getValue());
				super.getJspContext().getOut().print("<br />");
			}
		}
	}

	@Override
	public void setDynamicAttribute(String uri, String localName, Object value) throws JspException {
		this.dynamicAttributes.put(localName, value);
	}
}
