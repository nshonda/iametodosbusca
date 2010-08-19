package br.pucpr.busca;

import java.util.ArrayList;
import java.util.List;

import br.pucpr.excecoes.NóNãoEncontradoExceção;
import br.pucpr.model.Edge;
import br.pucpr.model.Node;
import br.pucpr.util.Verbose;

/**
 * Método de Busca em Largura - CEGA
 * 
 * @author Heverton Ivan de Sene
 * 
 */
public class BuscaLarguraCega {

	private List<Node> grafo = null;
	private List<Node> adjacentes = null;
	private static final Verbose logger = Verbose.getInstancia();

	/**
	 * Construtor que passa o grafo a ser buscado.
	 * 
	 * @param grafo
	 */
	public BuscaLarguraCega(List<Node> grafo) {
		super();
		this.grafo = grafo;
		this.adjacentes = new ArrayList<Node>();
	}

	/**
	 * Função responsável por limpar todas as informações de nó. <br />
	 * Isto significa dizer que nenhum nó ainda foi visitado.
	 */
	private void zeraGrafo() {
		for (Node nó : grafo) {
			nó.setVisitado(false);
		}
	}

	/**
	 * Busca as informações do NODE passando o ID.
	 * 
	 * @param ip
	 *            - string que representa o IP desejado.
	 * @return o nó preenchido
	 * @throws NóNãoEncontradoExceção
	 */
	private final Node getNodeInfoNoGrafo(String ip)
			throws NóNãoEncontradoExceção {
		Node nó = null;
		try {
			int index = grafo.indexOf(new Node(ip));

			if (index >= 0)
				nó = grafo.get(index);
		} catch (Exception e) {
			throw new NóNãoEncontradoExceção("O Nó não foi encontrado.\n", e);
		}

		if (nó == null)
			throw new NóNãoEncontradoExceção("O Nó não foi encontrado.");

		return nó;
	}

	public void buscarLargura(Node inicio, Node fim)
			throws NóNãoEncontradoExceção {
		logger.info("Começar o método de busca em Largura.");
		long beginTime = System.currentTimeMillis();

		if (fim.equals(inicio)) {
			logger.info("você já se encontra onde gostaria.");
			return;
		}

		zeraGrafo();

		List<Edge> ligacoes = inicio.getArestas();
		inicio.setVisitado(true);

		adicionaEntradaNoFimDaLista(ligacoes);

		while (!adjacentes.isEmpty()) {
			Node nó = adjacentes.remove(0);

			if (!nó.isVisitado()) {
				nó.setVisitado(true);
				System.out.println(nó);
				if (fim.equals(nó)) {
					logger.info("Nó encontrado.");
					break;
				}

				ligacoes = nó.getArestas();
				adicionaEntradaNoFimDaLista(ligacoes);
			}
		}

		long endTime = System.currentTimeMillis();
		logger.info("O método de busca em Largura demorou ["
				+ (endTime - beginTime) + "] milisegundos.");
	}

	/**
	 * Adiciona as entradas da Aresta em uma lista.
	 * 
	 * @param ligacoes
	 * @throws NóNãoEncontradoExceção
	 */
	private void adicionaEntradaNoFimDaLista(List<Edge> ligacoes)
			throws NóNãoEncontradoExceção {

		for (Edge edge : ligacoes) {
			Node nó = getNodeInfoNoGrafo(edge.getIpDestino());

			if (!nó.isVisitado())
				adjacentes.add(nó);
		}
	}

}
