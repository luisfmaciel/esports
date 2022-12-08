package br.edu.infnet.esports.model.domain;

import br.edu.infnet.esports.model.auxiliar.Constante;

public class Dungeons extends Game {

	private int dano;
	private int sabedoria;
	private int velocidade;
	
	public Dungeons() {
		super("DUNGEONS");
	}
	
	@Override
	public String calculaNivelGamer() {
		int dano = this.dano * Constante.PESO_3;
		int sabedoria = this.sabedoria * Constante.PESO_2;
		int velocidade = this.velocidade * Constante.PESO_1;
		
		int total = (dano + sabedoria + velocidade) / 3;
		
		if(total >= 180) return "lendário";
		else if(total >= 140 && total < 180) return "profissional";
		else if(total >= 60 && total < 140) return "semipro";
		else return "iniciante";
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
