package br.edu.infnet.esports.model.repository;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import br.edu.infnet.esports.model.domain.CsGo;

public class CsGoRepository {
	
	private static Integer id = 1;
	private static Map<Integer, CsGo> mapaCsGo = new HashMap<Integer, CsGo>();
	
	public static boolean incluir(CsGo csgo) {
		csgo.setId(id++);
		try {
			mapaCsGo.put(csgo.getId(), csgo);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public static CsGo excluir(Integer key) {
		return mapaCsGo.remove(key);
	}
	
	public static Collection<CsGo> obterLista() {
		return mapaCsGo.values();
	}
	 
}
