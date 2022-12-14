package br.edu.infnet.esports.model.tests;

import br.edu.infnet.esports.model.auxiliar.Constante;
import br.edu.infnet.esports.model.domain.Fifa;
import br.edu.infnet.esports.model.exceptions.ValorLimiteUltrapassadoException;

public class FifaTeste {

	public static void main(String[] args) {
		Fifa fifa = new Fifa(Constante.PLATAFORMA_PS5);
		
		try {
			fifa.setFinalizacao(9);
			fifa.setMarcacao(7);
			fifa.setPasse(8);
			fifa.setTitulos(9);
			fifa.setMediaEstatistica(fifa.calculaMediaEstatisticaGamer());
			fifa.setNivel(fifa.identificaNivelGamer());
			
			System.out.println(fifa);
			System.out.println("Média das estatísticas do gamer: " + String.format("%.2f", fifa.calculaMediaEstatisticaGamer()));
			
		} catch (ValorLimiteUltrapassadoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}
		
		try {
			fifa.setFinalizacao(5);
			fifa.setMarcacao(2);
			fifa.setPasse(4);
			fifa.setTitulos(4);
			fifa.setMediaEstatistica(fifa.calculaMediaEstatisticaGamer());
			fifa.setNivel(fifa.identificaNivelGamer());
			
			System.out.println(fifa);
			System.out.println("Média das estatísticas do gamer: " + String.format("%.2f", fifa.calculaMediaEstatisticaGamer()));
			
			
		} catch (ValorLimiteUltrapassadoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}
		
		try {
			fifa.setFinalizacao(1);
			fifa.setMarcacao(0);
			fifa.setPasse(1);
			fifa.setTitulos(0);
			fifa.setMediaEstatistica(fifa.calculaMediaEstatisticaGamer());
			fifa.setNivel(fifa.identificaNivelGamer());
			
			System.out.println(fifa);
			System.out.println("Média das estatísticas do gamer: " + String.format("%.2f", fifa.calculaMediaEstatisticaGamer()));
			
		} catch (ValorLimiteUltrapassadoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}

	}

}
