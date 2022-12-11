package br.edu.infnet.esports.model.exceptions;

public class PlatformaDiferenteException extends Exception {
	private static final long serialVersionUID = 1L;

	public PlatformaDiferenteException(String mensagem) {
		super(mensagem);
	}
}
