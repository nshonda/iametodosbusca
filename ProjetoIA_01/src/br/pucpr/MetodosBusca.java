package br.pucpr;

import java.util.List;

import br.pucpr.busca.BuscaLarguraCega;
import br.pucpr.excecoes.ExceçãoDeArquivo;
import br.pucpr.handlers.ControleParser;
import br.pucpr.model.Node;
import br.pucpr.util.Verbose;

/**
 * Classe principal, que será o ponto de Start da Aplicação.
 * @author Heverton Ivan de Sene
 *
 */
public class MetodosBusca {
		
	private static final Verbose logger;
	
	static
	{
		System.setProperty("verbose", "true");
		logger = Verbose.getInstancia();
	}
	
	public static void main(String[] args) {
		
		logger.info("Iniciando a aplicação.");
		
		try {
			ControleParser cp = new ControleParser("resources/topologia01.txt");
			cp.constróiGrafo();
			cp.mostraGrafo();
			List<Node> grafo = cp.getGrafo();
			
			BuscaLarguraCega busca = new BuscaLarguraCega(grafo);
			Node inicio = new Node("192.168.1.0");
			Node fim = new Node("192.168.4.0");
			
			busca.buscarLargura(inicio, fim);
			
		} catch (ExceçãoDeArquivo e) {
			e.printStackTrace();
		}
		
		logger.info("Fim a aplicação.");
	}
	
}
