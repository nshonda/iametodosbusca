package br.pucpr.busca;

import java.util.ArrayList;
import java.util.List;

import br.pucpr.excecoes.NóNãoEncontradoExceção;
import br.pucpr.model.Edge;
import br.pucpr.model.Node;
import br.pucpr.util.Util;
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

	/**
	 * Retorna o nó do caminho.
	 * 
	 * @param inicio
	 * @param fim
	 * @throws NóNãoEncontradoExceção
	 */
	public Node buscarLargura(Node inicio, Node fim)
			throws NóNãoEncontradoExceção {
		logger.debug("Começar o método de busca em Largura.");
		long beginTime = System.currentTimeMillis();

		if (fim.equals(inicio)) {
			logger.debug("você já se encontra onde gostaria. ==> " + inicio);
			return inicio;
		}

		Node nó = inicio;
		logger.debug("Inicio em => " + nó);
		zeraGrafo();

		List<Edge> ligacoes = nó.getArestas();
		nó.setVisitado(true);

		adicionaEntradaNoFimDaLista(ligacoes, nó);

		while (!adjacentes.isEmpty()) {
			nó = adjacentes.remove(0);

			if (!nó.isVisitado()) {

				logger.debug("Visitando ." + nó + " >> "
						+ Util.getNumeroNosVisitados());

				nó.setVisitado(true);
				Util.incrementaQtdeNoVisitado();
				if (fim.equals(nó)) {
					logger.debug("Nó encontrado.");
					break;
				}

				ligacoes = nó.getArestas();
				adicionaEntradaNoFimDaLista(ligacoes, nó);
			}
		}

		long endTime = System.currentTimeMillis();
		logger.debug("O método de busca em Largura demorou ["
				+ (endTime - beginTime) + "] milisegundos.");
		return nó;
	}

	/**
	 * Adiciona as entradas da Aresta em uma lista.
	 * 
	 * @param ligacoes
	 * @param pai
	 *            - Nó pai que está requisitando a inserção na fila
	 * @throws NóNãoEncontradoExceção
	 */
	private void adicionaEntradaNoFimDaLista(List<Edge> ligacoes, Node pai)
			throws NóNãoEncontradoExceção {

		for (Edge edge : ligacoes) {
			Node nó = getNodeInfoNoGrafo(edge.getIpDestino());

			if (!nó.isVisitado()) {
				if (nó.getPai() == null)
					nó.setPai(pai);

				adjacentes.add(nó);
			}

		}
	}

}
