package br.edu.infnet.esports.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.edu.infnet.esports.model.domain.Usuario;
import br.edu.infnet.esports.model.exceptions.EmailInvalidoException;
import br.edu.infnet.esports.model.repository.UsuarioRepository;

@Controller
public class UsuarioController {
	@GetMapping(value = "/usuario")
	public String telaCadastro() {
		return "usuario/cadastro";
	}

	@GetMapping(value = "/usuario/lista")
	public String telaLista() {
		List<Usuario> lista = UsuarioRepository.obterLista();
		
		for(Usuario usuario: lista) {
			System.out.printf("%s - %s\n", usuario.getUsername(), usuario.getEmail());
		}
		
		return "usuario/lista";
	}

	@PostMapping(value = "/usuario/incluir")
	public String incluir(
			@RequestParam String nome,
			@RequestParam String email,
			@RequestParam String senha,
			@RequestParam String perfil
	) throws EmailInvalidoException {
		Usuario usuario = new Usuario();
		
		usuario.setNome(nome);
		usuario.setEmail(email);
		usuario.setSenha(senha);
		usuario.setPerfil(perfil);
		
		System.out.println("Inclusão realizada com sucesso: " + usuario);
		UsuarioRepository.incluir(usuario);
		return "redirect:/usuario/lista";
	}
}
