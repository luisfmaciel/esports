package br.edu.infnet.esports.model.domain;

public class Dungeons extends Game {

	private boolean dano;
	private boolean sabedoria;
	private boolean velocidade;
	
	public Dungeons() {
		super("DUNGEONS");
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

	public boolean isDano() {
		return dano;
	}

	public void setDano(boolean dano) {
		this.dano = dano;
	}

	public boolean isSabedoria() {
		return sabedoria;
	}

	public void setSabedoria(boolean sabedoria) {
		this.sabedoria = sabedoria;
	}

	public boolean isVelocidade() {
		return velocidade;
	}

	public void setVelocidade(boolean velocidade) {
		this.velocidade = velocidade;
	}
	
}
