package br.edu.infnet.esports.model.repository;
import java.util.ArrayList;
import java.util.List;
import br.edu.infnet.esports.model.domain.Gamer;

public class GamerRepository {
	
	private static List<Gamer> lista = new ArrayList<Gamer>();
	
	public static boolean incluir(Gamer gamer) {
		try {
			lista.add(gamer);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public static List<Gamer> obterLista() {
		return lista;
	}
	 
}
