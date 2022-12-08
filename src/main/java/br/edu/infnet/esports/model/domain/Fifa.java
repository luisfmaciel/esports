package br.edu.infnet.esports.model.domain;

public class Fifa extends Game {
	private boolean arcade;
	private boolean simulacao;
	private boolean manager;

		
	public Fifa() {
		super("FIFA 22");
//		super.setNome("FIFA");
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.arcade);
		sb.append(";");
		sb.append(this.simulacao);
		sb.append(";");
		sb.append(this.manager);
		
		return super.toString() + sb.toString();	
	}
	
	public boolean isArcade() {
		return arcade;
	}

	public void setArcade(boolean arcade) {
		this.arcade = arcade;
	}

	public boolean isSimulacao() {
		return simulacao;
	}

	public void setSimulacao(boolean simulacao) {
		this.simulacao = simulacao;
	}

	public boolean isManager() {
		return manager;
	}

	public void setManager(boolean manager) {
		this.manager = manager;
	}
}
