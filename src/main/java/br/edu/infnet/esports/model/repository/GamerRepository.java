package br.edu.infnet.esports.model.repository;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import br.edu.infnet.esports.model.domain.Gamer;

@Repository
public class GamerRepository {
//	private static Integer id = 1;
	private static Map<Integer, Gamer> mapaGamer = new HashMap<Integer, Gamer>();;
	
	
	public boolean incluir(Gamer gamer) {
//		gamer.setId(id++);
		try {
			mapaGamer.put(gamer.getId(), gamer);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public Gamer excluir(Integer key) {
		return mapaGamer.remove(key);
	}
	
	public Gamer obterGamerById(Integer key) {
		return mapaGamer.get(key);
	}
	
	public Collection<Gamer> obterLista() {
		return mapaGamer.values();
	}
	
	 
}
