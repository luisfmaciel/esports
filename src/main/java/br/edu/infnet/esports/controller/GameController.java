package br.edu.infnet.esports.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import br.edu.infnet.esports.model.domain.Usuario;
import br.edu.infnet.esports.model.service.GameService;

@Controller
public class GameController {

	@Autowired
	private GameService gameService;
	
	@GetMapping(value = "/game")
	public String telaIndex(Model model, @SessionAttribute("user") Usuario usuario) {
//		model.addAttribute("gamesEstatisticas", gameService.obterLista(usuario));
		model.addAttribute("gamesEstatisticas", gameService.obterLista());
		return "game/index";
	}
}
