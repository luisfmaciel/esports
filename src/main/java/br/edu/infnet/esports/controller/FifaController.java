package br.edu.infnet.esports.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.infnet.esports.model.domain.Fifa;

@Controller
public class FifaController {

	@GetMapping(value = "/game/fifa")
	public String telaCadastro() {
		return "game/fifa/cadastro";
	}

	@PostMapping(value = "/game/fifa/incluir")
	public String incluir(Fifa fifa) {
		System.out.println("Inclusão realizada com sucesso!: " + fifa);	
		return "redirect:/";
	}
}
