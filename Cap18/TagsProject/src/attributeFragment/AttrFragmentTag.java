package attributeFragment;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 * FragmentsAttributes sao fragmentos (conteudo da tag) declarados atraves da
 * action jsp:attribute. Deste modo, o metodo setXxx (onde Xxx e o nome
 * informado em jsp:attribute) sera invocado e recebera um JspFragment que
 * representa aquele fragmento de pagina informado e ainda nao avaliado, desta
 * forma e possivel invocar e avaliar varias vezes o fragmento recebido.
 * 
 * @author Matheus
 * 
 */
public class AttrFragmentTag extends SimpleTagSupport {

	private JspFragment attrFragment;

	@Override
	public void doTag() throws JspException, IOException {
		if (this.attrFragment != null) {
			this.attrFragment.invoke(null);
		}

		if (super.getJspBody() != null) {
			super.getJspBody().invoke(null);
		}
	}

	public void setAttrFragment(JspFragment attrFragment) {
		this.attrFragment = attrFragment;
	}

}
