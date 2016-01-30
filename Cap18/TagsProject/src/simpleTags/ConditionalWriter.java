package simpleTags;

import java.io.IOException;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.JspTag;
import javax.servlet.jsp.tagext.SimpleTag;

/**
 * SimpleTags e uma forma mais simples de criacao de tags customizadas
 * introduzida na versao 2.0 da especificacao de JSP. Com simple tags, nao e
 * necessario retornar constantes nos metodos para informar ao container qual a
 * proxima acao que devera ser executada. Diferentemente das classic Tags,
 * quando uma simple tag e declarada na JSP, uma nova instancia de um handler e
 * criado para manipular a tag. Quando uma simple tag e encontrada pelo
 * container, o metodo setJspContext e chamado, logo apos, caso essa simple tag
 * possua uma JspTag parent, o metodo setParent e chamado. Depois, caso essa
 * simple tag possua um corpo, o metodo setJspBody e executado e recebe um
 * JSPFragment, que representa um fragmento de pagina JSP nao avaliado. Por fim,
 * o metodo doTag e invocado para realizar o processamento da tag. Apesar das
 * simple Tags serem bastantes simples e poderosas, elas ainda nao oferecem toda
 * a flexibilidade e o poder das classic tags, uma vez que nao e possivel
 * utilizar elementos de script JSP no corpo de simple tags, pois o conteudo de
 * simple tags nao e avaliado em tempo de requisicao, desta forma a simple tag
 * pode manipular o conteudo no momento certo, porem com isso, como elementos de
 * scripts sao avaliados em tempo de requisicao pelo container, eles nao podem
 * ser utilizados no corpo de uma simple tag. Caso o elemento body-content no
 * TLD seja declarado como "tagdependent", nao ocorrera nenhuma excecao caso
 * elementos de scripts JSP sejam utilizados no corpo de simple tags, porem eles
 * nao sao avaliado, e sao enviado como texto puro para o output.
 * 
 * @author Matheus
 * 
 */
public class ConditionalWriter implements SimpleTag {

	@SuppressWarnings("unused")
	private JspContext jspContext;
	private JspTag parent;
	private JspFragment fragment;
	private boolean test;

	@Override
	public void doTag() throws JspException, IOException {
		if (this.test && this.fragment != null) {

			/*
			 * O metodo invoke de JspFragment faz o container avaliar o conteudo
			 * do corpo representado por este fragment. O conteudo avaliado e
			 * escrito no writer informado. Caso o writer informado seja null
			 * (como neste caso), o conteudo do fragment e escrito diretamente
			 * no objeto implicito out recuperado atraves de PageContext.
			 */
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
