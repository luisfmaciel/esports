package br.edu.infnet.esports.model.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

import br.edu.infnet.esports.model.auxiliar.Constante;
import br.edu.infnet.esports.model.exceptions.CampoVazioException;
import br.edu.infnet.esports.model.exceptions.ValorLimiteUltrapassadoException;

@Entity
@Table(name = "TDungeons")
public class Dungeons extends Game {
	
	private float dano;
	private float sabedoria;
	private float velocidade;
	
	public Dungeons() {}
	
	public Dungeons(String plataforma) {
		super("DUNGEONS", plataforma);
	}
	
	@Override
	public float calculaMediaEstatisticaGamer() {
		float dano = this.dano * Constante.PESO_3;
		float sabedoria = this.sabedoria * Constante.PESO_2;
		float velocidade = this.velocidade * Constante.PESO_1;
		
		return (dano + sabedoria + velocidade) / 3;
	}
		
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.dano);
		sb.append(";");
		sb.append(this.sabedoria);
		sb.append(";");
		sb.append(this.velocidade);
		
		return super.toString() + sb.toString();	
	}
	
	public float getDano() {
		return dano;
	}

	public void setDano(String dano) throws ValorLimiteUltrapassadoException, CampoVazioException {
		Float floatDano;
		try {
			floatDano = Float.parseFloat(dano);
		} catch (Exception e) {
			throw new CampoVazioException("O preenchimento do campo Dano está inválido");
		} 
		if(floatDano < 0) 
			throw new ValorLimiteUltrapassadoException("Sua estatística de dano deve ser maior ou igual à zero!");
		
		if(floatDano > 10) 
			throw new ValorLimiteUltrapassadoException("Sua estatística de dano deve ser menor ou igual à 10!");
		this.dano = floatDano;
	}

	public float getSabedoria() {
		return sabedoria;
	}

	public void setSabedoria(String sabedoria) throws ValorLimiteUltrapassadoException, CampoVazioException {
		Float floatSabedoria;
		try {
			floatSabedoria = Float.parseFloat(sabedoria);
		} catch (Exception e) {
			throw new CampoVazioException("O preenchimento do campo Dano está inválido");
		} 
		
		if(floatSabedoria < 0) 
			throw new ValorLimiteUltrapassadoException("Sua estatística de sabedoria deve ser maior ou igual à zero!");
		
		if(floatSabedoria > 10) 
			throw new ValorLimiteUltrapassadoException("Sua estatística de dasabedoriano deve ser menor ou igual à 10!");
		
		this.sabedoria = floatSabedoria;
	}

	public float getVelocidade() {
		return velocidade;
	}

	public void setVelocidade(String velocidade) throws ValorLimiteUltrapassadoException, CampoVazioException {
		Float floatVelocidade;
		try {
			floatVelocidade = Float.parseFloat(velocidade);
		} catch (Exception e) {
			throw new CampoVazioException("O preenchimento do campo Dano está inválido");
		} 
		if(floatVelocidade < 0) 
			throw new ValorLimiteUltrapassadoException("Sua estatística de velocidade deve ser maior ou igual à zero!");
		
		if(floatVelocidade > 10) 
			throw new ValorLimiteUltrapassadoException("Sua estatística de velocidade deve ser menor ou igual à 10!");
		
		this.velocidade = floatVelocidade;
	}
}
