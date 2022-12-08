package br.edu.infnet.esports.model.domain;

public class CsGo extends Game {

	private boolean mundoAberto;
	private boolean tiroEmPrimeiraPessoa;
	private boolean tiroEmTerceiraPessoa;

	public CsGo() {
		super("CS:GO");
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.mundoAberto);
		sb.append(";");
		sb.append(this.tiroEmPrimeiraPessoa);
		sb.append(";");
		sb.append(this.tiroEmTerceiraPessoa);
		
		return super.toString() + sb.toString();	
	}
	
	public boolean isMundoAberto() {
		return mundoAberto;
	}
	public void setMundoAberto(boolean mundoAberto) {
		this.mundoAberto = mundoAberto;
	}
	
	public boolean isTiroEmPrimeiraPessoa() {
		return tiroEmPrimeiraPessoa;
	}
	public void setTiroEmPrimeiraPessoa(boolean tiroEmPrimeiraPessoa) {
		this.tiroEmPrimeiraPessoa = tiroEmPrimeiraPessoa;
	}
	
	public boolean isTiroEmTerceiraPessoa() {
		return tiroEmTerceiraPessoa;
	}
	public void setTiroEmTerceiraPessoa(boolean tiroEmTerceiraPessoa) {
		this.tiroEmTerceiraPessoa = tiroEmTerceiraPessoa;
	}

}
