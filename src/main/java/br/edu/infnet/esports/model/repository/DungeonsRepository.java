package br.edu.infnet.esports.model.repository;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import br.edu.infnet.esports.model.domain.Dungeons;

@Repository
public class DungeonsRepository {
	
//	private static Integer id = 1;
	private static Map<Integer, Dungeons> mapaDungeons = new HashMap<Integer, Dungeons>();
	
	public boolean incluir(Dungeons dungeons) {
//		dungeons.setId(id++);
		try {
			mapaDungeons.put(dungeons.getId(), dungeons);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public Dungeons excluir(Integer key) {
		return mapaDungeons.remove(key);
	}
	
	public Collection<Dungeons> obterLista() {
		return mapaDungeons.values();
	}
	 
}
