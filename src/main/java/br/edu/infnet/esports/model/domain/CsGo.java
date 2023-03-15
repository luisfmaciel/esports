package br.edu.infnet.esports.model.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

import br.edu.infnet.esports.model.auxiliar.Constante;
import br.edu.infnet.esports.model.exceptions.CampoVazioException;
import br.edu.infnet.esports.model.exceptions.ValorLimiteUltrapassadoException;

@Entity
@Table(name = "TCsgo")
public class CsGo extends Game {
	
	private float precisao;
	private float agressividade;
	private float tatica;

	public CsGo() {}
	
	public CsGo(String plataforma) {
		super("CSGO", plataforma);
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

	public void setPrecisao(String precisao) throws ValorLimiteUltrapassadoException, CampoVazioException {
		Float floatPrecisao;
		try {
			floatPrecisao = Float.parseFloat(precisao);
		} catch (Exception e) {
			throw new CampoVazioException("O preenchimento do campo Dano está inválido");
		} 
		
		if(floatPrecisao < 0) 
			throw new ValorLimiteUltrapassadoException("Sua estatística de precisão deve ser maior ou igual à zero!");
		
		if(floatPrecisao > 10) 
			throw new ValorLimiteUltrapassadoException("Sua estatística de precisão deve ser menor ou igual à 10!");
		
		this.precisao = floatPrecisao;
	}

	public float getAgressividade() {
		return agressividade;
	}

	public void setAgressividade(String agressividade) throws ValorLimiteUltrapassadoException, CampoVazioException {
		Float floatAgressividade;
		try {
			floatAgressividade = Float.parseFloat(agressividade);
		} catch (Exception e) {
			throw new CampoVazioException("O preenchimento do campo Dano está inválido");
		} 
		if(floatAgressividade < 0) 
			throw new ValorLimiteUltrapassadoException("Sua estatística de agressividade deve ser maior ou igual à zero!");
		
		if(floatAgressividade > 10) 
			throw new ValorLimiteUltrapassadoException("Sua estatística de agressividade deve ser menor ou igual à 10!");
		
		this.agressividade = floatAgressividade;
	}

	public float getTatica() {
		return tatica;
	}

	public void setTatica(String tatica) throws ValorLimiteUltrapassadoException, CampoVazioException {
		Float floatTatica;
		try {
			floatTatica = Float.parseFloat(tatica);
		} catch (Exception e) {
			throw new CampoVazioException("O preenchimento do campo Dano está inválido");
		}
		if(floatTatica < 0) 
			throw new ValorLimiteUltrapassadoException("Sua estatística de tática deve ser maior ou igual à zero!");
		
		if(floatTatica > 10) 
			throw new ValorLimiteUltrapassadoException("Sua estatística de tática deve ser menor ou igual à 10!");
		
		this.tatica = floatTatica;
	}
}
