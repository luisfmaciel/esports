package br.edu.infnet.esports.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.infnet.esports.model.domain.CsGo;

@Controller
public class CsgoController {

	@GetMapping(value = "/game/csgo")
	public String telaCadastro() {
		return "game/csgo/cadastro";
	}

	@PostMapping(value = "/game/csgo/incluir")
	public String incluir(CsGo csgo) {
		System.out.println("Inclusão realizada com sucesso!: " + csgo);	
		return "redirect:/";
	}
}
