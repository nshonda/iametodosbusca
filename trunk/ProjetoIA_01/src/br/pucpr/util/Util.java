package br.pucpr.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Util {
	
	private static final String PATTERN_IP = 
		"\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}";
	
	private static int contadorNoVisitados = 0;
	/**
	 * Função que válida se o IP está no padrão
	 * @param ip
	 * @return true se OK.
	 */
	public static boolean isIpValido(String ip){
		boolean retorno = false;
		
		Pattern pat = Pattern.compile(PATTERN_IP);
		Matcher mat = pat.matcher(ip);
		
		if(mat.matches())
			retorno = true;
		
		return retorno;
	}

	/**
	 * Incrementa a quantidade de nós que foram visitados pela busca
	 */
	public static void incrementaQtdeNoVisitado(){
		contadorNoVisitados++;
	}
	
	/**
	 * Retorna a quantidade de nós visitados.
	 * @return quantidade de nós visitados.
	 */
	public static int getNumeroNosVisitados(){
		return contadorNoVisitados;
	}
}
