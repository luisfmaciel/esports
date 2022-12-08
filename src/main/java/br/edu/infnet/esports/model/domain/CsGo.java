package br.edu.infnet.esports.model.domain;

public class CsGo extends Game {

	private int precisao;
	private int agressividade;
	private int tatico;

	public CsGo() {
		super("CS:GO");
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.precisao);
		sb.append(";");
		sb.append(this.agressividade);
		sb.append(";");
		sb.append(this.tatico);
		
		return super.toString() + sb.toString();	
	}
	public int getPrecisao() {
		return precisao;
	}

	public void setPrecisao(int precisao) {
		this.precisao = precisao;
	}

	public int getAgressividade() {
		return agressividade;
	}

	public void setAgressividade(int agressividade) {
		this.agressividade = agressividade;
	}

	public int getTatico() {
		return tatico;
	}

	public void setTatico(int tatico) {
		this.tatico = tatico;
	}

}
