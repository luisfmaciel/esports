package br.edu.infnet.esports.model.domain;

import java.util.List;

import br.edu.infnet.esports.model.exceptions.EquipeCompletaException;
import br.edu.infnet.esports.model.exceptions.GameNaoEncontradoException;
import br.edu.infnet.esports.model.exceptions.NivelDiferenteNivelException;
import br.edu.infnet.esports.model.exceptions.PlatformaDiferenteException;
import br.edu.infnet.esports.model.exceptions.ValorLimiteUltrapassadoException;

public class Equipe {

	private String nome;
	private int limiteParticipantes;
	private boolean multiPlataforma;
	private String nivel;
	private Game game;
	private List<Gamer> gamers;
	
	public Equipe(String nome, int limiteParticipantes, boolean multiPlataforma, String nivel, Game game) throws ValorLimiteUltrapassadoException {
		if(limiteParticipantes < 2) throw new ValorLimiteUltrapassadoException("Uma equipe deve ter no mínimo 2 gamers!");
		
		if(limiteParticipantes > 12) throw new ValorLimiteUltrapassadoException("Uma equipe deve ter no máximo 12 gamers!");
		
		this.nome = nome;
		this.limiteParticipantes = limiteParticipantes;
		this.setMultiPlataforma(multiPlataforma);
		this.nivel = nivel;
		this.game = game;
	}
	
	public void imprimir(){
		System.out.println("Equipe: " + this);
		System.out.println("Total de participantes: " + gamers.size());
		System.out.println("Gamers: ");
		for(Gamer gamer : gamers) {
			System.out.println("- @" + gamer.getUsername());
		}
	}
	
	public String obterLinha() {
		return this.getNome() 
				+ ";" 
				+ this.getGame().getNome() 
				+ ";" 
				+ (this.multiPlataforma ?  this.multiPlataforma : this.getGame().getPlataforma()) 
				+ ";" 
				+ this.getGame().getNivel() 
				+ ";" 
				+ this.limiteParticipantes
				+ ";"
				+ this.getGamers().size() 
				+ "\r\n";
	}
	
	public String toString() {
		return String.format("%s;%s;%s;%d;%s", 
					this.nome, 
					this.game.getNome(), 
					this.game.getPlataforma(), 
					this.limiteParticipantes, 
					this.nivel
				);	
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
	public void setGamers(List<Gamer> gamers) throws 
		GameNaoEncontradoException,
		EquipeCompletaException, 
		NivelDiferenteNivelException, 
		PlatformaDiferenteException 
	{		
		for(Gamer gamer : gamers) {
			Game playerGame = gamer.getGames()
					.stream()
					.filter(game -> game.getNome().equalsIgnoreCase(this.game.getNome()))
					.findAny()
					.orElseThrow(() -> new GameNaoEncontradoException("@" + gamer.getUsername() + ", você não possui o game: " + this.game.getNome()));
			
			if(!this.multiPlataforma) {
				if(!playerGame.getPlataforma().equalsIgnoreCase(this.game.getPlataforma())) 
					throw new PlatformaDiferenteException("Essa equipe é só para jogadores da plataforma: " + this.game.getPlataforma().toUpperCase());			
			}
			
			if(!playerGame.getNivel().equalsIgnoreCase(this.nivel)) 
				throw new NivelDiferenteNivelException("@" + gamer.getUsername() + ", essa equipe é só para jogadores com o nível: " + this.nivel.toUpperCase());
			
			if(gamers.size() >= this.limiteParticipantes) 
				throw new EquipeCompletaException("Essa equipe tem um limite de " + this.getLimiteParticipantes() + " participantes!\nTente outra equipe ou crie a sua própria!");
			
			this.gamers = gamers;
		}
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
