package br.edu.infnet.esports.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.edu.infnet.esports.model.domain.Equipe;
import br.edu.infnet.esports.model.exceptions.CampoVazioException;
import br.edu.infnet.esports.model.service.EquipeService;
import br.edu.infnet.esports.model.service.GameService;
import br.edu.infnet.esports.model.service.GamerService;

@Controller
public class EquipeController {

	@Autowired
	private EquipeService equipeService;
	@Autowired
	private GameService gameService;
	@Autowired
	private GamerService gamerService;

	private String msg;

	@GetMapping(value = "/equipe")
	public String telaCadastro(Model model) {
	
		model.addAttribute("gamers", gamerService.obterLista());
		model.addAttribute("games", gameService.obterLista());
		return "equipe/cadastro";
	}

	@GetMapping(value = "/equipe/lista")
	public String telaLista(Model model) {

		model.addAttribute("equipes", equipeService.obterLista());
		model.addAttribute("mensagem", msg);
		msg = null;
		return "equipe/lista";
	}

	@PostMapping(value = "/equipe/incluir")
	public String incluir(Model model, @RequestParam String nome, @RequestParam String limiteParticipantes,
			@RequestParam String game, @RequestParam String plataforma, @RequestParam String multiplataforma,
			@RequestParam String nivel, @RequestParam(required = false) String gamerId) {
		try {
			Equipe equipe = new Equipe();
			
			equipe.setNome(nome);
			equipe.setLimiteParticipantes(limiteParticipantes);
			equipe.setPlataforma(plataforma);
			equipe.setMultiPlataforma(Boolean.parseBoolean(multiplataforma));
			equipe.setNivel(nivel);
			equipe.setGame(gameService.obterGameByName(game));
			
			if(gamerId != null) {
				for (String j : gamerId.split(",")) {
					equipe.setGamers(gamerService.obterGamerById(Integer.parseInt(j)));
				}				
			} else {
				throw new CampoVazioException("O preenchimento do campo Gamers está inválido");
			}

			equipeService.incluir(equipe);
			msg = "Equipe " + equipe.getNome() + " cadastrada com sucesso";
			return "redirect:/equipe/lista";
		} catch (Exception e) {
			model.addAttribute("mensagemError", e.getMessage());
			System.out.println(e.getMessage());
		}
		return telaCadastro(model);
	}

	@GetMapping(value = "/equipe/{id}/excluir")
	public String excluir(@PathVariable Integer id) {
		equipeService.excluir(id);
		msg = "Equipe " + id + " removida com sucesso";

		return "redirect:/equipe/lista";
	}

}
