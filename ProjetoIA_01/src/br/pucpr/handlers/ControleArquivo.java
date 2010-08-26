package br.pucpr.handlers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import br.pucpr.excecoes.ExceçãoDeArquivo;
import br.pucpr.util.Verbose;

public class ControleArquivo {

	private BufferedReader file;
	private String path;
	private static final Verbose logger = Verbose.getInstancia();

	/**
	 * Construtor que recebe o caminho do Arquivo.
	 * 
	 * @param path
	 * @throws ExceçãoDeArquivo
	 */
	public ControleArquivo(String path) throws ExceçãoDeArquivo {
		super();
		this.path = path;
		logger.debug("Iniciando o arquivo em : " + path);
		inicializarArquivo();
	}

	/**
	 * Localiza e inicia a abertura do arquivo.
	 * 
	 * @throws ExceçãoDeArquivo
	 */
	private void inicializarArquivo() throws ExceçãoDeArquivo {
		File f = new File(path);
		if (!f.exists() || !f.canRead())
			throw new ExceçãoDeArquivo("O Arquivo [" + f.getAbsolutePath()
					+ "] não foi encontrado" + " ou não pode ser lido.");

		try {
			FileReader fr = new FileReader(f);
			file = new BufferedReader(fr);
		} catch (FileNotFoundException e) {
			throw new ExceçãoDeArquivo("O Arquivo [" + f.getAbsolutePath()
					+ "] não foi encontrado" + "ou não pode ser lido.", e);
		}
	}

	/**
	 * Método que indica se o arquivo está pronto para ser lido.
	 * 
	 * @return <strong>true</strong> - se posso ler o arquivo <br>
	 *         <strong>false</strong> - se não posso ler
	 */
	public boolean possoLer() {
		boolean retorno = false;
		try {
			retorno = file.ready();
		} catch (IOException e) {
			retorno = false;
		}
		return retorno;
	}

	/**
	 * Método que le o arquivo e te retorno a linha atual, já com o trim
	 * aplicado. <br>
	 * Já faz o parser de modo a ignorar as linhas de comentários. <br>
	 * Linhas de comentários começam com <strong>#</strong>
	 * 
	 * @return linha - pronta para ser usada.
	 */
	public String leiaLinha() {
		String retorno = new String("");

		try {
			do {
				if (file.ready()) {
					retorno = file.readLine().trim();
				} else {
					retorno = null;
					break;
				}
			} while (retorno.isEmpty() || retorno.startsWith("#"));
		} catch (IOException e) {
			logger.debug("ERRO - " + e.getMessage());
		}

		return retorno;
	}

}
