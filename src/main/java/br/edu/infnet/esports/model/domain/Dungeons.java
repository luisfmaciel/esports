package br.edu.infnet.esports.model.domain;

import br.edu.infnet.esports.model.auxiliar.Constante;

public class Dungeons extends Game {

	private int dano;
	private int sabedoria;
	private int velocidade;
	
	public Dungeons(String plataforma) throws Exception {
		super("DUNGEONS", plataforma);
	}
	
	@Override
	public float calculaMediaEstatisticaGamer() {
		int finalizacao = this.dano * Constante.PESO_3;
		int marcacao= this.sabedoria * Constante.PESO_2;
		int passe = this.velocidade * Constante.PESO_1;
		
		return (finalizacao + marcacao + passe) / 3;
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
	
	public int getDano() {
		return dano;
	}

	public void setDano(int dano) throws Exception {
		if(dano < 0) 
			throw new Exception("Sua estatística de dano deve ser maior ou igual à zero!");
		
		if(dano > 100) 
			throw new Exception("Sua estatística de dano deve ser menor ou igual à 100!");
		this.dano = dano;
	}

	public int getSabedoria() {
		return sabedoria;
	}

	public void setSabedoria(int sabedoria) throws Exception {
		if(sabedoria < 0) 
			throw new Exception("Sua estatística de sabedoria deve ser maior ou igual à zero!");
		
		if(sabedoria > 100) 
			throw new Exception("Sua estatística de dasabedoriano deve ser menor ou igual à 100!");
		
		this.sabedoria = sabedoria;
	}

	public int getVelocidade() {
		return velocidade;
	}

	public void setVelocidade(int velocidade) throws Exception {
		if(velocidade < 0) 
			throw new Exception("Sua estatística de velocidade deve ser maior ou igual à zero!");
		
		if(velocidade > 100) 
			throw new Exception("Sua estatística de velocidade deve ser menor ou igual à 100!");
		
		this.velocidade = velocidade;
	}
	
}
