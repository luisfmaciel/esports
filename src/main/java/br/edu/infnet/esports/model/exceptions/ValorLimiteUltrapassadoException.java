package br.edu.infnet.esports.model.exceptions;

public class ValorLimiteUltrapassadoException extends Exception {

	private static final long serialVersionUID = 1L;

	public ValorLimiteUltrapassadoException(String mensagem) {
		super(mensagem);
	}
}
