package br.edu.infnet.esports;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.edu.infnet.esports.model.domain.Usuario;
import br.edu.infnet.esports.model.service.UsuarioService;

@Component
public class UsuarioLoader implements ApplicationRunner {

	@Autowired
	private UsuarioService usuarioService;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		Usuario usuario = new Usuario("Luis", "luis@esports.com", "123", "gamer");
		usuario.setId(1);
		
		usuarioService.incluir(usuario);
		System.out.println("Inclusão do usuário @" + usuario.getUsername() + " realizada com sucesso!");
	}
}
