package br.edu.infnet.esports.model.tests;

import java.util.ArrayList;
import java.util.List;

import br.edu.infnet.esports.model.domain.*;

public class GamerTeste {

	public static void main(String[] args) {
		
		try {
			List<Game> gamesLuis = new ArrayList<Game>();
			
			gamesLuis.add(new Fifa("PS5"));
			
			Gamer gamerLuis = new Gamer("Luis", "luisinho@esports.com", 9, gamesLuis);
			
			System.out.println(gamerLuis);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			List<Game> gamesFelipe = new ArrayList<Game>();
			
			gamesFelipe.add(new Fifa("PS5"));
			gamesFelipe.add(new CsGo("PC"));
			
			Gamer gamerFelipe = new Gamer("Felipe", "felipinho@esports.com", 9, gamesFelipe);
			
			System.out.println(gamerFelipe);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			List<Game> gamesBarbosa = new ArrayList<Game>();
			
			gamesBarbosa.add(new Dungeons("PS5"));
			gamesBarbosa.add(new Fifa("PS5"));
			gamesBarbosa.add(new CsGo("PC"));
			
			Gamer gamerBarbosa= new Gamer("Barbosa", "barbosinha@esports.com", 9, gamesBarbosa);
			
			System.out.println(gamerBarbosa);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
	}

}
