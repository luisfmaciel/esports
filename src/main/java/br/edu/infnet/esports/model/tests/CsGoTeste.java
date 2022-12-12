package br.edu.infnet.esports.model.tests;

import br.edu.infnet.esports.model.auxiliar.Constante;
import br.edu.infnet.esports.model.domain.CsGo;
import br.edu.infnet.esports.model.exceptions.ValorLimiteUltrapassadoException;

public class CsGoTeste {

	public static void main(String[] args) {
		CsGo csGo = new CsGo(Constante.PLATAFORMA_PS5);
		
		try {
			csGo.setPrecisao(9);
			csGo.setAgressividade(7);
			csGo.setTatica(8);
			csGo.setMediaEstatistica(csGo.calculaMediaEstatisticaGamer());
			csGo.setNivel(csGo.calculaNivelGamer(9));
			
			System.out.println(csGo);
			System.out.println("Média das estatísticas do gamer: " + String.format("%.2f", csGo.calculaMediaEstatisticaGamer()));
			
		} catch (ValorLimiteUltrapassadoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}
		
		try {
			csGo.setPrecisao(5);
			csGo.setAgressividade(4);
			csGo.setTatica(3);
			csGo.setMediaEstatistica(csGo.calculaMediaEstatisticaGamer());
			csGo.setNivel(csGo.calculaNivelGamer(4));
			
			System.out.println(csGo);
			System.out.println("Média das estatísticas do gamer: " + String.format("%.2f", csGo.calculaMediaEstatisticaGamer()));
		} catch (ValorLimiteUltrapassadoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}
		
		try {
			csGo.setPrecisao(2);
			csGo.setAgressividade(3);
			csGo.setTatica(-1);
			csGo.setMediaEstatistica(csGo.calculaMediaEstatisticaGamer());
			csGo.setNivel(csGo.calculaNivelGamer(1));
			
			System.out.println(csGo);
			System.out.println("Média das estatísticas do gamer: " + String.format("%.2f", csGo.calculaMediaEstatisticaGamer()));
		} catch (ValorLimiteUltrapassadoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}
	}
}
