package br.edu.infnet.esports.model.exceptions;

public class CampoVazioException extends Exception {
	private static final long serialVersionUID = 1L;

	public CampoVazioException(String mensagem) {
		super(mensagem);
	}
}
