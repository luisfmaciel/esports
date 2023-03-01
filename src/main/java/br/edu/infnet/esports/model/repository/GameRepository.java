package br.edu.infnet.esports.model.repository;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import br.edu.infnet.esports.model.domain.Game;
import br.edu.infnet.esports.model.domain.Gamer;

public class GameRepository {
	
	private static Integer id = 1;
	private static Map<Integer, Game> mapaGame = new HashMap<Integer, Game>();
	
	public static boolean incluir(Game game) {
		game.setId(id++);
		try {
			mapaGame.put(game.getId(), game);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public static Game excluir(Integer key) {
		return mapaGame.remove(key);
	}
	
	public static Game obterGameById(Integer key) {
		return mapaGame.get(key);
	}
	
	public static Collection<Game> obterLista() {
		return mapaGame.values();
	}
	 
}
