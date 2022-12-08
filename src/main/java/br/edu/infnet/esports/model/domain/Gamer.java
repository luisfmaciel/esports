package br.edu.infnet.esports.model.domain;

import java.util.ArrayList;
import java.util.List;

public class Gamer {
	
	protected static List<Gamer> gamersTotal = new ArrayList<Gamer>();
	
	private String name;
	private String email;
	private String username;
	private List<Game> games = new ArrayList<Game>();
	private List<Equipe> equipes;
	
	public static List<Gamer> getGamersTotal() {
		return gamersTotal;
	}
	
	public static void setGamersTotal(Gamer gamer) throws Exception {
		for(Gamer player : getGamersTotal()) {
			if(player.getEmail().equalsIgnoreCase(gamer.getEmail())) throw new Exception("Usuário já existe");
		}
		gamersTotal.add(gamer);				
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) throws Exception {
		
		if(email.isBlank()) throw new Exception("E-mail inválido");

		String username = email.substring(0, email.indexOf("@"));
		String dominio = email.substring(email.indexOf("@")+1);
		
		if(!dominio.equalsIgnoreCase("esports.com")) throw new Exception("O domínio deve ser igual a \"esports.com\"");
		if(!email.contains("@") || username.isEmpty() || username.isBlank()) throw new Exception("E-mail inválido");
		
		setUsername(username);
		
		this.email = email;
	}
	
	public String getUsername() {
		return username;
	}
	private void setUsername(String username) {
		this.username = username;
	}
	
	public List<Game> getGames() {
		return games;
	}
	public void setGames(Game game) {
		this.games.add(game);
	}
	
	public List<Equipe> getEquipes() {
		return equipes;
	}
	public void setEquipes(List<Equipe> equipes) {
		this.equipes = equipes;
	}
	
}
