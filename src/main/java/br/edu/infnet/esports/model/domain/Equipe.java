package br.edu.infnet.esports.model.domain;

import java.util.ArrayList;
import java.util.List;

public class Equipe {

	private String nome;
	private Game game;
	private int limiteParticipantes;
	private String nivel;
	private String plataforma;
//	private String tipo;
	private List<Gamer> gamers = new ArrayList<Gamer>();
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Game getGame() {
		return game;
	}
	public void setGame(Game game) {
		this.game = game;
	}
	
	public int getLimiteParticipantes() {
		return limiteParticipantes;
	}
	public void setLimiteParticipantes(int limiteParticipantes) {
		this.limiteParticipantes = limiteParticipantes;
	}
	
	public List<Gamer> getGamers() {
		return gamers;
	}
	public void setGamers(Gamer gamer) throws Exception {		
		Game playerGame = gamer.getGames()
				.stream()
				.filter(game -> game.getNome().equalsIgnoreCase(this.game.getNome()))
				.findAny()
				.orElseThrow(() -> new Exception("Você não possui o game: " + this.game.getNome()));
		
		if(!playerGame.getPlataforma().equalsIgnoreCase(this.plataforma)) 
			throw new Exception("Essa equipe é só para jogadores da plataforma: " + this.plataforma.toUpperCase());
		
		if(!playerGame.getNivel().equalsIgnoreCase(this.nivel)) 
			throw new Exception("Essa equipe é para jogadores com o nível: " + this.nivel.toUpperCase());
		
		if(this.gamers.size() >= this.limiteParticipantes) 
			throw new Exception("A equipe " + this.nome + " já está completa\n@" + gamer.getUsername() + ", tente outra equipe ou crie a sua própria!");
		
		this.gamers.add(gamer);
	}
	
	public String getNivel() {
		return nivel;
	}
	public void setNivel(String nivel) {
		this.nivel = nivel;
	}
	
	public String getPlataforma() {
		return plataforma;
	}
	public void setPlataforma(String plataforma) {
		this.plataforma = plataforma;
	}
	
}
