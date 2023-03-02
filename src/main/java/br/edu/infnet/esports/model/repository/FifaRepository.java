package br.edu.infnet.esports.model.repository;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import br.edu.infnet.esports.model.domain.Fifa;

@Repository
public class FifaRepository {
	
//	private static Integer id = 1;
	private static Map<Integer, Fifa> mapaFifa = new HashMap<Integer, Fifa>();
	
	public boolean incluir(Fifa fifa) {
//		fifa.setId();
		try {
			mapaFifa.put(fifa.getId(), fifa);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public Fifa excluir(Integer key) {
		return mapaFifa.remove(key);
	}
	
	public Collection<Fifa> obterLista() {
		return mapaFifa.values();
	}
	 
}
