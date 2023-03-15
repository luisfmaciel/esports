package br.edu.infnet.esports.model.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.edu.infnet.esports.model.auxiliar.Constante;
import br.edu.infnet.esports.model.exceptions.CampoVazioException;
import br.edu.infnet.esports.model.exceptions.ValorLimiteUltrapassadoException;

@Entity
@Table(name = "TGame")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Game {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String plataforma;
	private String nivel;
	private int titulos;
	private float mediaEstatistica;
	@ManyToOne
	@JoinColumn(name = "idGamer")
	private Gamer gamer;
	@OneToMany
	@JoinColumn(name = "idGame")
	private List<Equipe> equipes;	
	
	public Game() {}
	
	protected Game(String nome, String plataforma) {
		this.nome = nome;
		this.plataforma = plataforma;
		this.nivel = Constante.INICIANTE;
	}
	
	public abstract float calculaMediaEstatisticaGamer();
	
	public String identificaNivelGamer() {
		if(this.mediaEstatistica >= 18 || this.titulos >= 10) return Constante.LENDARIO;
		else if((this.mediaEstatistica >= 14 && this.mediaEstatistica < 18) || (this.titulos >= 6 && this.titulos < 10)) return Constante.PROFISSIONAL;
		else if((this.mediaEstatistica >= 6 && this.mediaEstatistica < 14)  || (this.titulos >= 3 && this.titulos < 6) ) return Constante.SEMIPRO;
		else return Constante.INICIANTE;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.nome);
		sb.append(";");
		sb.append(this.plataforma);
		sb.append(";");
		sb.append(this.nivel);
		sb.append(";");
		sb.append(this.titulos);
		sb.append(";");
		sb.append(this.getMediaEstatistica());
		sb.append(";");
		sb.append(this.gamer);
		sb.append(";");
		
		return sb.toString();	
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) throws CampoVazioException {
		if(nome.isBlank() || nome.isEmpty()) throw new CampoVazioException("O preenchimento do campo Nome está inválido");
		this.nome = nome;
	}
	
	public String getPlataforma() {
		return plataforma;
	}
	public void setPlataforma(String plataforma) throws CampoVazioException {
		if(plataforma.isBlank() || plataforma.isEmpty()) throw new CampoVazioException("O preenchimento do campo Plataforma está inválido");
		this.plataforma = plataforma;
	}
	
	public String getNivel() {
		return nivel;
	}
	public void setNivel(String nivel) throws CampoVazioException {
		if(nivel.isBlank() || nivel.isEmpty()) throw new CampoVazioException("O preenchimento do campo Nível está inválido");
		this.nivel = nivel;
	}

	public float getMediaEstatistica() {
		return mediaEstatistica;
	}

	public void setMediaEstatistica(float mediaEstatistica) {
		this.mediaEstatistica = mediaEstatistica;
	}

	public int getTitulos() {
		return titulos;
	}

	public void setTitulos(String titulos) throws ValorLimiteUltrapassadoException, CampoVazioException {
		Integer intTitulos;
		try {
			intTitulos = Integer.parseInt(titulos);
		} catch (Exception e) {
			throw new CampoVazioException("O preenchimento do campo Títulos está inválido");
		} 
		
		if(intTitulos < 0) throw new ValorLimiteUltrapassadoException("O número de titulos deve ser maior que 0!");
		this.titulos = intTitulos;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Gamer getGamer() {
		return gamer;
	}

	public void setGamer(Gamer gamer) throws CampoVazioException {
		if(gamer == null) throw new CampoVazioException("O preenchimento do campo Gamer está inválido");
		this.gamer = gamer;
	}

	public List<Equipe> getEquipes() {
		return equipes;
	}

	public void setEquipes(List<Equipe> equipes) {
		this.equipes = equipes;
	}
	
}
