package br.edu.infnet.esports.model.repository;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import br.edu.infnet.esports.model.domain.Fifa;

public class FifaRepository {
	
	private static Integer id = 1;
	private static Map<Integer, Fifa> mapaFifa = new HashMap<Integer, Fifa>();
	
	public static boolean incluir(Fifa fifa) {
		fifa.setId(id++);
		try {
			mapaFifa.put(fifa.getId(), fifa);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public static Fifa excluir(Integer key) {
		return mapaFifa.remove(key);
	}
	
	public static Collection<Fifa> obterLista() {
		return mapaFifa.values();
	}
	 
}
