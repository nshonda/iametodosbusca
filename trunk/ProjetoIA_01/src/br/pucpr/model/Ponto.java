package br.pucpr.model;

public class Ponto {
	private int pontoX;
	private int pontoY;
	
	public Ponto(int pontoX, int pontoY) {
		super();
		this.pontoX = pontoX;
		this.pontoY = pontoY;
	}
	
	public int getPontoX() {
		return pontoX;
	}
	
	public int getPontoY() {
		return pontoY;
	}
	
	public double calcularDistancia(Ponto destino){
		double somaX = ((this.pontoX-destino.getPontoX())*(this.pontoX-destino.getPontoX()));
		double somaY = ((this.pontoY-destino.getPontoY())*(this.pontoY-destino.getPontoY()));
		return Math.sqrt((somaX+somaY));
	}

	@Override
	public String toString() {
		return "Ponto (" + pontoX + ", " + pontoY + ")";
	}	
	
}
