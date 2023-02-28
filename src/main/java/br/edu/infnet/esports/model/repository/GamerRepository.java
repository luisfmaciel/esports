package br.edu.infnet.esports.model.repository;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import br.edu.infnet.esports.model.domain.Gamer;

public class GamerRepository {
	private static Integer id = 1;
	private static Map<Integer, Gamer> mapaGamer = new HashMap<Integer, Gamer>();;
	
	
	public static boolean incluir(Gamer gamer) {
		gamer.setId(id++);
		try {
			mapaGamer.put(gamer.getId(), gamer);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public static Gamer excluir(Integer key) {
		return mapaGamer.remove(key);
	}
	
	public static Collection<Gamer> obterLista() {
		return mapaGamer.values();
	}
	
	 
}
