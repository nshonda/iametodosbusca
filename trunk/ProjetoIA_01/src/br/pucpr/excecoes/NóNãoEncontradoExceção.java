package br.pucpr.excecoes;

public class NóNãoEncontradoExceção extends Exception {

	private static final long serialVersionUID = 1L;

	public NóNãoEncontradoExceção() {
		super();
	}

	public NóNãoEncontradoExceção(String arg0) {
		super(arg0);
	}

	public NóNãoEncontradoExceção(Throwable arg0) {
		super(arg0);
	}

	public NóNãoEncontradoExceção(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

}
