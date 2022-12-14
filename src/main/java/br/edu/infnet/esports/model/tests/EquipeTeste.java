package br.edu.infnet.esports.model.tests;

import java.util.ArrayList;
import java.util.List;

import br.edu.infnet.esports.model.auxiliar.Constante;
import br.edu.infnet.esports.model.domain.*;
import br.edu.infnet.esports.model.exceptions.EmailInvalidoException;
import br.edu.infnet.esports.model.exceptions.EquipeCompletaException;
import br.edu.infnet.esports.model.exceptions.GameNaoEncontradoException;
import br.edu.infnet.esports.model.exceptions.NivelDiferenteNivelException;
import br.edu.infnet.esports.model.exceptions.PlatformaDiferenteException;
import br.edu.infnet.esports.model.exceptions.ValorLimiteUltrapassadoException;

public class EquipeTeste {

	public static void main(String[] args) {
		List<Game> gamesLuis = new ArrayList<Game>();
		List<Game> gamesFelipe = new ArrayList<Game>();
		List<Game> gamesBarbosa = new ArrayList<Game>();
	
		gamesLuis.add(new Fifa(Constante.PLATAFORMA_PS5));
		gamesLuis.add(new CsGo(Constante.PLATAFORMA_PC));
		gamesLuis.add(new Dungeons(Constante.PLATAFORMA_PS5));
		
		gamesFelipe.add(new Fifa(Constante.PLATAFORMA_XBOXONE));
		gamesFelipe.add(new CsGo(Constante.PLATAFORMA_PS4));
		gamesFelipe.add(new Dungeons(Constante.PLATAFORMA_PS5));
		
		gamesBarbosa.add(new Fifa(Constante.PLATAFORMA_XBOXONE));
		gamesBarbosa.add(new Dungeons(Constante.PLATAFORMA_PS5));
		gamesBarbosa.add(new CsGo(Constante.PLATAFORMA_PC));

		try {
			Gamer gamerLuis1 = new Gamer("Luis", "luis@esports.com", gamesLuis);
			Fifa fifaGamerLuis = (Fifa) gamerLuis1.encontraGame(Constante.GAME_FIFA);
			fifaGamerLuis.setFinalizacao(9);
			fifaGamerLuis.setMarcacao(7);
			fifaGamerLuis.setPasse(8);
			fifaGamerLuis.setTitulos(8);
			fifaGamerLuis.setMediaEstatistica(fifaGamerLuis.calculaMediaEstatisticaGamer());
			fifaGamerLuis.setNivel(fifaGamerLuis.identificaNivelGamer());
			
			Equipe equipeFutiba = new Equipe("Futiba", 4, true, Constante.PROFISSIONAL, new Fifa(Constante.PLATAFORMA_PS5));
			equipeFutiba.setGamers(gamerLuis1);
			
			equipeFutiba.imprimir();
			System.out.println(equipeFutiba);
			
		} catch (ValorLimiteUltrapassadoException 
				| EmailInvalidoException 
				| GameNaoEncontradoException 
				| EquipeCompletaException 
				| NivelDiferenteNivelException 
				| PlatformaDiferenteException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}
		
		try {
			Gamer gamerLuis2 = new Gamer("Luis", "luisinho@esports.com", gamesLuis);
			Dungeons dungeonsGamerLuis = (Dungeons) gamerLuis2.encontraGame(Constante.GAME_DUNGEONS);
			dungeonsGamerLuis.setDano(3);
			dungeonsGamerLuis.setSabedoria(1);
			dungeonsGamerLuis.setVelocidade(2);
			dungeonsGamerLuis.setTitulos(1);
			dungeonsGamerLuis.setMediaEstatistica(dungeonsGamerLuis.calculaMediaEstatisticaGamer());
			dungeonsGamerLuis.setNivel(dungeonsGamerLuis.identificaNivelGamer());

			Gamer gamerFelipe = new Gamer("Felipe", "felipinho@esports.com", gamesFelipe);
			Dungeons dungeonsGamerFelipe = (Dungeons) gamerFelipe.encontraGame(Constante.GAME_DUNGEONS);
			dungeonsGamerFelipe.setDano(2);
			dungeonsGamerFelipe.setSabedoria(2);
			dungeonsGamerFelipe.setVelocidade(1);
			dungeonsGamerFelipe.setTitulos(0);
			dungeonsGamerFelipe.setMediaEstatistica(dungeonsGamerFelipe.calculaMediaEstatisticaGamer());
			dungeonsGamerFelipe.setNivel(dungeonsGamerFelipe.identificaNivelGamer());
			
			Equipe equipeDragons = new Equipe("Dragons", 14, true, Constante.INICIANTE, new Dungeons(Constante.PLATAFORMA_PS5));
			equipeDragons.setGamers(gamerLuis2);
			equipeDragons.setGamers(gamerFelipe);
			
			equipeDragons.imprimir();
			
		} catch (ValorLimiteUltrapassadoException 
				| EmailInvalidoException 
				| GameNaoEncontradoException 
				| EquipeCompletaException 
				| NivelDiferenteNivelException 
				| PlatformaDiferenteException   e) {
			System.out.println("[ERRO] " + e.getMessage());
		}
		
		try {
			Gamer gamerLuis3 = new Gamer("Luis", "luisinho@esports.com", gamesLuis);
			CsGo csgoGamerLuis = (CsGo) gamerLuis3.encontraGame(Constante.GAME_CSGO);
			csgoGamerLuis.setPrecisao(9);
			csgoGamerLuis.setAgressividade(7);
			csgoGamerLuis.setTatica(8);
			csgoGamerLuis.setTitulos(11);
			csgoGamerLuis.setMediaEstatistica(csgoGamerLuis.calculaMediaEstatisticaGamer());
			csgoGamerLuis.setNivel(csgoGamerLuis.identificaNivelGamer());
			
			Gamer gamerFelipe3 = new Gamer("Felipe", "felipinho@esports.com",  gamesFelipe);
			CsGo csGoGamerFelipe = (CsGo) gamerFelipe3.encontraGame(Constante.GAME_CSGO);
			csGoGamerFelipe.setPrecisao(9);
			csGoGamerFelipe.setAgressividade(7);
			csGoGamerFelipe.setTatica(8);
			csGoGamerFelipe.setTitulos(12);
			csGoGamerFelipe.setMediaEstatistica(csGoGamerFelipe.calculaMediaEstatisticaGamer());
			csGoGamerFelipe.setNivel(csGoGamerFelipe.identificaNivelGamer());
			
			Gamer gamerBarbosa3 = new Gamer("Barbosa", "barbosinha@esports.com", gamesBarbosa);
			CsGo csgoGamerBarbosa = (CsGo) gamerBarbosa3.encontraGame(Constante.GAME_CSGO);
			csgoGamerBarbosa.setPrecisao(9);
			csgoGamerBarbosa.setAgressividade(7);
			csgoGamerBarbosa.setTatica(8);
			csgoGamerBarbosa.setTitulos(8);
			csgoGamerBarbosa.setMediaEstatistica(csgoGamerBarbosa.calculaMediaEstatisticaGamer());
			csgoGamerBarbosa.setNivel(csgoGamerBarbosa.identificaNivelGamer());

			Equipe equipeGranada = new Equipe("Granada", 2, false, Constante.LENDARIO, new CsGo(Constante.PLATAFORMA_PC));
			equipeGranada.setGamers(gamerLuis3);
			equipeGranada.setGamers(gamerFelipe3);
			equipeGranada.setGamers(gamerBarbosa3);
			
			equipeGranada.imprimir();
			
		} catch (ValorLimiteUltrapassadoException 
				| EmailInvalidoException 
				| GameNaoEncontradoException 
				| EquipeCompletaException 
				| NivelDiferenteNivelException 
				| PlatformaDiferenteException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}
	}
}
