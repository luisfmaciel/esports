package br.edu.infnet.esports.model.domain;

import java.util.ArrayList;
import java.util.List;

import br.edu.infnet.esports.model.exceptions.EmailInvalidoException;

public class Gamer {
		
	private String nome;
	private String email;
	private String senha;
	private String username;
	private List<Game> games;
	
	public Gamer() {
	}
	
	public Gamer(String nome, String email, String senha) throws  EmailInvalidoException {
		this();
		this.nome = nome;
		this.setEmail(email);
		this.senha = senha;
	}
	
	public Gamer(String nome, String email, String senha, List<Game> games) throws  EmailInvalidoException {
		this(nome, email, senha);
		this.games = new ArrayList<Game>();
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
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) throws EmailInvalidoException {
		if(email.isBlank()) throw new EmailInvalidoException("E-mail inválido");

		String username = email.substring(0, email.indexOf("@"));
		String dominio = email.substring(email.indexOf("@")+1);
		
		if(!dominio.equalsIgnoreCase("esports.com")) throw new EmailInvalidoException("O domínio deve ser igual a \"esports.com\"");
		if(!email.contains("@") || username.isEmpty() || username.isBlank()) throw new EmailInvalidoException("E-mail inválido");
		
		setUsername(username);
		
		this.email = email;
	}
	
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
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
}
