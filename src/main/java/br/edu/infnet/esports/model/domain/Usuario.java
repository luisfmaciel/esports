package br.edu.infnet.esports.model.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.edu.infnet.esports.model.exceptions.CampoVazioException;
import br.edu.infnet.esports.model.exceptions.EmailInvalidoException;

@Entity
@Table(name = "TUsuario")
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String email;
	private String username;
	private String senha;
	private String perfil;
	private boolean admin;
	@OneToMany(cascade = CascadeType.REMOVE, orphanRemoval = true)
	@JoinColumn(name = "idUsuario")
	private List<Gamer> gamers;
	@OneToMany(cascade = CascadeType.REMOVE, orphanRemoval = true)
	@JoinColumn(name = "idUsuario")
	private List<Game> games;	
	@OneToMany(cascade = CascadeType.REMOVE, orphanRemoval = true)
	@JoinColumn(name = "idUsuario")
	private List<Equipe> equipes;
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "idEndereco")
	private Endereco endereco;
	
	public Usuario() {}

	public Usuario(String nome, String email, String senha, String perfil) throws EmailInvalidoException, CampoVazioException {
		this.setNome(nome);
		this.setEmail(email);
		this.setSenha(senha);
		this.setPerfil(perfil);
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.nome);
		sb.append(";");
		sb.append(this.email);
		sb.append(";");
		sb.append(this.username);
		sb.append(";");
		sb.append(this.senha);
		sb.append(";");
		sb.append(this.perfil);
		sb.append(";");
	
		return sb.toString();	
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) throws CampoVazioException {
		if(nome.isBlank() || nome.isEmpty()) throw new CampoVazioException("O preenchimento do campo Nome está inválido");
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) throws EmailInvalidoException, CampoVazioException {
		if(email.isBlank() || email.isEmpty()) throw new CampoVazioException("O preenchimento do campo E-mail está inválido");

		String username = email.substring(0, email.indexOf("@"));
		String dominio = email.substring(email.indexOf("@")+1);
		
		if(!"esports.com".equalsIgnoreCase(dominio)) throw new EmailInvalidoException("O domínio deve ser igual a \"esports.com\"");
		if(!email.contains("@") || username.isEmpty() || username.isBlank()) throw new EmailInvalidoException("E-mail inválido");
		
		setUsername(username);
		
		this.email = email;
	}
	
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) throws CampoVazioException {
		if(senha.isBlank() || senha.isEmpty()) throw new CampoVazioException("O preenchimento do campo Senha está inválido");
		this.senha = senha;
	}
	
	public String getUsername() {
		return username;
	}
	private void setUsername(String username) {
		this.username = username;
	}

	public String getPerfil() {
		return perfil;
	}

	public void setPerfil(String perfil) throws CampoVazioException {
		if(perfil.isBlank() || perfil.isEmpty()) throw new CampoVazioException("O preenchimento do campo Perfil está inválido");
		this.perfil = perfil;
	}

	public List<Gamer> getGamers() {
		return gamers;
	}

	public void setGamers(List<Gamer> gamers) {
		this.gamers = gamers;
	}
	public List<Game> getGames() {
		return games;
	}
	
	public void setGames(List<Game> games) {
		this.games = games;
	}
	public List<Equipe> getEquipes() {
		return equipes;
	}

	public void setEquipes(List<Equipe> equipes) {
		this.equipes = equipes;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
}
