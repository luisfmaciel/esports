package br.edu.infnet.esports.model.tests;

import br.edu.infnet.esports.model.domain.*;

public class GamerTeste {

	public static void main(String[] args) {
		
		Gamer gamer1 = new Gamer();
		Gamer gamer2 = new Gamer();
		Gamer gamer3 = new Gamer();
		
		Fifa fifa = new Fifa();
	
		Equipe equipe1 = new Equipe(); 
		
		try {
			gamer1.setEmail("luis@esports.com");
			gamer2.setEmail("felipe@esports.com");
			gamer3.setEmail("maciel@esports.com");

			fifa.setPlataforma("PS5");
			fifa.setNivel("amador");
			
			System.out.println(fifa.toString());

			gamer1.setGames(fifa);
			gamer2.setGames(fifa);
			gamer3.setGames(fifa);
			
			equipe1.setNome("Futiba");
			equipe1.setLimiteParticipantes(3);
			equipe1.setGame(fifa);
			equipe1.setPlataforma("PS5");
			equipe1.setNivel("amador");
				
			equipe1.setGamers(gamer1);
			equipe1.setGamers(gamer2);
			equipe1.setGamers(gamer3);
			
			Gamer.setGamersTotal(gamer1);
			Gamer.setGamersTotal(gamer2);
			Gamer.setGamersTotal(gamer3);
		
//			for(Gamer gamer : Gamer.getGamersTotal()) {
//				for(Game game : gamer.getGames()) System.out.println(game.getNome());
//			}
			
			System.out.println(fifa.getNome());
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

}
