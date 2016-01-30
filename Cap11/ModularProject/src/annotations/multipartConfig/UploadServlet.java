package annotations.multipartConfig;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * MultipartConfig foi criada para configurar servlets que serao responsaveis
 * por receber requisicoes de formularios com enctype="multipart/form-data", ou
 * seja, formularios que enviam (upload) arquivos para o servidor. Com essa
 * anotacao, o container sabe como tratar requisicoes desse tipo e armazena os
 * arquivo enviados pelo browser em objetos do tipo javax.servlet.http.Part.
 * 
 * @author Matheus
 * 
 */

// MultipartConfig
/*
 * fileSizeThreshold = Limite em bytes do arquivo que sera mantido na memoria
 * RAM, caso ultrapasse esse valor, o arquivo sera salvo em uma pasta temporaria
 * no disco. Essa pasta temporaria é definida atraves do atributo location. Caso
 * nao seja especificado, ou o valor 0 seja definidor, o arquivo sera salvo no
 * disco.
 */
/*
 * location = Caminho da pasta temporaria onde sera salvo o arquivo caso
 * ultrapasse o limite estabelecido em fileSizeThreshold. Se nao for
 * especificado, o caminho padrao do container sera utilizado. Se um caminho
 * relativo for informado, sera relativo de acordo com o caminho padrao do
 * container. O caminho padrao do container é armazenado em um atributo de
 * contexto chamado "javax.servlet.context.tempdir"
 */
/*
 * maxFileSize = Tamanho maximo permitido para cada arquivo, caso ultrapasse
 * esse tamanho uma excecao sera lancada quando os metodos getPart(String) ou
 * getParts() forem chamados. Se nao for especificado, o padrao será -1
 * significando que essa requisicao nao possui limite de tamanho.
 */
/*
 * maxRequestSize = Tamanho maximo da requisicao, caso ultrapasse esse limite
 * uma excecao sera lancada quando os metodos getPart(String) ou getParts()
 * forem chamados. Se nao for especificado, o padrao será -1 significando que
 * essa requisicao nao possui limite de tamanho.
 */
/*
 * fileSizeThreshold = 1MB; maxFileSize = 2MB; maxRequestSize = Sem limite
 */
@MultipartConfig(fileSizeThreshold = 1048576, location = "/Users/Matheus/Downloads", maxFileSize = 2097152, maxRequestSize = -1)
@WebServlet("/UploadServlet")
public class UploadServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6849354522278026769L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/*
		 * Caso a servlet nao esteja configurada com MultipartConfig no DD ou
		 * anotada, o metodo getPart(String) ou getParts() retornara null. Caso
		 * contrario, se nenhum arquivo foi selecionado, mesmo que o formulario
		 * nao possua enctype=multiconfig/form-data, esses metodos retornaram um
		 * objeto Part. Cabe ao programador verificar se algum arquivo foi
		 * enviado a partir do browser. Se algum arquivo foi selecionado e
		 * enviado, porem o formulario nao possui enctype=multipart/form-data, a
		 * utilizacao desses metodos resultara em uma excecao.
		 */
		Part file = req.getPart("file");

		if (file != null && file.getSize() > 0) {
			// Retorna o nome do input
			resp.getWriter().println("getName = " + file.getName());

			resp.getWriter().println("getContentType = " + file.getContentType());
			resp.getWriter().println("getSize = " + file.getSize());
			resp.getWriter().println("getHeaderNames = " + file.getHeaderNames());

			String content = file.getHeader("content-disposition");
			String fileName = content.split("=")[2].replace("\"", "");

			resp.getWriter().println("content-disposition = " + content);
			resp.getWriter().println("File Name = " + fileName);

			/*
			 * Metodo conveniente para escrver o arquivo no disco. Caso um
			 * caminho relativo seja informado, ele sera relativo ao caminho do
			 * atributo location definido na anotacao.
			 */
			// file.write(fileName);

			/*
			 * Deleta o arquivo temporario salvo no disco.
			 */
			// file.delete();

			/*
			 * Retorna o primeiro valor do cabecalho informado se houver. Caso
			 * contrario retorna null.
			 */
			// file.getHeader("content-type");

			/*
			 * Retorna uma colecao de Strings com os nomes de todos os
			 * cabecalhos do arquivo.
			 */
			// file.getHeaderNames();

			/*
			 * Retorna todos uma colecao de Strings com todos os valores do
			 * cabecalho informado.
			 */
			// file.getHeaders("header");
		}
	}
}
