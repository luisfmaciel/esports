package br.edu.infnet.esports.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.edu.infnet.esports.model.auxiliar.Constante;
import br.edu.infnet.esports.model.domain.Game;
import br.edu.infnet.esports.model.repository.GameRepository;
import br.edu.infnet.esports.model.repository.GamerRepository;

@Controller
public class GameController {

	@GetMapping(value = "/game")
	public String telaIndex(Model model) {
		model.addAttribute("gamesEstatisticas", GameRepository.obterLista());
		
		return "game/index";
	}
	
//	@GetMapping(value = "/game/{id}/excluir")
//	public String excluir(@PathVariable Integer id) {
////		Game game = GameRepository.obterGameById(id);
////		
////		if(game.getNome() == Constante.GAME_CSGO) return "redirect:/game/csgo/"+id+"/excluir";
////		else if(game.getNome() == Constante.GAME_FIFA) return "redirect:/game/fifa/"+id+"/excluir";
////		else if(game.getNome() == Constante.GAME_DUNGEONS) return "redirect:/game/dungeons/"+id+"/excluir";
//	
//		GameRepository.excluir(id);
////		msg = "Gamer removido com sucesso";
//
//		return "redirect:/gamer/lista";
//	}
}
