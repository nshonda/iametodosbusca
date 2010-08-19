package br.pucpr.busca;

import java.util.List;

import br.pucpr.model.Node;
import br.pucpr.util.Verbose;

/**
 * Método de Busca em Largura - CEGA
 * @author Heverton Ivan de Sene
 *
 */
public class BuscaLarguraCega {

	private List<Node> grafo = null;
	private static final Verbose logger = Verbose.getInstancia();
	
	/**
	 * Construtor que passa o grafo a ser buscado.
	 * @param grafo
	 */
	public BuscaLarguraCega(List<Node> grafo){
		super();
		this.grafo = grafo;
	}
	
	public void buscarLargura(){
		logger.info("Começar o método de busca em Largura.");
	}
	
}
