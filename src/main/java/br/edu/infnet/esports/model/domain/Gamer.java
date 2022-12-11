package br.edu.infnet.esports.model.domain;

import java.util.ArrayList;
import java.util.List;

import br.edu.infnet.esports.model.exceptions.EmailInvalidoException;
import br.edu.infnet.esports.model.exceptions.GameNaoEncontradoException;
import br.edu.infnet.esports.model.exceptions.ValorLimiteUltrapassadoException;

public class Gamer {
		
	private String nome;
	private String email;
	private String username;
	private int titulos;
	private List<Game> games = new ArrayList<Game>();
	
	public Gamer(String nome, String email, int titulos, List<Game> games) throws ValorLimiteUltrapassadoException, EmailInvalidoException {
		if(titulos < 0) throw new ValorLimiteUltrapassadoException("O número de titulos deve ser maior que 0!");
		
		this.nome = nome;
		this.setEmail(email);
		this.titulos = titulos;
		this.games = games;
	}
	
	public Game encontraGame(String nomeGame) throws GameNaoEncontradoException {
		return this.games
				.stream()
				.filter(game -> game.getNome().equalsIgnoreCase(nomeGame))
				.findFirst()
				.orElseThrow(() -> new GameNaoEncontradoException("@" + this.username + ", você não possui o game: " + nomeGame));
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.nome);
		sb.append(";");
		sb.append(this.email);
		sb.append(";");
		sb.append(this.username);
		sb.append(";");
		sb.append(this.games);
	
		return sb.toString();	
	}
	
	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}
	private void setEmail(String email) throws EmailInvalidoException {
		
		if(email.isBlank()) throw new EmailInvalidoException("E-mail inválido");

		String username = email.substring(0, email.indexOf("@"));
		String dominio = email.substring(email.indexOf("@")+1);
		
		if(!dominio.equalsIgnoreCase("esports.com")) throw new EmailInvalidoException("O domínio deve ser igual a \"esports.com\"");
		if(!email.contains("@") || username.isEmpty() || username.isBlank()) throw new EmailInvalidoException("E-mail inválido");
		
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
	public void setGames(List<Game> games) {
		this.games = games;
	}

	public int getTitulos() {
		return titulos;
	}

}
