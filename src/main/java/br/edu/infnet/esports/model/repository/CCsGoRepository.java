package br.edu.infnet.esports.model.repository;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import br.edu.infnet.esports.model.domain.CsGo;

@Repository
public class CCsGoRepository {
	
//	private static Integer id = 1;
	private static Map<Integer, CsGo> mapaCsGo = new HashMap<Integer, CsGo>();
	
	public boolean incluir(CsGo csgo) {
//		csgo.setId(id++);
		try {
			mapaCsGo.put(csgo.getId(), csgo);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public CsGo excluir(Integer key) {
		return mapaCsGo.remove(key);
	}
	
	public Collection<CsGo> obterLista() {
		return mapaCsGo.values();
	}
	 
}
