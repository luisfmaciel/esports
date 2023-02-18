package br.edu.infnet.esports.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GameController {

	@GetMapping(value = "/game")
	public String telaIndex() {
		return "game/index";
	}
	
}
