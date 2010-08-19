package br.pucpr.handlers;

import java.util.ArrayList;
import java.util.List;

import br.pucpr.excecoes.ExceçãoDeArquivo;
import br.pucpr.model.Edge;
import br.pucpr.model.Node;
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
					logger.info(linha);

					String[] info = linha.split(";");
					String ip = info[0];
					String nome = info[1];
					Node nó = new Node(ip, nome);
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
					logger.info(linha);
					String[] info = linha.split(";");
					String ipOrigem = info[0];

					int index = nodes.indexOf(new Node(ipOrigem));
					Node nóOrigem = nodes.get(index);
					List<Edge> arestasOrigem = nóOrigem.getArestas();

					info = info[1].split("-");

					int peso = 1;
					for (String ipDestino : info) {
						// TODO Arrumar o peso
						Edge aresta = new Edge(ipDestino, (peso++) * 3);
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

	public void mostraGrafo() {
		for (Node nó : nodes) {
			logger.info("---------------------------------\nORIGEM => "
					+ nó.toString());
			List<Edge> arestas = nó.getArestas();
			for (Edge ar : arestas) {
				Node noDestino = new Node(ar.getIpDestino());
				int index = nodes.indexOf(noDestino);
				noDestino = nodes.get(index);
				System.out.println("    ATINGE => " + noDestino.toString() + " PESO CAMINHO = "+ar.getPeso());
			}

		}
	}

	public static void main(String[] args) {
		try {
			ControleParser cp = new ControleParser("resources/topologia01.txt");
			cp.constróiGrafo();
			cp.mostraGrafo();
		} catch (ExceçãoDeArquivo e) {
			e.printStackTrace();
		}
	}

}
