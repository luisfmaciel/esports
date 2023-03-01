package br.edu.infnet.esports.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import br.edu.infnet.esports.model.service.GameService;

@Controller
public class GameController {

	private GameService gameService;
	
	@GetMapping(value = "/game")
	public String telaIndex(Model model) {
		model.addAttribute("gamesEstatisticas", gameService.obterLista());
		
		return "game/index";
	}
}
