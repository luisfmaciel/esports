package br.edu.infnet.esports.model.domain;

import br.edu.infnet.esports.model.auxiliar.Constante;
import br.edu.infnet.esports.model.exceptions.ValorLimiteUltrapassadoException;

public class Dungeons extends Game {

	private float dano;
	private float sabedoria;
	private float velocidade;
	
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

	public void setDano(float dano) throws ValorLimiteUltrapassadoException {
		if(dano < 0) 
			throw new ValorLimiteUltrapassadoException("Sua estatística de dano deve ser maior ou igual à zero!");
		
		if(dano > 10) 
			throw new ValorLimiteUltrapassadoException("Sua estatística de dano deve ser menor ou igual à 10!");
		this.dano = dano;
	}

	public float getSabedoria() {
		return sabedoria;
	}

	public void setSabedoria(float sabedoria) throws ValorLimiteUltrapassadoException {
		if(sabedoria < 0) 
			throw new ValorLimiteUltrapassadoException("Sua estatística de sabedoria deve ser maior ou igual à zero!");
		
		if(sabedoria > 10) 
			throw new ValorLimiteUltrapassadoException("Sua estatística de dasabedoriano deve ser menor ou igual à 10!");
		
		this.sabedoria = sabedoria;
	}

	public float getVelocidade() {
		return velocidade;
	}

	public void setVelocidade(float velocidade) throws ValorLimiteUltrapassadoException {
		if(velocidade < 0) 
			throw new ValorLimiteUltrapassadoException("Sua estatística de velocidade deve ser maior ou igual à zero!");
		
		if(velocidade > 10) 
			throw new ValorLimiteUltrapassadoException("Sua estatística de velocidade deve ser menor ou igual à 10!");
		
		this.velocidade = velocidade;
	}	
}
