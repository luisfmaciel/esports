package br.edu.infnet.esports.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.edu.infnet.esports.model.domain.Usuario;
import br.edu.infnet.esports.model.exceptions.EmailInvalidoException;
import br.edu.infnet.esports.model.repository.AcessoRepository;

@Controller
public class AcessoController {
	@GetMapping(value = "/login")
	public String telaLogin() {
		return "login";
	}
	
	@PostMapping(value = "/login")
	public String login(@RequestParam String email, @RequestParam String senha) throws EmailInvalidoException {

		Usuario usuario = new Usuario();
		usuario.setEmail(email);
		usuario.setSenha(senha);
		
		if(AcessoRepository.autenticar(usuario) != null) {
			return "redirect:/home";
		}
		return "redirect:/login";
	}
}
