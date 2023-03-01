package br.edu.infnet.esports.model.repository;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import br.edu.infnet.esports.model.domain.Usuario;

@Repository
public class UsuarioRepository {
	
	private static Integer id = 1;
	private static Map<Integer, Usuario> mapaUsuario = new HashMap<Integer, Usuario>();
	
	public boolean incluir(Usuario usuario) {
		usuario.setId(id++);
		try {
			mapaUsuario.put(usuario.getId(), usuario);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public Usuario excluir(Integer key) {
		return mapaUsuario.remove(key);
	}
	
	public Usuario obterUsuarioById(Integer key) {
		return mapaUsuario.get(key);
	}
	
	public Collection<Usuario> obterLista() {
		return mapaUsuario.values();
	}
	 
}
