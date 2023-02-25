package br.edu.infnet.esports.model.repository;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import br.edu.infnet.esports.model.domain.Dungeons;

public class DungeonsRepository {
	
	private static Integer id = 1;
	private static Map<Integer, Dungeons> mapaDungeons = new HashMap<Integer, Dungeons>();
	
	public static boolean incluir(Dungeons dungeons) {
		dungeons.setId(id++);
		try {
			mapaDungeons.put(dungeons.getId(), dungeons);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public static Dungeons excluir(Integer key) {
		return mapaDungeons.remove(key);
	}
	
	public static Collection<Dungeons> obterLista() {
		return mapaDungeons.values();
	}
	 
}
