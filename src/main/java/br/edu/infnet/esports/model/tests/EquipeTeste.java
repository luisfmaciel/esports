package br.edu.infnet.esports.model.tests;

import java.util.ArrayList;
import java.util.List;

import br.edu.infnet.esports.model.domain.Equipe;
import br.edu.infnet.esports.model.domain.Fifa;
import br.edu.infnet.esports.model.domain.Game;
import br.edu.infnet.esports.model.domain.Gamer;

public class EquipeTeste {

	public static void main(String[] args) {
		try {
			
			List<Game> gamesLuis = new ArrayList<Game>();
			List<Game> gamesFelipe = new ArrayList<Game>();
			List<Game> gamesMaciel = new ArrayList<Game>();
			
			gamesLuis.add(new Fifa("PS5"));
			gamesFelipe.add(new Fifa("Xbox One"));
			gamesMaciel.add(new Fifa("PC"));
			
			
			Equipe equipe1 = new Equipe("Futiba", 4, true, "profissional");

			Gamer gamer1 = new Gamer("Luis", "luis@esports.com", 9, gamesLuis);
			Fifa fifaGamer1 = (Fifa) gamer1.encontraGame("FIFA");
			fifaGamer1.setFinalizacao(9);
			fifaGamer1.setMarcacao(7);
			fifaGamer1.setPasse(8);
			fifaGamer1.setNivel(fifaGamer1.calculaNivelGamer(fifaGamer1.calculaMediaEstatisticaGamer(), gamer1.getTitulos()));
			fifaGamer1.setMediaEstatistica(fifaGamer1.calculaMediaEstatisticaGamer());
			
			System.out.println(fifaGamer1.getNivel());
			
			Gamer gamer2 = new Gamer("Felipe", "felipe@esports.com", 6, gamesFelipe);
			Fifa fifaGamer2 = (Fifa) gamer2.encontraGame("FIFA");
			fifaGamer2.setFinalizacao(8);
			fifaGamer2.setMarcacao(7);
			fifaGamer2.setPasse(5);
			fifaGamer2.setNivel(fifaGamer1.calculaNivelGamer(fifaGamer2.calculaMediaEstatisticaGamer(), gamer2.getTitulos()));
			fifaGamer2.setMediaEstatistica(fifaGamer2.calculaMediaEstatisticaGamer());
			
			System.out.println(fifaGamer2.getMediaEstatistica());
			
			Gamer gamer3 = new Gamer("Maciel", "maciel@esports.com", 7, gamesMaciel);
			Fifa fifaGamer3 = (Fifa) gamer3.encontraGame("FIFA");
			fifaGamer3.setFinalizacao(9);
			fifaGamer3.setMarcacao(8);
			fifaGamer3.setPasse(6);
			fifaGamer3.setNivel(fifaGamer3.calculaNivelGamer(fifaGamer3.calculaMediaEstatisticaGamer(), gamer3.getTitulos()));
			fifaGamer3.setMediaEstatistica(fifaGamer3.calculaMediaEstatisticaGamer());
			
			 
			equipe1.setGame(new Fifa("PS5"));
			equipe1.setGamers(gamer1);
			equipe1.setGamers(gamer2);
			equipe1.setGamers(gamer3);
			
			equipe1.imprimir();
			
//			Gamer.setGamersTotal(gamer1);
//			Gamer.setGamersTotal(gamer2);
//			Gamer.setGamersTotal(gamer3);
		
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
