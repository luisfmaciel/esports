package br.edu.infnet.esports.model.exceptions;

public class GameNaoEncontradoException extends Exception {
	private static final long serialVersionUID = 1L;

	public GameNaoEncontradoException(String mensagem) {
		super(mensagem);
	}
}
