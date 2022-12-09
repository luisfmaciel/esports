package br.edu.infnet.esports.model.domain;
import br.edu.infnet.esports.model.auxiliar.Constante;

public class Fifa extends Game {
	private int finalizacao;
	private int marcacao;
	private int passe;

		
	public Fifa(String plataforma) {
		super("FIFA", plataforma);		
	}
	
	@Override
	public String calculaNivelGamer() {
		int finalizacao = this.finalizacao * Constante.PESO_3;
		int marcacao= this.marcacao * Constante.PESO_2;
		int passe = this.passe * Constante.PESO_1;
		
		int total = (finalizacao + marcacao + passe) / 3;
		
		if(total >= 180) return Constante.LENDARIO;
		else if(total >= 140 && total < 180) return Constante.PROFISSIONAL;
		else if(total >= 60 && total < 140) return Constante.SEMIPRO;
		else return Constante.INICIANTE;
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

	public void setFinalizacao(int finalizacao) throws Exception {
		if(finalizacao < 0) 
			throw new Exception("Sua estatística de finalização deve ser maior ou igual à zero!");
		
		if(finalizacao > 100) 
			throw new Exception("Sua estatística de finalização deve ser menor ou igual à 100!");
		
		this.finalizacao = finalizacao;
	}

	public int getMarcacao() {
		return marcacao;
	}

	public void setMarcacao(int marcacao) throws Exception {
		if(marcacao < 0) 
			throw new Exception("Sua estatística de marcação deve ser maior ou igual à zero!");
		
		if(marcacao > 100) 
			throw new Exception("Sua estatística de marcação deve ser menor ou igual à 100!");
		
		this.marcacao = marcacao;
	}

	public int getPasse() {
		return passe;
	}

	public void setPasse(int passe) throws Exception {
		if(passe < 0) 
			throw new Exception("Sua estatística de passe deve ser maior ou igual à zero!");
		
		if(passe > 100) 
			throw new Exception("Sua estatística de passe deve ser menor ou igual à 100!");
		
		this.passe = passe;
	}
	 
}
