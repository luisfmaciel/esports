package br.edu.infnet.esports.model.tests;

import java.util.ArrayList;
import java.util.List;

import br.edu.infnet.esports.model.auxiliar.Constante;
import br.edu.infnet.esports.model.domain.*;
import br.edu.infnet.esports.model.exceptions.EmailInvalidoException;
import br.edu.infnet.esports.model.exceptions.GameNaoEncontradoException;
import br.edu.infnet.esports.model.exceptions.ValorLimiteUltrapassadoException;

public class GameTeste {

	public static void main(String[] args) {
		List<Game> gamesLuis = new ArrayList<Game>();
		
		try {
			Fifa fifa = new Fifa(Constante.PLATAFORMA_PS5);
			gamesLuis.add(fifa);
			
			Gamer gamerLuis1 = new Gamer("Luis", "luis@esports.com", 8, gamesLuis);
			
			Fifa fifaGamerLuis = (Fifa) gamerLuis1.encontraGame(Constante.GAME_FIFA);
			fifaGamerLuis.setFinalizacao(9);
			fifaGamerLuis.setMarcacao(7);
			fifaGamerLuis.setPasse(8);
			fifaGamerLuis.setNivel(fifaGamerLuis.calculaNivelGamer(fifaGamerLuis.calculaMediaEstatisticaGamer(), gamerLuis1.getTitulos()));
			fifaGamerLuis.setMediaEstatistica(fifaGamerLuis.calculaMediaEstatisticaGamer());
			
			System.out.println(fifaGamerLuis);
			
		} catch (ValorLimiteUltrapassadoException | EmailInvalidoException | GameNaoEncontradoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}
		
		try {
			Dungeons dungeons = new Dungeons(Constante.PLATAFORMA_PS5);
			gamesLuis.add(dungeons);
			
			Gamer gamerLuis2 = new Gamer("Luis", "luis@esports.com", 2, gamesLuis);
			
			Dungeons dungeonsGamerLuis = (Dungeons) gamerLuis2.encontraGame(Constante.GAME_DUNGEONS);
			dungeonsGamerLuis.setDano(3);
			dungeonsGamerLuis.setSabedoria(1);
			dungeonsGamerLuis.setVelocidade(2);
			dungeonsGamerLuis.setNivel(dungeonsGamerLuis.calculaNivelGamer(dungeonsGamerLuis.calculaMediaEstatisticaGamer(), gamerLuis2.getTitulos()));
			dungeonsGamerLuis.setMediaEstatistica(dungeonsGamerLuis.calculaMediaEstatisticaGamer());
			
			System.out.println(dungeonsGamerLuis);
			
		} catch (ValorLimiteUltrapassadoException | EmailInvalidoException | GameNaoEncontradoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}
		
		try {
			CsGo fifa = new CsGo(Constante.PLATAFORMA_PC);
			gamesLuis.add(fifa);
			
			Gamer gamerLuis3 = new Gamer("Luis", "luis@esports.com", 4, gamesLuis);
			
			CsGo csgoGamerLuis = (CsGo) gamerLuis3.encontraGame(Constante.GAME_CSGO);
			csgoGamerLuis.setPrecisao(6);
			csgoGamerLuis.setAgressividade(4);
			csgoGamerLuis.setTatica(5);
			csgoGamerLuis.setNivel(csgoGamerLuis.calculaNivelGamer(csgoGamerLuis.calculaMediaEstatisticaGamer(), gamerLuis3.getTitulos()));
			csgoGamerLuis.setMediaEstatistica(csgoGamerLuis.calculaMediaEstatisticaGamer());
			
			System.out.println(csgoGamerLuis);
			
		} catch (ValorLimiteUltrapassadoException | EmailInvalidoException | GameNaoEncontradoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}
		
	}
}
