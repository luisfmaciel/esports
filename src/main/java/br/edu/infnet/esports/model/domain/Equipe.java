package br.edu.infnet.esports.model.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.edu.infnet.esports.model.exceptions.EquipeCompletaException;
import br.edu.infnet.esports.model.exceptions.GameNaoEncontradoException;
import br.edu.infnet.esports.model.exceptions.NivelDiferenteException;
import br.edu.infnet.esports.model.exceptions.PlatformaDiferenteException;
import br.edu.infnet.esports.model.exceptions.ValorLimiteUltrapassadoException;

@Entity
@Table(name = "TEquipe")
public class Equipe {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private int limiteParticipantes;
	private boolean multiPlataforma;
	private String nivel;
	@ManyToOne
	@JoinColumn(name = "idGame")
	private Game game;
	@ManyToMany
	private List<Gamer> gamers = new ArrayList<Gamer>();

	public Equipe() {
	}

	public Equipe(String nome, int limiteParticipantes, boolean multiPlataforma, String nivel)
			throws ValorLimiteUltrapassadoException {
		if (limiteParticipantes < 2)
			throw new ValorLimiteUltrapassadoException("Uma equipe deve ter no mínimo 2 gamers!");

		if (limiteParticipantes > 12)
			throw new ValorLimiteUltrapassadoException("Uma equipe deve ter no máximo 12 gamers!");

		this.nome = nome;
		this.limiteParticipantes = limiteParticipantes;
		this.setMultiPlataforma(multiPlataforma);
		this.nivel = nivel;
	}

	public void imprimir() {
		System.out.println("Equipe: " + this);
		System.out.println("Total de participantes: " + gamers.size());
		System.out.println("Gamers: ");
		for (Gamer gamer : gamers) {
			System.out.println("- @" + gamer.getUsername());
		}
	}

	public String obterLinha() {
		return this.getNome() + ";" + this.getGame().getNome() + ";"
				+ (this.multiPlataforma ? "Multiplataforma" : this.getGame().getPlataforma()) + ";"
				+ this.getGame().getNivel() + ";" + this.limiteParticipantes + ";" + this.getGamers().size() + "\r\n";
	}

	public String toString() {
		return String.format("%s;%s;%s;%d;%s", this.nome, this.game.getNome(), this.game.getPlataforma(),
				this.limiteParticipantes, this.nivel);
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

	public void setGamers(Gamer gamer) throws GameNaoEncontradoException, EquipeCompletaException,
			NivelDiferenteException, PlatformaDiferenteException {

		Game playerGame = gamer.getGames().stream().filter(game -> game.getNome().equalsIgnoreCase(this.game.getNome()))
				.findAny().orElseThrow(() -> new GameNaoEncontradoException(
						"@" + gamer.getUsername() + ", você não possui o game: " + this.game.getNome()));

		if (!this.multiPlataforma) {
			if (!playerGame.getPlataforma().equalsIgnoreCase(this.game.getPlataforma()))
				throw new PlatformaDiferenteException(
						"Essa equipe é só para jogadores da plataforma: " + this.game.getPlataforma().toUpperCase());
		}

		if (!playerGame.getNivel().equalsIgnoreCase(this.nivel))
			throw new NivelDiferenteException("@" + gamer.getUsername() + ", a equipe " + this.nome
					+ " é só para jogadores com o nível: " + this.nivel.toUpperCase());

		if (gamers.size() >= this.limiteParticipantes)
			throw new EquipeCompletaException("Essa equipe tem um limite de " + this.getLimiteParticipantes()
					+ " participantes!\nTente outra equipe ou crie a sua própria!");

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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}
