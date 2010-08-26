package br.pucpr;

import java.util.ArrayList;
import java.util.List;

import br.pucpr.busca.BuscaLarguraCega;
import br.pucpr.excecoes.ExceçãoDeArquivo;
import br.pucpr.excecoes.NóNãoEncontradoExceção;
import br.pucpr.handlers.ControleParser;
import br.pucpr.model.Node;
import br.pucpr.model.TipoBusca;
import br.pucpr.util.Util;
import br.pucpr.util.Verbose;

/**
 * Classe principal, que será o ponto de Start da Aplicação.
 * 
 * @author Heverton Ivan de Sene
 * 
 */
public class MetodosBusca {

	private static final Verbose logger;

	static {
		// System.setProperty("verbose", "false");
		logger = Verbose.getInstancia();
	}

	public static void main(String[] args) {

		logger.debug("Iniciando a aplicação.");

		try {
			if (args.length != 3)
				throw new IllegalArgumentException(
						"Número inválido de Argumentos");

			String origem = args[0].trim();
			String destino = args[1].trim();
			TipoBusca tipo = TipoBusca.getTipoBusca(args[2].trim());

			if (tipo.equals(TipoBusca.UNKNOW)) {
				throw new IllegalArgumentException(
						"Tipo de Busca Desconhecida.");
			}

			if (!Util.isIpValido(origem)) {
				throw new IllegalArgumentException("Ip de ORIGEM inválido. = "
						+ origem);
			}

			if (!Util.isIpValido(destino)) {
				throw new IllegalArgumentException("Ip de Destino inválido. = "
						+ destino);
			}

			ControleParser cp = new ControleParser("resources/topologia.txt");
			cp.constróiGrafo();
			cp.mostraGrafo();
			List<Node> grafo = cp.getGrafo();

			Node inicio = cp.getNodeInfoNoGrafo(origem);
			Node fim = cp.getNodeInfoNoGrafo(destino);

			BuscaLarguraCega busca = new BuscaLarguraCega(grafo);
			Node encontrado = busca.buscarLargura(inicio, fim);

			// Preenche o caminho de volta.
			List<Node> caminho = new ArrayList<Node>();
			do {
				caminho.add(0, encontrado);
			} while ((encontrado = encontrado.getPai()) != null);

			int i = 0;
			for (Node node : caminho) {
				logger.info("[" + (++i) + "] >> " + node);
			}

			logger.info("Foram visitados [" + Util.getNumeroNosVisitados()
					+ "] nós até encontrar o caminho.");

		} catch (ExceçãoDeArquivo e) {
			e.printStackTrace();
		} catch (NóNãoEncontradoExceção e) {
			e.printStackTrace();
		} catch (IllegalArgumentException iae) {
			StringBuilder sb = new StringBuilder();
			sb.append("\nArgumento entrados de forma inválida.\n");
			sb.append("Problema [" + iae.getMessage() + "]\n");
			sb.append("Favor utilizar a seguinte sintaxe:\n");
			sb.append("buscar IP_ORIGEM IP_DESTINO TIPO_BUSCA\n");
			sb.append("TIPO_BUSCA pode ser ( CEGA | A* )");
			logger.info(sb.toString());
		}

		logger.debug("Fim a aplicação.");
	}

}
