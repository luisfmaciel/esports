package br.edu.infnet.esports.model.domain;

import java.util.ArrayList;
import java.util.List;

public class Gamer {
	
	private static List<Gamer> gamersTotal = new ArrayList<Gamer>();
	
	private String nome;
	private String email;
	private String username;
	private Equipe equipe;
	private List<Game> games = new ArrayList<Game>();
	
	
	public Gamer(String nome) {
		this.nome = nome;
	}
	
	public Game encontraGame(String nomeGame) throws Exception {
		return this.games
				.stream()
				.filter(game -> game.getNome().equalsIgnoreCase(nomeGame))
				.findFirst()
				.orElseThrow(() -> new Exception("Você não possui o game: " + nomeGame));
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.nome);
		sb.append(";");
		sb.append(this.email);
		sb.append(";");
		sb.append(this.username);
		sb.append(";");
		sb.append(this.equipe.getNome());
	
		return sb.toString();	
	}
	
	public static List<Gamer> getGamersTotal() {
		return gamersTotal;
	}
	
	public static void setGamersTotal(Gamer gamer) throws Exception {
		for(Gamer player : getGamersTotal()) {
			if(player.getEmail().equalsIgnoreCase(gamer.getEmail())) throw new Exception("Usuário já existe");
		}
		gamersTotal.add(gamer);				
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
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

	public Equipe getEquipe() {
		return equipe;
	}

	public void setEquipe(Equipe equipe) {
		this.equipe = equipe;
	}
	
}
