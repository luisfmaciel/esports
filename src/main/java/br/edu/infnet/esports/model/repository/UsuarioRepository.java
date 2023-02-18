package br.edu.infnet.esports.model.repository;
import java.util.ArrayList;
import java.util.List;
import br.edu.infnet.esports.model.domain.Usuario;

public class UsuarioRepository {
	
	private static List<Usuario> lista = new ArrayList<Usuario>();
	
	public static boolean incluir(Usuario usuario) {
		try {
			lista.add(usuario);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public static List<Usuario> obterLista() {
		return lista;
	}
	 
}
