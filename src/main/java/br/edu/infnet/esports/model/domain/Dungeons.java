package br.edu.infnet.esports.model.domain;

public class Dungeons extends Game {

	private boolean rpgAcao;
	private boolean rpgTatico;
	private boolean roguelike;
	
	public Dungeons() {
		super("DUNGEONS");
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.rpgAcao);
		sb.append(";");
		sb.append(this.rpgTatico);
		sb.append(";");
		sb.append(this.roguelike);
		
		return super.toString() + sb.toString();	
	}
	
	public boolean isRpgAcao() {
		return rpgAcao;
	}
	public void setRpgAcao(boolean rpgAcao) {
		this.rpgAcao = rpgAcao;
	}
	
	public boolean isRpgTatico() {
		return rpgTatico;
	}
	public void setRpgTatico(boolean rpgTatico) {
		this.rpgTatico = rpgTatico;
	}
	
	public boolean isRoguelike() {
		return roguelike;
	}
	public void setRoguelike(boolean roguelike) {
		this.roguelike = roguelike;
	}
}
