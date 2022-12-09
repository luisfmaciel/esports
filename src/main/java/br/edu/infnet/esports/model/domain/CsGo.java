package br.edu.infnet.esports.model.domain;

import br.edu.infnet.esports.model.auxiliar.Constante;

public class CsGo extends Game {

	private int precisao;
	private int agressividade;
	private int tatica;

	public CsGo(String plataforma, int precisao, int agressividade, int tatica) throws Exception {
		super("CS:GO", plataforma);
		
		if(precisao < 0) 
			throw new Exception("Sua estatística de precisão deve ser maior ou igual à zero!");
		
		if(precisao > 100) 
			throw new Exception("Sua estatística de precisão deve ser menor ou igual à 100!");
		
		if(agressividade < 0) 
			throw new Exception("Sua estatística de agressividade deve ser maior ou igual à zero!");
		
		if(agressividade > 100) 
			throw new Exception("Sua estatística de agressividade deve ser menor ou igual à 100!");
		
		if(tatica < 0) 
			throw new Exception("Sua estatística de tática deve ser maior ou igual à zero!");
		
		if(tatica > 100) 
			throw new Exception("Sua estatística de tática deve ser menor ou igual à 100!");
		
		this.precisao = precisao;
		this.agressividade = agressividade;
		this.tatica = tatica;
	}
	
	@Override
	public String calculaNivelGamer() {
		int precisao = this.precisao * Constante.PESO_3;
		int agressividade = this.agressividade * Constante.PESO_2;
		int tatica = this.tatica * Constante.PESO_1;
		
		int total = (precisao + agressividade + tatica) / 3;
		
		if(total >= 180) return Constante.LENDARIO;
		else if(total >= 140 && total < 180) return Constante.PROFISSIONAL;
		else if(total >= 60 && total < 140) return Constante.SEMIPRO;
		else return Constante.INICIANTE;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.precisao);
		sb.append(";");
		sb.append(this.agressividade);
		sb.append(";");
		sb.append(this.tatica);
		
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

	public int getTatica() {
		return tatica;
	}

	public void setTatica(int tatica) {
		this.tatica = tatica;
	}

}
