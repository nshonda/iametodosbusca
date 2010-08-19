package br.pucpr.model;

import java.util.ArrayList;
import java.util.List;

public class Node {
	private String iP;
	private String nome;
	private List<Edge> arestas;
	private boolean visitado;

	/**
	 * Contrutor padrão.<br />
	 * Recebe o nome e o ip para identificação do Node.
	 * 
	 * @param ip
	 * @param nome
	 */
	public Node(String ip, String nome) {
		super();
		this.iP = ip;
		this.nome = nome;
		arestas = new ArrayList<Edge>();
		this.visitado = false;
	}

	/**
	 * Contrutor sobrecarregado. <br />
	 * Atenção utilizá-lo apenas para busca.
	 * 
	 * @param ip
	 */
	public Node(String ip) {
		this(ip, null);
	}

	public List<Edge> getArestas() {
		return arestas;
	}
	
	public void setVisitado(boolean visitado) {
		this.visitado = visitado;
	}

	public boolean isVisitado() {
		return visitado;
	}


	@Override
	public String toString() {
		return "Node [IP=" + iP + ", nome=" + nome + " ]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((iP == null) ? 0 : iP.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Node other = (Node) obj;
		if (iP == null) {
			if (other.iP != null)
				return false;
		} else if (!iP.equals(other.iP))
			return false;
		return true;
	}

}
