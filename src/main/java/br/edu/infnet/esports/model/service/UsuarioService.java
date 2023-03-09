package br.edu.infnet.esports.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.esports.model.domain.Usuario;
import br.edu.infnet.esports.model.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public Usuario incluir(Usuario usuario) {
//		return usuarioRepository.incluir(usuario);
		return usuarioRepository.save(usuario);
	
	}
	
	public void excluir(Integer key) {
//		return usuarioRepository.excluir(key);
		usuarioRepository.deleteById(key);
	}
	
	public Usuario obterUsuarioById(Integer key) {
		return usuarioRepository.findById(key).get();
	}
	
	public Collection<Usuario> obterLista() {
		return (Collection<Usuario>) usuarioRepository.findAll();
	}
}
