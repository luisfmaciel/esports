package br.edu.infnet.esports.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.infnet.esports.model.domain.Gamer;

@Controller
public class GamerController {

	@GetMapping(value = "/gamer")
	public String telaCadastro() {
		return "gamer/cadastro";
	}

	@PostMapping(value = "/gamer/incluir")
	public String incluir(Gamer gamer) {
		System.out.println("Inclusão realizada com sucesso!: " + gamer);	
		return "redirect:/";
	}
}
