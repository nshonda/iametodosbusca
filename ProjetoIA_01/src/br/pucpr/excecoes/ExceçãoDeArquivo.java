package br.pucpr.excecoes;

/**
 * Exceções do Tipo de Arquivos
 * @author Heverton
 *
 */
public class ExceçãoDeArquivo extends Exception {

	private static final long serialVersionUID = 1L;

	public ExceçãoDeArquivo() {
		super();
	}

	public ExceçãoDeArquivo(String message, Throwable cause) {
		super(message, cause);
	}

	public ExceçãoDeArquivo(String message) {
		super(message);
	}

	public ExceçãoDeArquivo(Throwable cause) {
		super(cause);
	}

}
