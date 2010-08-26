package br.pucpr.model;

public enum TipoBusca {
	CEGA,A_STAR, UNKNOW;
	
	public static TipoBusca getTipoBusca(String tipo){
		
		if("A*".equalsIgnoreCase(tipo))
			return A_STAR;
		else if("CEGA".equalsIgnoreCase(tipo))
			return CEGA;
		else
			return UNKNOW;
	}
}
