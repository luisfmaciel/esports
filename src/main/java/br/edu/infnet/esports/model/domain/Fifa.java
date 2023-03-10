package br.edu.infnet.esports.model.domain;
import javax.persistence.Entity;
import javax.persistence.Table;

import br.edu.infnet.esports.model.auxiliar.Constante;
import br.edu.infnet.esports.model.exceptions.ValorLimiteUltrapassadoException;

@Entity
public class Fifa extends Game {
	private float finalizacao;
	private float marcacao;
	private float passe;

	public Fifa() {}
	
	public Fifa(String plataforma) {
		super("FIFA", plataforma);		
	}
	
	@Override
	public float calculaMediaEstatisticaGamer() {
		float finalizacao = this.finalizacao * Constante.PESO_3;
		float marcacao= this.marcacao * Constante.PESO_2;
		float passe = this.passe * Constante.PESO_1;
		
		return (finalizacao + marcacao + passe) / 3;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.finalizacao);
		sb.append(";");
		sb.append(this.marcacao);
		sb.append(";");
		sb.append(this.passe);
		
		return super.toString() + sb.toString();	
	}

	public float getFinalizacao() {
		return finalizacao;
	}

	public void setFinalizacao(float finalizacao) throws ValorLimiteUltrapassadoException {
		if(finalizacao < 0) 
			throw new ValorLimiteUltrapassadoException("Sua estatística de finalização deve ser maior ou igual à zero!");
		
		if(finalizacao > 10) 
			throw new ValorLimiteUltrapassadoException("Sua estatística de finalização deve ser menor ou igual à 10!");
		
		this.finalizacao = finalizacao;
	}

	public float getMarcacao() {
		return marcacao;
	}

	public void setMarcacao(float marcacao) throws ValorLimiteUltrapassadoException {
		if(marcacao < 0) 
			throw new ValorLimiteUltrapassadoException("Sua estatística de marcação deve ser maior ou igual à zero!");
		
		if(marcacao > 10) 
			throw new ValorLimiteUltrapassadoException("Sua estatística de marcação deve ser menor ou igual à 10!");
		
		this.marcacao = marcacao;
	}

	public float getPasse() {
		return passe;
	}

	public void setPasse(float passe) throws ValorLimiteUltrapassadoException {
		if(passe < 0) 
			throw new ValorLimiteUltrapassadoException("Sua estatística de passe deve ser maior ou igual à zero!");
		
		if(passe > 10) 
			throw new ValorLimiteUltrapassadoException("Sua estatística de passe deve ser menor ou igual à 10!");
		
		this.passe = passe;
	}
}
