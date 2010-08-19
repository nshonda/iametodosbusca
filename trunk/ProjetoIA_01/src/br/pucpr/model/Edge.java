package br.pucpr.model;

public class Edge {
	private String ipDestino;
	private int peso;
	private boolean visitado;

	public Edge(String ipDestino, int peso) {
		super();
		this.ipDestino = ipDestino;
		this.peso = peso;
		this.setVisitado(false);
	}

	public String getIpDestino() {
		return ipDestino;
	}

	public int getPeso() {
		return peso;
	}

	public void setVisitado(boolean visitado) {
		this.visitado = visitado;
	}

	public boolean isVisitado() {
		return visitado;
	}

	@Override
	public String toString() {
		return "Edge [ipDestino=" + ipDestino + ", peso=" + peso + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((ipDestino == null) ? 0 : ipDestino.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Edge))
			return false;
		Edge other = (Edge) obj;
		if (ipDestino == null) {
			if (other.ipDestino != null)
				return false;
		} else if (!ipDestino.equals(other.ipDestino))
			return false;
		return true;
	}

}
