package validator;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.jsp.tagext.PageData;
import javax.servlet.jsp.tagext.TagLibraryValidator;
import javax.servlet.jsp.tagext.ValidationMessage;

/**
 * Um validator e utilizado para validar o XML View de uma pagina JSP onde uma
 * tag pertencente ao TLD que possui esse Validator e utilizada.
 * 
 * @author Matheus
 * 
 */
public class CustomValidator extends TagLibraryValidator {

	/**
	 * Esse metodo e chamado para validar os namespaces do XML Viw. Caso esteja
	 * tudo correto, o valor null ou um array vazio de ValidationMessage e
	 * retornado. Caso contrario, um array de ValidationMessage contendo as
	 * mensagens de erro de validacao deve ser retornado.
	 */
	@Override
	public ValidationMessage[] validate(String prefix, String uri, PageData page) {
		List<ValidationMessage> messages = new ArrayList<>();

		if (uri != null && uri.endsWith("tld")) {
			ValidationMessage message = new ValidationMessage(null, "Um TLD nao deve ser referenciado diretamente na pagina JSP!");
			messages.add(message);
		}

		return messages.toArray(new ValidationMessage[0]);
	}

}
