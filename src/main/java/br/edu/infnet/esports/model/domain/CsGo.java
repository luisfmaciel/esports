package br.edu.infnet.esports.model.domain;

import br.edu.infnet.esports.model.auxiliar.Constante;

public class CsGo extends Game {

	private int precisao;
	private int agressividade;
	private int tatico;

	public CsGo(String plataforma, int precisao, int agressividade, int tatico) {
		super("CS:GO", plataforma);
		
		this.precisao = precisao;
		this.agressividade = agressividade;
		this.tatico = tatico;
	}
	
	@Override
	public String calculaNivelGamer() {
		int precisao = this.precisao * Constante.PESO_3;
		int agressividade = this.agressividade * Constante.PESO_2;
		int tatico = this.tatico * Constante.PESO_1;
		
		int total = (precisao + agressividade + tatico) / 3;
		
		if(total >= 180) return "lendário";
		else if(total >= 140 && total < 180) return "profissional";
		else if(total >= 60 && total < 140) return "semipro";
		else return "iniciante";
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.precisao);
		sb.append(";");
		sb.append(this.agressividade);
		sb.append(";");
		sb.append(this.tatico);
		
		return super.toString() + sb.toString();	
	}
	public int getPrecisao() {
		return precisao;
	}

	public void setPrecisao(int precisao) {
		this.precisao = precisao;
	}

	public int getAgressividade() {
		return agressividade;
	}

	public void setAgressividade(int agressividade) {
		this.agressividade = agressividade;
	}

	public int getTatico() {
		return tatico;
	}

	public void setTatico(int tatico) {
		this.tatico = tatico;
	}

}
