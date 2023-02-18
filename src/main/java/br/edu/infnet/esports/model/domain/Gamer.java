package br.edu.infnet.esports.model.domain;

import java.util.List;

public class Gamer extends Usuario {
		
	private String plataformaPrincipal;
	private String generoPrincipal;
	private int totalTitulos;
	private List<Game> games;
	
	public Gamer() {
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.plataformaPrincipal);
		sb.append(";");
		sb.append(this.generoPrincipal);
		sb.append(";");
		sb.append(this.totalTitulos);
		sb.append(";");
		sb.append(this.games);
	
		return sb.toString();	
	}
	
	public List<Game> getGames() {
		return games;
	}
	public void setGames(List<Game> games) {
		this.games = games;
	}

	public String getPlataformaPrincipal() {
		return plataformaPrincipal;
	}

	public void setPlataformaPrincipal(String plataformaPrincipal) {
		this.plataformaPrincipal = plataformaPrincipal;
	}

	public String getGeneroPrincipal() {
		return generoPrincipal;
	}

	public void setGeneroPrincipal(String generoPrincipal) {
		this.generoPrincipal = generoPrincipal;
	}

	public int getTotalTitulos() {
		return totalTitulos;
	}

	public void setTotalTitulos(int totalTitulos) {
		this.totalTitulos = totalTitulos;
	}
	
	
}
