package br.pucpr.model;

import java.util.ArrayList;
import java.util.List;

public class Node implements Comparable<Node>{
	private String iP;
	private String nome;
	private List<Edge> arestas;
	private boolean visitado;
	private Node pai;
	private Ponto origem;
	private int fator;
	private double tempoTotal;
	private double faltaTempo;

	/**
	 * Contrutor padrão.<br />
	 * Recebe o nome e o ip para identificação do Node.
	 * 
	 * @param ip
	 * @param nome
	 */
	public Node(String ip, String nome, Ponto origem, int fator) {
		super();
		this.iP = ip;
		this.nome = nome;
		this.origem = origem;
		this.fator = fator;
		arestas = new ArrayList<Edge>();
		this.visitado = false;
		this.pai = null;
	}

	/**
	 * Contrutor sobrecarregado. <br />
	 * Atenção utilizá-lo apenas para busca.
	 * 
	 * @param ip
	 */
	public Node(String ip) {
		this(ip, null, null, 0);
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

	public void setPai(Node pai) {
		this.pai = pai;
	}

	public Node getPai() {
		return pai;
	}

	public Ponto getOrigem() {
		return origem;
	}

	public int getFator() {
		return fator;
	}

	public double getTempoTotal() {
		return tempoTotal;
	}
	
	public double getFaltaTempo() {
		return faltaTempo;
	}

	public void calculaTempoTotal() {
		this.tempoTotal = 0;
		if(this.pai != null) {
			tempoTotal = this.pai.getTempoTotal() + (this.fator + pai.getFator())* this.origem.calcularDistancia(pai.getOrigem());
		}
	}
	
	public void calculaTempoRestante(Node destino) {
		faltaTempo = (this.fator + destino.getFator()) * this.origem.calcularDistancia(destino.getOrigem());
	}

	@Override
	public String toString() {
		return "Node [IP=" + iP + ", " + this.origem
				+ ",  fator=" + this.fator + ", Tt= "+ this.tempoTotal +", Tf= "+ this.faltaTempo +", Soma = " + (this.tempoTotal + this.faltaTempo) + "]";
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

	@Override
	public int compareTo(Node o) {
		
		if((this.faltaTempo + this.tempoTotal) < (o.getFaltaTempo() + o.getTempoTotal())) return -1;
		if((this.faltaTempo + this.tempoTotal) > (o.getFaltaTempo() + o.getTempoTotal())) return 1;
		return 0;
	}

}
