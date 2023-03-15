package br.edu.infnet.esports.model.repository;

import org.springframework.stereotype.Repository;

import br.edu.infnet.esports.model.domain.Usuario;
import br.edu.infnet.esports.model.exceptions.CampoVazioException;
import br.edu.infnet.esports.model.exceptions.EmailInvalidoException;

@Repository
public class AcessoRepository {
	
	public Usuario autenticar(Usuario usuario) throws EmailInvalidoException, CampoVazioException {
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
