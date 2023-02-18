//package br.edu.infnet.esports.model.tests;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import br.edu.infnet.esports.model.auxiliar.Constante;
//import br.edu.infnet.esports.model.domain.*;
//import br.edu.infnet.esports.model.exceptions.EmailInvalidoException;
//import br.edu.infnet.esports.model.exceptions.EquipeCompletaException;
//import br.edu.infnet.esports.model.exceptions.GameNaoEncontradoException;
//import br.edu.infnet.esports.model.exceptions.NivelDiferenteException;
//import br.edu.infnet.esports.model.exceptions.PlatformaDiferenteException;
//import br.edu.infnet.esports.model.exceptions.ValorLimiteUltrapassadoException;
//
//public class EquipeTeste {
//
//	public static void main(String[] args) {
//		List<Game> gamesLuis = new ArrayList<Game>();
//		List<Game> gamesFelipe = new ArrayList<Game>();
//		List<Game> gamesBarbosa = new ArrayList<Game>();
//		
//		Gamer gamerLuis = null;
//		Gamer gamerFelipe = null;
//		Gamer gamerBarbosa = null;
//		
//		Equipe equipeFutiba = null;
//
//		try {
//			Fifa fifaLuis = new Fifa(Constante.PLATAFORMA_PS5);
//			fifaLuis.setFinalizacao(9);
//			fifaLuis.setMarcacao(7);
//			fifaLuis.setPasse(8);
//			fifaLuis.setTitulos(8);
//			fifaLuis.setMediaEstatistica(fifaLuis.calculaMediaEstatisticaGamer());
//			fifaLuis.setNivel(fifaLuis.identificaNivelGamer());
//			
//			gamesLuis.add(fifaLuis);
//			
//			gamerLuis = new Gamer("Luis", "luisinho@esports.com", "luisinho@esports.com", gamesLuis);
//	
//			equipeFutiba = new Equipe("Futiba", 2, true, Constante.PROFISSIONAL, new Fifa(Constante.PLATAFORMA_PS5));
//			equipeFutiba.setGamers(gamerLuis);
//			
//			equipeFutiba.imprimir();
//		} catch (ValorLimiteUltrapassadoException 
//				| EmailInvalidoException 
//				| GameNaoEncontradoException 
//				| EquipeCompletaException 
//				| NivelDiferenteException 
//				| PlatformaDiferenteException e) {
//			System.out.println("[ERRO] " + e.getMessage());
//		}
//		
//		try {
//			Fifa fifaFelipe = new Fifa(Constante.PLATAFORMA_PC);
//			fifaFelipe.setFinalizacao(3);
//			fifaFelipe.setMarcacao(1);
//			fifaFelipe.setPasse(2);
//			fifaFelipe.setTitulos(1);
//			fifaFelipe.setMediaEstatistica(fifaFelipe.calculaMediaEstatisticaGamer());
//			fifaFelipe.setNivel(fifaFelipe.identificaNivelGamer());
//			gamesFelipe.add(fifaFelipe);
//
//			gamerFelipe = new Gamer("Felipe", "felipinho@esports.com", "felipinho@esports.com", gamesFelipe);
//
//			equipeFutiba.setGamers(gamerFelipe);
//			
//			equipeFutiba.imprimir();
//			
//		} catch (ValorLimiteUltrapassadoException 
//				| EmailInvalidoException 
//				| GameNaoEncontradoException 
//				| EquipeCompletaException 
//				| NivelDiferenteException 
//				| PlatformaDiferenteException   e) {
//			System.out.println("[ERRO] " + e.getMessage());
//		}
//		
//		try {
//			Fifa fifaBarbosa = new Fifa(Constante.PLATAFORMA_XBOXONE);
//			fifaBarbosa.setFinalizacao(9);
//			fifaBarbosa.setMarcacao(7);
//			fifaBarbosa.setPasse(8);
//			fifaBarbosa.setTitulos(11);
//			fifaBarbosa.setMediaEstatistica(fifaBarbosa.calculaMediaEstatisticaGamer());
//			fifaBarbosa.setNivel(fifaBarbosa.identificaNivelGamer());
//			gamesBarbosa.add(fifaBarbosa);
//			
//			gamerBarbosa = new Gamer("Barbosa", "barbosinha@esports.com", "barbosinha@esports.com", gamesBarbosa);
//			
//			equipeFutiba.setGamers(gamerBarbosa);
//			
//			equipeFutiba.imprimir();
//			
//		} catch (ValorLimiteUltrapassadoException 
//				| EmailInvalidoException 
//				| GameNaoEncontradoException 
//				| EquipeCompletaException 
//				| NivelDiferenteException 
//				| PlatformaDiferenteException e) {
//			System.out.println("[ERRO] " + e.getMessage());
//		}
//	}
//}
