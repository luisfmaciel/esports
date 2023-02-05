package br.edu.infnet.esports.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.infnet.esports.model.domain.Equipe;

@Controller
public class EquipeController {

	@GetMapping(value = "/equipe")
	public String telaCadastro() {
		return "equipe/cadastro";
	}

	@PostMapping(value = "/equipe/incluir")
	public String incluir(Equipe equipe) {
		System.out.println("Inclusão realizada com sucesso!: " + equipe);	
		return "redirect:/";
	}
}
