package br.edu.infnet.esports.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.SessionAttribute;

import br.edu.infnet.esports.model.domain.Game;
import br.edu.infnet.esports.model.domain.Usuario;
import br.edu.infnet.esports.model.service.GameService;

@Controller
public class GameController {

	@Autowired
	private GameService gameService;
	
	private String msg;
	
	@GetMapping(value = "/game")
	public String telaIndex(Model model, @SessionAttribute("user") Usuario usuario) {
		model.addAttribute("gamesEstatisticas", gameService.obterLista(usuario));
		model.addAttribute("mensagem", msg);
		
		msg = null;
		
		return "game/lista";
	}
	
	@GetMapping(value = "/game/{id}/excluir")
	public String excluir(@PathVariable Integer id) {
		Game game = gameService.obterGameById(id);
		
		gameService.excluir(id);
		msg = "O Game " + game.getNome() + " - ID: " + game.getId() + " - foi removido com sucesso";

		return "redirect:/game";
	}
}
