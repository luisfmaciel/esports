package br.edu.infnet.esports.model.exceptions;

public class GamerSemGameException extends Exception {
	private static final long serialVersionUID = 1L;

	public GamerSemGameException(String mensagem) {
		super(mensagem);
	}
}
