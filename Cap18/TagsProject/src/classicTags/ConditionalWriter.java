package classicTags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.Tag;

/**
 * Todo tag handler deve implementar Tag ou uma subclasse de Tag. A interface
 * Tag possui metodos padronizadoa para criacao de tags customizadas que serao
 * invocados pelo container.
 * 
 * @author Matheus
 * 
 */
public class ConditionalWriter implements Tag {

	@SuppressWarnings("unused")
	private PageContext pc;
	private Tag parent;

	private boolean condition;

	/**
	 * Depois que os setters foram invocados, o container chama doStartTag para
	 * o handler realizar o processamento dessa tag. Este metodo retorna um int
	 * que indica se o corpo da tag deve, ou nao, ser processado.
	 */
	@Override
	public int doStartTag() throws JspException {
		if (this.condition) {
			return Tag.EVAL_BODY_INCLUDE;
		}
		return Tag.SKIP_BODY;
	}

	/**
	 * Depois ue doStartTag e finalizado, doEndTag e chamado pelo container para
	 * verificar se o resto da pagina jsp deve ser processada. O int retornado
	 * indica essa conficao.
	 */
	@Override
	public int doEndTag() throws JspException {
		return Tag.EVAL_PAGE;
	}

	/**
	 * Release e chamado sempre por ultimo para liberar recursos da tag.
	 */
	@Override
	public void release() {
		this.pc = null;
	}

	/**
	 * Quando a tag e encontrada em uma JSP, o container instancia um handler e
	 * invoca o metodo setPageContext para passar o contexto da pagina para o
	 * manipulador.
	 */
	@Override
	public void setPageContext(PageContext pc) {
		this.pc = pc;
	}

	/**
	 * Este metodo e o segundo a ser invocado. O container passa a tag pai dessa
	 * tag que esta sendo manipulada por este handler para dessa forma o
	 * manipulador conseguir realizar tarefas de colaboracao.
	 */
	@Override
	public void setParent(Tag t) {
		this.parent = t;
	}

	@Override
	public Tag getParent() {
		return this.parent;
	}

	/**
	 * @return the condition
	 */
	public boolean isCondition() {
		return condition;
	}

	/**
	 * Depois que setPageContext e setparent sao invocados, todos os setters dos
	 * atributos da tag sao invocados para definir os valores informados na
	 * pagina jsp.
	 * 
	 * @param condition
	 */
	public void setCondition(boolean condition) {
		this.condition = condition;
	}

}
