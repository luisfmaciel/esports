package br.edu.infnet.esports.model.domain;

public class Game {
	private String nome;
	private String plataforma;
	private String nivel;
	
	protected Game(String nome) {
		this.nome = nome;
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
		
		return sb.toString();	
	}
	
	public String getNome() {
		return nome;
	}
//	protected void setNome(String nome) {
//		this.nome = nome;
//	}
	
	public String getPlataforma() {
		return plataforma;
	}
	public void setPlataforma(String plataforma) {
		this.plataforma = plataforma;
	}
	
	public String getNivel() {
		return nivel;
	}
	public void setNivel(String nivel) {
		this.nivel = nivel;
	}
	
}
