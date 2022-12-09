package br.edu.infnet.esports.model.domain;

import br.edu.infnet.esports.model.auxiliar.Constante;

public class Dungeons extends Game {

	private int dano;
	private int sabedoria;
	private int velocidade;
	
	public Dungeons(String plataforma, int dano, int sabedoria, int velocidade) throws Exception {
		super("DUNGEONS", plataforma);
		
		if(dano < 0) 
			throw new Exception("Sua estatística de dano deve ser maior ou igual à zero!");
		
		if(dano > 100) 
			throw new Exception("Sua estatística de dano deve ser menor ou igual à 100!");
		
		
		if(sabedoria < 0) 
			throw new Exception("Sua estatística de sabedoria deve ser maior ou igual à zero!");
		
		if(sabedoria > 100) 
			throw new Exception("Sua estatística de dasabedoriano deve ser menor ou igual à 100!");
		
		
		if(velocidade < 0) 
			throw new Exception("Sua estatística de velocidade deve ser maior ou igual à zero!");
		
		if(velocidade > 100) 
			throw new Exception("Sua estatística de velocidade deve ser menor ou igual à 100!");
		
		this.dano = dano;
		this.sabedoria = sabedoria;
		this.velocidade = velocidade;
	}
	
	@Override
	public String calculaNivelGamer() {
		int dano = this.dano * Constante.PESO_3;
		int sabedoria = this.sabedoria * Constante.PESO_2;
		int velocidade = this.velocidade * Constante.PESO_1;
		
		int total = (dano + sabedoria + velocidade) / 3;
		
		if(total >= 180) return Constante.LENDARIO;
		else if(total >= 140 && total < 180) return Constante.PROFISSIONAL;
		else if(total >= 60 && total < 140) return Constante.SEMIPRO;
		else return Constante.INICIANTE;
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

	public void setDano(int dano) {
		this.dano = dano;
	}

	public int getSabedoria() {
		return sabedoria;
	}

	public void setSabedoria(int sabedoria) {
		this.sabedoria = sabedoria;
	}

	public int getVelocidade() {
		return velocidade;
	}

	public void setVelocidade(int velocidade) {
		this.velocidade = velocidade;
	}
	
}
