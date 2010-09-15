package br.pucpr.handlers;

import java.util.ArrayList;
import java.util.List;

import br.pucpr.excecoes.ExceçãoDeArquivo;
import br.pucpr.excecoes.NóNãoEncontradoExceção;
import br.pucpr.model.Edge;
import br.pucpr.model.Node;
import br.pucpr.model.Ponto;
import br.pucpr.util.Verbose;

public class ControleParser {
	private ControleArquivo file;
	private List<Node> nodes;
	private static final Verbose logger = Verbose.getInstancia();

	/**
	 * Contrutor do Controlador de Parser, que recebe o arquivo que será
	 * parseado.
	 * 
	 * @param path
	 * @throws ExceçãoDeArquivo
	 */
	public ControleParser(String path) throws ExceçãoDeArquivo {
		super();
		file = new ControleArquivo(path);
		nodes = new ArrayList<Node>();
	}

	public void constróiGrafo() {
		// Busca os Nós.
		while (file.possoLer()) {
			String linha = file.leiaLinha();
			if (linha != null) {
				if (!linha.startsWith("/")) {
					logger.debug(linha);

					String[] info = linha.split(";");
					String ip = info[0];
					String nome = info[1];
					int X = Integer.parseInt(info[2]);
					int Y = Integer.parseInt(info[3]);
					int Fator = Integer.parseInt(info[4]);
					Ponto P = new Ponto(X,Y);
					Node nó = new Node(ip, nome, P, Fator);
					nodes.add(nó);
				} else {
					// Significa que acabou a parte de carga de nodes
					break;
				}
			}
		}

		// Busca as Arestas
		while (file.possoLer()) {
			String linha = file.leiaLinha();
			if (linha != null) {
				if (!linha.startsWith("/")) {
					logger.debug(linha);
					String[] info = linha.split(";");
					String ipOrigem = info[0];

					int index = nodes.indexOf(new Node(ipOrigem));
					Node nóOrigem = nodes.get(index);
					List<Edge> arestasOrigem = nóOrigem.getArestas();

					info = info[1].split("-");

					for (String ipDestino : info) {
						// TODO Arrumar o peso
						Edge aresta = new Edge(ipDestino);
						arestasOrigem.add(aresta);
					}

				} else {
					// Significa que acabou a parte de carga de nodes
					break;
				}
			}
		}
	}

	public final List<Node> getGrafo() {
		return nodes;
	}

	/**
	 * Busca as informações do NODE passado o ID.
	 * 
	 * @param ip
	 *            - string que representa o IP desejado.
	 * @return o nó preenchido
	 * @throws NóNãoEncontradoExceção
	 */
	public final Node getNodeInfoNoGrafo(String ip)
			throws NóNãoEncontradoExceção {
		Node nó = null;
		try {
			int index = nodes.indexOf(new Node(ip));

			if (index >= 0)
				nó = nodes.get(index);
		} catch (Exception e) {
			throw new NóNãoEncontradoExceção("O Nó não foi encontrado.\n", e);
		}

		if (nó == null)
			throw new NóNãoEncontradoExceção("O Nó não foi encontrado.");

		return nó;
	}

	public void mostraGrafo() {
		for (Node nó : nodes) {
			logger.debug("---------------------------------\nORIGEM => "
					+ nó.toString());
			List<Edge> arestas = nó.getArestas();
			for (Edge ar : arestas) {
				Node noDestino = new Node(ar.getIpDestino());
				int index = nodes.indexOf(noDestino);
				noDestino = nodes.get(index);
			}

		}
	}
}
