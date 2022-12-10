package br.edu.infnet.esports.model.domain;

import br.edu.infnet.esports.model.auxiliar.Constante;

public class CsGo extends Game {

	private int precisao;
	private int agressividade;
	private int tatica;

	public CsGo(String plataforma) throws Exception {
		super("CS:GO", plataforma);
	}
	
	@Override
	public float calculaMediaEstatisticaGamer() {
		int finalizacao = this.precisao  * Constante.PESO_3;
		int marcacao= this.agressividade * Constante.PESO_2;
		int passe = this.tatica * Constante.PESO_1;
		
		return (finalizacao + marcacao + passe) / 3;
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

	public void setPrecisao(int precisao) throws Exception {
		if(precisao < 0) 
			throw new Exception("Sua estatística de precisão deve ser maior ou igual à zero!");
		
		if(precisao > 100) 
			throw new Exception("Sua estatística de precisão deve ser menor ou igual à 100!");
		
		this.precisao = precisao;
	}

	public int getAgressividade() {
		return agressividade;
	}

	public void setAgressividade(int agressividade) throws Exception {
		if(agressividade < 0) 
			throw new Exception("Sua estatística de agressividade deve ser maior ou igual à zero!");
		
		if(agressividade > 100) 
			throw new Exception("Sua estatística de agressividade deve ser menor ou igual à 100!");
		
		this.agressividade = agressividade;
	}

	public int getTatica() {
		return tatica;
	}

	public void setTatica(int tatica) throws Exception {
		if(tatica < 0) 
			throw new Exception("Sua estatística de tática deve ser maior ou igual à zero!");
		
		if(tatica > 100) 
			throw new Exception("Sua estatística de tática deve ser menor ou igual à 100!");
		
		this.tatica = tatica;
	}

}
