package br.edu.infnet.esports.model.tests;

import br.edu.infnet.esports.model.auxiliar.Constante;
import br.edu.infnet.esports.model.domain.Dungeons;
import br.edu.infnet.esports.model.exceptions.CampoVazioException;
import br.edu.infnet.esports.model.exceptions.ValorLimiteUltrapassadoException;

public class DungeonsTeste {

	public static void main(String[] args) {
		Dungeons dungeons = new Dungeons(Constante.PLATAFORMA_PS5);
		
		try {
			dungeons.setDano("9");
			dungeons.setSabedoria("7");
			dungeons.setVelocidade("8");
			dungeons.setTitulos("9");
			dungeons.setMediaEstatistica(dungeons.calculaMediaEstatisticaGamer());
			dungeons.setNivel(dungeons.identificaNivelGamer());
			
			System.out.println(dungeons);
			System.out.println("Média das estatísticas do gamer: " + String.format("%.2f", dungeons.calculaMediaEstatisticaGamer()));
			
		} catch (ValorLimiteUltrapassadoException | CampoVazioException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}
		
		try {
			dungeons.setDano("5");
			dungeons.setSabedoria("2");
			dungeons.setVelocidade("4");
			dungeons.setTitulos("4");
			dungeons.setMediaEstatistica(dungeons.calculaMediaEstatisticaGamer());
			dungeons.setNivel(dungeons.identificaNivelGamer());
			
			System.out.println(dungeons);
			System.out.println("Média das estatísticas do gamer: " + String.format("%.2f", dungeons.calculaMediaEstatisticaGamer()));
			
		} catch (ValorLimiteUltrapassadoException | CampoVazioException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}
		
		try {
			dungeons.setDano("1");
			dungeons.setSabedoria("0");
			dungeons.setVelocidade("1");
			dungeons.setTitulos("0");
			dungeons.setMediaEstatistica(dungeons.calculaMediaEstatisticaGamer());
			dungeons.setNivel(dungeons.identificaNivelGamer());
			
			System.out.println(dungeons);
			System.out.println("Média das estatísticas do gamer: " + String.format("%.2f", dungeons.calculaMediaEstatisticaGamer()));
			
		} catch (ValorLimiteUltrapassadoException | CampoVazioException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}
	}
}
