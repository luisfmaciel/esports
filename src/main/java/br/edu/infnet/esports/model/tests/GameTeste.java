package br.edu.infnet.esports.model.tests;

import br.edu.infnet.esports.model.auxiliar.Constante;
import br.edu.infnet.esports.model.domain.*;
import br.edu.infnet.esports.model.exceptions.ValorLimiteUltrapassadoException;

public class GameTeste {

	public static void main(String[] args) {
		try {
			Fifa fifa = new Fifa(Constante.PLATAFORMA_PS5);
			
			fifa.setFinalizacao(9);
			fifa.setMarcacao(7);
			fifa.setPasse(8);
			fifa.setTitulos(8);
			fifa.setMediaEstatistica(fifa.calculaMediaEstatisticaGamer());
			fifa.setNivel(fifa.identificaNivelGamer());
			
			System.out.println(fifa);
			
		} catch (ValorLimiteUltrapassadoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}
		
		try {
			Dungeons dungeons = new Dungeons(Constante.PLATAFORMA_PS5);
			
			dungeons.setDano(3);
			dungeons.setSabedoria(1);
			dungeons.setVelocidade(2);
			dungeons.setTitulos(2);
			dungeons.setMediaEstatistica(dungeons.calculaMediaEstatisticaGamer());
			dungeons.setNivel(dungeons.identificaNivelGamer());
			
			System.out.println(dungeons);
			
		} catch (ValorLimiteUltrapassadoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}
		
		try {
			CsGo csgo = new CsGo(Constante.PLATAFORMA_PC);

			csgo.setPrecisao(6);
			csgo.setAgressividade(4);
			csgo.setTatica(5);
			csgo.setTitulos(4);
			csgo.setMediaEstatistica(csgo.calculaMediaEstatisticaGamer());
			csgo.setNivel(csgo.identificaNivelGamer());
			
			System.out.println(csgo);
			
		} catch (ValorLimiteUltrapassadoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}
		
	}
}
