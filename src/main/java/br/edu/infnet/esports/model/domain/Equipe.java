package br.edu.infnet.esports.model.domain;

import java.util.ArrayList;
import java.util.List;

import br.edu.infnet.esports.model.exceptions.ValorLimiteUltrapassadoException;

public class Equipe {

	private String nome;
	private int limiteParticipantes;
	private boolean multiPlataforma;
	private String nivel;
	private Game game;
	private List<Gamer> gamers = new ArrayList<Gamer>();
	
	public Equipe(String nome, int limiteParticipantes, boolean multiPlataforma, String nivel) throws ValorLimiteUltrapassadoException, Exception {
		if(limiteParticipantes < 2) throw new ValorLimiteUltrapassadoException("Uma equipe deve ter no mínimo 2 gamers!");
		
		if(limiteParticipantes > 12) throw new ValorLimiteUltrapassadoException("Uma equipe deve ter no máximo 12 gamers!");
		
		this.nome = nome;
		this.limiteParticipantes = limiteParticipantes;
		this.setMultiPlataforma(multiPlataforma);
		this.nivel = nivel;
	}
	
	public void imprimir(){
		System.out.println("Equipe: " + this);
		System.out.println("Total de participantes: " + gamers.size());
		System.out.println("Gamers: ");
		for(Gamer gamer : gamers) {
			System.out.println("- @" + gamer.getUsername());
		}
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.nome);
		sb.append(";");
		sb.append(this.game.getNome());
		sb.append(";");
		sb.append(this.game.getPlataforma());
		sb.append(";");
		sb.append(this.limiteParticipantes);
		sb.append(";");
		sb.append(this.nivel);
		
		return sb.toString();	
	}
	
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
		
		if(!this.multiPlataforma) {
			if(!playerGame.getPlataforma().equalsIgnoreCase(this.game.getPlataforma())) 
				throw new Exception("Essa equipe é só para jogadores da plataforma: " + this.game.getPlataforma().toUpperCase());			
		}
		
		if(!playerGame.getNivel().equalsIgnoreCase(this.nivel)) 
			throw new Exception("@" + gamer.getUsername() + ", essa equipe é só para jogadores com o nível: " + this.nivel.toUpperCase());
		
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

	public boolean isMultiPlataforma() {
		return multiPlataforma;
	}

	public void setMultiPlataforma(boolean multiPlataforma) {
		this.multiPlataforma = multiPlataforma;
	}
}
