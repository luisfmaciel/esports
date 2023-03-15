package br.edu.infnet.esports.model.domain;
import javax.persistence.Entity;
import javax.persistence.Table;

import br.edu.infnet.esports.model.auxiliar.Constante;
import br.edu.infnet.esports.model.exceptions.CampoVazioException;
import br.edu.infnet.esports.model.exceptions.ValorLimiteUltrapassadoException;

@Entity
@Table(name = "TFifa")
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

	public void setFinalizacao(String finalizacao) throws ValorLimiteUltrapassadoException, CampoVazioException {
		Float floatFinalizacao;
		try {
			floatFinalizacao = Float.parseFloat(finalizacao);
		} catch (Exception e) {
			throw new CampoVazioException("O preenchimento do campo Finalização está inválido");
		} 
		
		if(floatFinalizacao < 0) 
			throw new ValorLimiteUltrapassadoException("Sua estatística de finalização deve ser maior ou igual à zero!");
		
		if(floatFinalizacao > 10) 
			throw new ValorLimiteUltrapassadoException("Sua estatística de finalização deve ser menor ou igual à 10!");
		
		this.finalizacao = floatFinalizacao;
	}

	public float getMarcacao() {
		return marcacao;
	}

	public void setMarcacao(String marcacao) throws ValorLimiteUltrapassadoException, CampoVazioException {
		Float floatMarcacao;
		try {
			floatMarcacao = Float.parseFloat(marcacao);
		} catch (Exception e) {
			throw new CampoVazioException("O preenchimento do campo Marcação está inválido");
		} 
		if(floatMarcacao < 0) 
			throw new ValorLimiteUltrapassadoException("Sua estatística de marcação deve ser maior ou igual à zero!");
		
		if(floatMarcacao > 10) 
			throw new ValorLimiteUltrapassadoException("Sua estatística de marcação deve ser menor ou igual à 10!");
		
		this.marcacao = floatMarcacao;
	}

	public float getPasse() {
		return passe;
	}

	public void setPasse(String passe) throws ValorLimiteUltrapassadoException, CampoVazioException {
		Float floatPasse;
		try {
			floatPasse = Float.parseFloat(passe);
		} catch (Exception e) {
			throw new CampoVazioException("O preenchimento do campo Passe está inválido");
		} 
		
		if(floatPasse < 0) 
			throw new ValorLimiteUltrapassadoException("Sua estatística de passe deve ser maior ou igual à zero!");
		
		if(floatPasse > 10) 
			throw new ValorLimiteUltrapassadoException("Sua estatística de passe deve ser menor ou igual à 10!");
		
		this.passe = floatPasse;
	}
}
