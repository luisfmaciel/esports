package br.edu.infnet.esports.model.repository;

import br.edu.infnet.esports.model.domain.Usuario;
import br.edu.infnet.esports.model.exceptions.EmailInvalidoException;

public class AcessoRepository {
	
	public static Usuario autenticar(Usuario usuario) throws EmailInvalidoException {
		if(usuario.getEmail().equalsIgnoreCase(usuario.getSenha())) {
			Usuario newUsuario = new Usuario();
			newUsuario.setNome(usuario.getNome());
			newUsuario.setEmail(usuario.getEmail());
			newUsuario.setSenha(usuario.getSenha());
			return newUsuario;
		}
		return null;
	}
}
