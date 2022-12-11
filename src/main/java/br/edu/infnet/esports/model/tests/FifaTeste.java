package br.edu.infnet.esports.model.tests;

import java.util.ArrayList;
import java.util.List;

import br.edu.infnet.esports.model.auxiliar.Constante;
import br.edu.infnet.esports.model.domain.Fifa;
import br.edu.infnet.esports.model.domain.Game;
import br.edu.infnet.esports.model.domain.Gamer;
import br.edu.infnet.esports.model.exceptions.EmailInvalidoException;
import br.edu.infnet.esports.model.exceptions.GameNaoEncontradoException;
import br.edu.infnet.esports.model.exceptions.ValorLimiteUltrapassadoException;

public class FifaTeste {

	public static void main(String[] args) {
		List<Game> meusGames = new ArrayList<Game>();
		Fifa fifa = new Fifa(Constante.PLATAFORMA_PS5);
		meusGames.add(fifa);
		
		try {
			Gamer gamerLuis = new Gamer("Luis", "luisinho@esports.com", 8, meusGames);
			
			Fifa fifaGamerLuis = (Fifa) gamerLuis.encontraGame(Constante.GAME_FIFA);
			fifaGamerLuis.setFinalizacao(9);
			fifaGamerLuis.setMarcacao(7);
			fifaGamerLuis.setPasse(8);
			fifaGamerLuis.setNivel(fifaGamerLuis.calculaNivelGamer(fifaGamerLuis.calculaMediaEstatisticaGamer(), gamerLuis.getTitulos()));
			fifaGamerLuis.setMediaEstatistica(fifaGamerLuis.calculaMediaEstatisticaGamer());
			
			System.out.println(fifaGamerLuis);
			System.out.println("Média das estatísticas do gamer @" + gamerLuis.getUsername() + ": " + String.format("%.2f", fifaGamerLuis.calculaMediaEstatisticaGamer()));
			
		} catch (ValorLimiteUltrapassadoException | EmailInvalidoException | GameNaoEncontradoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}
		
		try {
			Gamer gamerFelipe = new Gamer("Felipe", "felipinho@esports.com", 1, meusGames);
			
			Fifa fifaGamerFelipe = (Fifa) gamerFelipe.encontraGame(Constante.GAME_FIFA);
			fifaGamerFelipe.setFinalizacao(5);
			fifaGamerFelipe.setMarcacao(2);
			fifaGamerFelipe.setPasse(4);
			fifaGamerFelipe.setNivel(fifaGamerFelipe.calculaNivelGamer(fifaGamerFelipe.calculaMediaEstatisticaGamer(), gamerFelipe.getTitulos()));
			fifaGamerFelipe.setMediaEstatistica(fifaGamerFelipe.calculaMediaEstatisticaGamer());
			
			System.out.println(fifaGamerFelipe);
			System.out.println("Média das estatísticas do gamer @" + gamerFelipe.getUsername() + ": " + String.format("%.2f", fifaGamerFelipe.calculaMediaEstatisticaGamer()));
			
		} catch (ValorLimiteUltrapassadoException | EmailInvalidoException | GameNaoEncontradoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}
		
		try {
			Gamer gamerBarbosa = new Gamer("Barbosa", "barbosinha@esports.com", 0, meusGames);
			
			Fifa fifaGamerBarbosa = (Fifa) gamerBarbosa.encontraGame(Constante.GAME_FIFA);
			fifaGamerBarbosa.setFinalizacao(1);
			fifaGamerBarbosa.setMarcacao(0);
			fifaGamerBarbosa.setPasse(1);
			fifaGamerBarbosa.setNivel(fifaGamerBarbosa.calculaNivelGamer(fifaGamerBarbosa.calculaMediaEstatisticaGamer(), gamerBarbosa.getTitulos()));
			fifaGamerBarbosa.setMediaEstatistica(fifaGamerBarbosa.calculaMediaEstatisticaGamer());
			
			System.out.println(fifaGamerBarbosa);
			System.out.println("Média das estatísticas do gamer @" + gamerBarbosa.getUsername() + ": " + String.format("%.2f", fifaGamerBarbosa.calculaMediaEstatisticaGamer()));
			
		} catch (ValorLimiteUltrapassadoException | EmailInvalidoException | GameNaoEncontradoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}

	}

}
