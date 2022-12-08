package br.edu.infnet.esports.model.domain;
import br.edu.infnet.esports.model.auxiliar.Constante;

public class Fifa extends Game {
	private int finalizacao;
	private int marcacao;
	private int passe;

		
	public Fifa(String plataforma, int finalizacao, int marcacao, int passe) {
		super("FIFA 22", plataforma);
		
		this.finalizacao = finalizacao;
		this.marcacao = marcacao;
		this.passe = passe;
	}
	
	@Override
	public String calculaNivelGamer() {
		int finalizacao = this.finalizacao * Constante.PESO_3;
		int marcacao= this.marcacao * Constante.PESO_2;
		int passe = this.passe * Constante.PESO_1;
		
		int total = (finalizacao + marcacao + passe) / 3;
		
		if(total >= 180) return "lendário";
		else if(total >= 140 && total < 180) return "profissional";
		else if(total >= 60 && total < 140) return "semipro";
		else return "iniciante";
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

	public int getFinalizacao() {
		return finalizacao;
	}

	public void setFinalizacao(int finalizacao) {
		this.finalizacao = finalizacao;
	}

	public int getMarcacao() {
		return marcacao;
	}

	public void setMarcacao(int marcacao) {
		this.marcacao = marcacao;
	}

	public int getPasse() {
		return passe;
	}

	public void setPasse(int passe) {
		this.passe = passe;
	}
	 
}
