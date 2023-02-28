package br.edu.infnet.esports.model.domain;

import br.edu.infnet.esports.model.auxiliar.Constante;
import br.edu.infnet.esports.model.exceptions.ValorLimiteUltrapassadoException;

public class CsGo extends Game {
	private float precisao;
	private float agressividade;
	private float tatica;

	public CsGo() {}
	
	public CsGo(String plataforma) {
		super("CS:GO", plataforma);
	}
	
	@Override
	public float calculaMediaEstatisticaGamer() {
		float precisao = this.precisao  * Constante.PESO_3;
		float agressividade= this.agressividade * Constante.PESO_2;
		float tatica = this.tatica * Constante.PESO_1;
		
		return (precisao + agressividade + tatica) / 3;
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
	public float getPrecisao() {
		return precisao;
	}

	public void setPrecisao(float precisao) throws ValorLimiteUltrapassadoException {
		if(precisao < 0) 
			throw new ValorLimiteUltrapassadoException("Sua estatística de precisão deve ser maior ou igual à zero!");
		
		if(precisao > 10) 
			throw new ValorLimiteUltrapassadoException("Sua estatística de precisão deve ser menor ou igual à 10!");
		
		this.precisao = precisao;
	}

	public float getAgressividade() {
		return agressividade;
	}

	public void setAgressividade(float agressividade) throws ValorLimiteUltrapassadoException {
		if(agressividade < 0) 
			throw new ValorLimiteUltrapassadoException("Sua estatística de agressividade deve ser maior ou igual à zero!");
		
		if(agressividade > 10) 
			throw new ValorLimiteUltrapassadoException("Sua estatística de agressividade deve ser menor ou igual à 10!");
		
		this.agressividade = agressividade;
	}

	public float getTatica() {
		return tatica;
	}

	public void setTatica(float tatica) throws ValorLimiteUltrapassadoException {
		if(tatica < 0) 
			throw new ValorLimiteUltrapassadoException("Sua estatística de tática deve ser maior ou igual à zero!");
		
		if(tatica > 10) 
			throw new ValorLimiteUltrapassadoException("Sua estatística de tática deve ser menor ou igual à 10!");
		
		this.tatica = tatica;
	}
}
