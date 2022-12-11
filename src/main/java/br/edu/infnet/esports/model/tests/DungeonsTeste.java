package br.edu.infnet.esports.model.tests;

import java.util.ArrayList;
import java.util.List;

import br.edu.infnet.esports.model.auxiliar.Constante;
import br.edu.infnet.esports.model.domain.Dungeons;
import br.edu.infnet.esports.model.domain.Game;
import br.edu.infnet.esports.model.domain.Gamer;
import br.edu.infnet.esports.model.exceptions.EmailInvalidoException;
import br.edu.infnet.esports.model.exceptions.GameNaoEncontradoException;
import br.edu.infnet.esports.model.exceptions.ValorLimiteUltrapassadoException;

public class DungeonsTeste {

	public static void main(String[] args) {
		List<Game> meusGames = new ArrayList<Game>();
		Dungeons dungeons = new Dungeons(Constante.PLATAFORMA_PS5);
		meusGames.add(dungeons);
		
		try {
			Gamer gamerLuis = new Gamer("Luis", "luisinho@esports.com", 11, meusGames);
			
			Dungeons dungeonsGamerLuis = (Dungeons) gamerLuis.encontraGame(Constante.GAME_DUNGEONS);
			dungeonsGamerLuis.setDano(9);
			dungeonsGamerLuis.setSabedoria(7);
			dungeonsGamerLuis.setVelocidade(8);
			dungeonsGamerLuis.setNivel(dungeonsGamerLuis.calculaNivelGamer(dungeonsGamerLuis.calculaMediaEstatisticaGamer(), gamerLuis.getTitulos()));
			dungeonsGamerLuis.setMediaEstatistica(dungeonsGamerLuis.calculaMediaEstatisticaGamer());
			
			System.out.println(dungeonsGamerLuis);
			System.out.println("Média das estatísticas do gamer @" + gamerLuis.getUsername() + ": " + String.format("%.2f", dungeonsGamerLuis.calculaMediaEstatisticaGamer()));
			
		} catch (ValorLimiteUltrapassadoException | EmailInvalidoException | GameNaoEncontradoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}
		
		try {
			Gamer gamerFelipe = new Gamer("Felipe", "felipinho@esports.com", 2, meusGames);
			
			Dungeons dungeonsGamerFelipe = (Dungeons) gamerFelipe.encontraGame(Constante.GAME_DUNGEONS);
			dungeonsGamerFelipe.setDano(5);
			dungeonsGamerFelipe.setSabedoria(4);
			dungeonsGamerFelipe.setVelocidade(3);
			dungeonsGamerFelipe.setNivel(dungeonsGamerFelipe.calculaNivelGamer(dungeonsGamerFelipe.calculaMediaEstatisticaGamer(), gamerFelipe.getTitulos()));
			dungeonsGamerFelipe.setMediaEstatistica(dungeonsGamerFelipe.calculaMediaEstatisticaGamer());
			
			System.out.println(dungeonsGamerFelipe);
			System.out.println("Média das estatísticas do gamer @" + gamerFelipe.getUsername() + ": " + String.format("%.2f", dungeonsGamerFelipe.calculaMediaEstatisticaGamer()));
			
		} catch (ValorLimiteUltrapassadoException | EmailInvalidoException | GameNaoEncontradoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}
		
		try {
			Gamer gamerBarbosa = new Gamer("Barbosa", "barbosinha@esports.com", 0, meusGames);
			
			Dungeons dungeonsGamerBarbosa = (Dungeons) gamerBarbosa.encontraGame(Constante.GAME_DUNGEONS);
			dungeonsGamerBarbosa.setDano(2);
			dungeonsGamerBarbosa.setSabedoria(3);
			dungeonsGamerBarbosa.setVelocidade(1);
			dungeonsGamerBarbosa.setNivel(dungeonsGamerBarbosa.calculaNivelGamer(dungeonsGamerBarbosa.calculaMediaEstatisticaGamer(), gamerBarbosa.getTitulos()));
			dungeonsGamerBarbosa.setMediaEstatistica(dungeonsGamerBarbosa.calculaMediaEstatisticaGamer());
			
			System.out.println(dungeonsGamerBarbosa);
			System.out.println("Média das estatísticas do gamer @" + gamerBarbosa.getUsername() + ": " + String.format("%.2f", dungeonsGamerBarbosa.calculaMediaEstatisticaGamer()));
			
		} catch (ValorLimiteUltrapassadoException | EmailInvalidoException | GameNaoEncontradoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}
	}
}
