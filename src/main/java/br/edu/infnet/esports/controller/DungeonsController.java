package br.edu.infnet.esports.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.infnet.esports.model.domain.Dungeons;

@Controller
public class DungeonsController {

	@GetMapping(value = "/game/dungeons")
	public String telaCadastro() {
		return "game/dungeons/cadastro";
	}

	@PostMapping(value = "/game/dungeons/incluir")
	public String incluir(Dungeons dungeons) {
		System.out.println("Inclusão realizada com sucesso!: " + dungeons);	
		return "redirect:/";
	}
}
