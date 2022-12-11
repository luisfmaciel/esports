package br.edu.infnet.esports.model.domain;

import br.edu.infnet.esports.model.auxiliar.Constante;

public abstract class Game {
	private String nome;
	private String plataforma;
	private String nivel = Constante.INICIANTE;
	private float mediaEstatistica;
	
	protected Game(String nome, String plataforma) {
		this.nome = nome;
		this.plataforma = plataforma;
	}
	
	public abstract float calculaMediaEstatisticaGamer();
	
	public String calculaNivelGamer(float media, int titulos) {
		if(media >= 18 || titulos >= 10) return Constante.LENDARIO;
		else if((media >= 14 && media < 18) || (titulos >= 6 && titulos < 10)) return Constante.PROFISSIONAL;
		else if((media >= 6 && media < 14)  || (titulos >= 3 && titulos < 6) ) return Constante.SEMIPRO;
		else return Constante.INICIANTE;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.nome);
		sb.append(";");
		sb.append(this.plataforma);
		sb.append(";");
		sb.append(this.nivel);
		sb.append(";");
		sb.append(this.getMediaEstatistica());
		sb.append(";");
		
		return sb.toString();	
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getPlataforma() {
		return plataforma;
	}
	
	public String getNivel() {
		return nivel;
	}
	public void setNivel(String nivel) {
		this.nivel = nivel;
	}

	public String getMediaEstatistica() {
		return String.format("%.2f", mediaEstatistica);
	}

	public void setMediaEstatistica(float mediaEstatistica) {
		this.mediaEstatistica = mediaEstatistica;
	}
	
}
