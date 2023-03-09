package br.edu.infnet.esports.model.domain;

import java.util.List;

public class Gamer extends Usuario {
		
	private List<Game> games;
	
	public Gamer() {
	}
	

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.games);
		sb.append(";");
			
		return super.toString() + sb.toString();	
	}
	
	public List<Game> getGames() {
		return games;
	}
	public void setGames(List<Game> games) {
		this.games = games;
	}
}
