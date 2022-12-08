package br.edu.infnet.esports.model.domain;

public class Fifa extends Game {
	private int finalizacao;
	private int marcacao;
	private int passe;

		
	public Fifa() {
		super("FIFA 22");
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.finalizacao);
		sb.append(";");
		sb.append(this.marcacao);
		sb.append(";");
		sb.append(this.passe);
		
		return super.toString() + sb.toString();	
	}

	public int getfinalizacao() {
		return finalizacao;
	}

	public void setfinalizacao(int finalizacao) {
		this.finalizacao = finalizacao;
	}

	public int getmarcacao() {
		return marcacao;
	}

	public void setmarcacao(int marcacao) {
		this.marcacao = marcacao;
	}

	public int getPasse() {
		return passe;
	}

	public void setPasse(int passe) {
		this.passe = passe;
	}
	 
}
