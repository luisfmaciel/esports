package br.edu.infnet.esports.model.domain;

import br.edu.infnet.esports.model.auxiliar.Constante;
import br.edu.infnet.esports.model.exceptions.ValorLimiteUltrapassadoException;

public abstract class Game {
	private Integer id;
	private String nome;
	private String plataforma;
	private String nivel;
	private int titulos;
	private float mediaEstatistica;
	
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
		sb.append(String.format("%.2f", this.getMediaEstatistica()));
		sb.append(";");
		
		return sb.toString();	
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getPlataforma() {
		return plataforma;
	}
	
	public String getNivel() {
		return nivel;
	}
	public void setNivel(String nivel) {
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

	public void setTitulos(int titulos) throws ValorLimiteUltrapassadoException {
		if(titulos < 0) throw new ValorLimiteUltrapassadoException("O número de titulos deve ser maior que 0!");
		this.titulos = titulos;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
}
