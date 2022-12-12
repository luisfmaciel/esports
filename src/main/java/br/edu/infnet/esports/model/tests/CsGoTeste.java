package br.edu.infnet.esports.model.tests;

import java.util.ArrayList;
import java.util.List;

import br.edu.infnet.esports.model.auxiliar.Constante;
import br.edu.infnet.esports.model.domain.CsGo;
import br.edu.infnet.esports.model.domain.Game;
import br.edu.infnet.esports.model.domain.Gamer;
import br.edu.infnet.esports.model.exceptions.EmailInvalidoException;
import br.edu.infnet.esports.model.exceptions.GameNaoEncontradoException;
import br.edu.infnet.esports.model.exceptions.ValorLimiteUltrapassadoException;

public class CsGoTeste {

	public static void main(String[] args) {
		List<Game> meusGames = new ArrayList<Game>();
		CsGo csGo = new CsGo(Constante.PLATAFORMA_PS5);
		meusGames.add(csGo);
		
		try {
			Gamer gamerLuis = new Gamer("Luis", "luisinho@esports.com", 11, meusGames);
			
			CsGo csGoGamerLuis = (CsGo) gamerLuis.encontraGame(Constante.GAME_CSGO);
			csGoGamerLuis.setPrecisao(9);
			csGoGamerLuis.setAgressividade(7);
			csGoGamerLuis.setTatica(8);
			csGoGamerLuis.setMediaEstatistica(csGoGamerLuis.calculaMediaEstatisticaGamer());
			csGoGamerLuis.setNivel(csGoGamerLuis.calculaNivelGamer(gamerLuis.getTitulos()));
			
			System.out.println(csGoGamerLuis);
			System.out.println("Média das estatísticas do gamer @" + gamerLuis.getUsername() + ": " + String.format("%.2f", csGoGamerLuis.calculaMediaEstatisticaGamer()));
			
		} catch (ValorLimiteUltrapassadoException | EmailInvalidoException | GameNaoEncontradoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}
		
		try {
			Gamer gamerFelipe = new Gamer("Felipe", "felipinho@esports.com", 2, meusGames);
			
			CsGo csGoGamerFelipe = (CsGo) gamerFelipe.encontraGame(Constante.GAME_CSGO);
			csGoGamerFelipe.setPrecisao(5);
			csGoGamerFelipe.setAgressividade(4);
			csGoGamerFelipe.setTatica(3);
			csGoGamerFelipe.setMediaEstatistica(csGoGamerFelipe.calculaMediaEstatisticaGamer());
			csGoGamerFelipe.setNivel(csGoGamerFelipe.calculaNivelGamer(gamerFelipe.getTitulos()));
			
			System.out.println(csGoGamerFelipe);
			System.out.println("Média das estatísticas do gamer @" + gamerFelipe.getUsername() + ": " + String.format("%.2f", csGoGamerFelipe.calculaMediaEstatisticaGamer()));
			
		} catch (ValorLimiteUltrapassadoException | EmailInvalidoException | GameNaoEncontradoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}
		
		try {
			Gamer gamerBarbosa = new Gamer("Barbosa", "barbosinha@esports.com", 0, meusGames);
			
			CsGo csGoGamerBarbosa = (CsGo) gamerBarbosa.encontraGame(Constante.GAME_CSGO);
			csGoGamerBarbosa.setPrecisao(2);
			csGoGamerBarbosa.setAgressividade(3);
			csGoGamerBarbosa.setTatica(1);
			csGoGamerBarbosa.setMediaEstatistica(csGoGamerBarbosa.calculaMediaEstatisticaGamer());
			csGoGamerBarbosa.setNivel(csGoGamerBarbosa.calculaNivelGamer(gamerBarbosa.getTitulos()));
			
			System.out.println(csGoGamerBarbosa);
			System.out.println("Média das estatísticas do gamer @" + gamerBarbosa.getUsername() + ": " + String.format("%.2f", csGoGamerBarbosa.calculaMediaEstatisticaGamer()));
			
		} catch (ValorLimiteUltrapassadoException | EmailInvalidoException | GameNaoEncontradoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}
	}
}
