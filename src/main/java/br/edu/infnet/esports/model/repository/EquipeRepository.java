package br.edu.infnet.esports.model.repository;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import br.edu.infnet.esports.model.domain.Equipe;

public class EquipeRepository {
	
	private static Integer id = 1;
	private static Map<Integer, Equipe> mapaEquipe = new HashMap<Integer, Equipe>();
	
	public static boolean incluir(Equipe equipe) {
		equipe.setId(id++);
		try {
			mapaEquipe.put(equipe.getId(), equipe);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public static Equipe excluir(Integer key) {
		return mapaEquipe.remove(key);
	}
	
	public static Collection<Equipe> obterLista() {
		return mapaEquipe.values();
	}
	 
}
