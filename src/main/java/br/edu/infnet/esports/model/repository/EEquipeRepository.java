package br.edu.infnet.esports.model.repository;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import br.edu.infnet.esports.model.domain.Equipe;

@Repository
public class EEquipeRepository {
	
	private static Integer id = 1;
	private static Map<Integer, Equipe> mapaEquipe = new HashMap<Integer, Equipe>();
	
	public boolean incluir(Equipe equipe) {
		equipe.setId(id++);
		try {
			mapaEquipe.put(equipe.getId(), equipe);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public Equipe excluir(Integer key) {
		return mapaEquipe.remove(key);
	}
	
	public Collection<Equipe> obterLista() {
		return mapaEquipe.values();
	}
	 
}
