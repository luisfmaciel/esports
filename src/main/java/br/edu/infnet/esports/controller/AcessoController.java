package br.edu.infnet.esports.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.edu.infnet.esports.model.domain.Gamer;
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

		Gamer gamer = new Gamer();
		gamer.setEmail(email);
		gamer.setSenha(senha);
		
		if(AcessoRepository.autenticar(gamer) != null) {
			return "redirect:/home";
		}
		return "redirect:/login";
//		return "login";
	}
}
