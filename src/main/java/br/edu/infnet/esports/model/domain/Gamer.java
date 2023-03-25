package br.edu.infnet.esports.model.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.edu.infnet.esports.model.exceptions.CampoVazioException;
import br.edu.infnet.esports.model.exceptions.EmailInvalidoException;

@Entity
@Table(name = "TGamer")
public class Gamer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String email;
	private String username;
	private String perfil;
	@ManyToOne
	@JoinColumn(name = "idUsuario")
	private Usuario usuario;
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE, orphanRemoval = true)
	@JoinColumn(name = "idGamer")
	private List<Game> games;
	@ManyToMany(mappedBy = "gamers")
	private List<Equipe> equipes;
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "idEndereco")
	private Endereco endereco;

	public Gamer() {
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.games);
		sb.append(";");

		return super.toString() + sb.toString();
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
		if(email.isBlank() || email.isEmpty()) throw new CampoVazioException("O preenchimento do campo Email está inválido");

		String username = email.substring(0, email.indexOf("@"));
		String dominio = email.substring(email.indexOf("@") + 1);

		if (!dominio.equalsIgnoreCase("esports.com"))
			throw new EmailInvalidoException("O domínio deve ser igual a \"esports.com\"");
		if (!email.contains("@") || username.isEmpty() || username.isBlank())
			throw new EmailInvalidoException("E-mail inválido");

		setUsername(username);

		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
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

	public String getPerfil() {
		return perfil;
	}

	public void setPerfil(String perfil) throws CampoVazioException {
		if(perfil.isBlank() || perfil.isEmpty()) throw new CampoVazioException("O preenchimento do campo Perfil está inválido");
		this.perfil = perfil;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

}
