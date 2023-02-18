//package br.edu.infnet.esports.model.tests;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import br.edu.infnet.esports.model.auxiliar.Constante;
//import br.edu.infnet.esports.model.domain.*;
//import br.edu.infnet.esports.model.exceptions.EmailInvalidoException;
//
//public class GamerTeste {
//
//	public static void main(String[] args) {
//		
//		try {
//			List<Game> gamesLuis = new ArrayList<Game>();
//			
//			gamesLuis.add(new Fifa(Constante.PLATAFORMA_PS5));
//			
//			Gamer gamerLuis = new Gamer("Luis", "luisinho@esports.com", "luisinho@esports.com", gamesLuis);
//			
//			System.out.println(gamerLuis);
//			
//		} catch (EmailInvalidoException e) {
//			System.out.println("[ERRO] " + e.getMessage());
//		}
//		
//		try {
//			List<Game> gamesFelipe = new ArrayList<Game>();
//			
//			gamesFelipe.add(new Fifa(Constante.PLATAFORMA_PS5));
//			gamesFelipe.add(new CsGo(Constante.PLATAFORMA_PC));
//			
//			Gamer gamerFelipe = new Gamer("Felipe", "felipinho@esports.com", "felipinho@esports.com", gamesFelipe);
//			
//			System.out.println(gamerFelipe);
//			
//		} catch (EmailInvalidoException e) {
//			System.out.println("[ERRO] " + e.getMessage());
//		}
//		
//		try {
//			List<Game> gamesBarbosa = new ArrayList<Game>();
//			
//			gamesBarbosa.add(new Dungeons(Constante.PLATAFORMA_PS5));
//			gamesBarbosa.add(new Fifa(Constante.PLATAFORMA_PS5));
//			gamesBarbosa.add(new CsGo(Constante.PLATAFORMA_PC));
//			
//			Gamer gamerBarbosa= new Gamer("Barbosa", "barbosinha@hotmail.com", "barbosinha@hotmail.com", gamesBarbosa);
//			
//			System.out.println(gamerBarbosa);
//			
//		} catch (EmailInvalidoException e) {
//			System.out.println("[ERRO] " + e.getMessage());
//		}
//		
//		
//	}
//
//}
