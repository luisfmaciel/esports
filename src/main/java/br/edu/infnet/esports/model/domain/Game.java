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
	
	public String calculaNivelGamer(int titulos) {
		if(mediaEstatistica >= 18 || titulos >= 10) return Constante.LENDARIO;
		else if((mediaEstatistica >= 14 && mediaEstatistica < 18) || (titulos >= 6 && titulos < 10)) return Constante.PROFISSIONAL;
		else if((mediaEstatistica >= 6 && mediaEstatistica < 14)  || (titulos >= 3 && titulos < 6) ) return Constante.SEMIPRO;
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
		sb.append(String.format("%.2f", this.getMediaEstatistica()));
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

	public float getMediaEstatistica() {
		return mediaEstatistica;
	}

	public void setMediaEstatistica(float mediaEstatistica) {
		this.mediaEstatistica = mediaEstatistica;
	}
	
}
