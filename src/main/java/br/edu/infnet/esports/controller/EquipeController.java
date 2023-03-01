package br.edu.infnet.esports.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.edu.infnet.esports.model.domain.Equipe;
import br.edu.infnet.esports.model.repository.EquipeRepository;
import br.edu.infnet.esports.model.repository.GameRepository;
import br.edu.infnet.esports.model.repository.GamerRepository;

@Controller
public class EquipeController {

	private String msg;

	@GetMapping(value = "/equipe")
	public String telaCadastro(Model model) {
		model.addAttribute("gamers", GamerRepository.obterLista());
		model.addAttribute("games", GameRepository.obterLista());
		return "equipe/cadastro";
	}

	@GetMapping(value = "/equipe/lista")
	public String telaLista(Model model) {

		model.addAttribute("equipes", EquipeRepository.obterLista());
		model.addAttribute("mensagem", msg);
		msg = null;
		return "equipe/lista";
	}

	@PostMapping(value = "/equipe/incluir")
	public String incluir(Model model, @RequestParam String nome, @RequestParam int limiteParticipantes,
			@RequestParam String gameId, @RequestParam String multiplataforma, @RequestParam String nivel,
			@RequestParam String gamerId) {
		try {
			Equipe equipe = new Equipe(nome, limiteParticipantes, Boolean.parseBoolean(multiplataforma), nivel);
			equipe.setGame(GameRepository.obterGameById(Integer.parseInt(gameId)));
			for(String j : gamerId.split(",")) {
				equipe.setGamers(GamerRepository.obterGamerById(Integer.parseInt(j)));
			}
			
			EquipeRepository.incluir(equipe);
			msg = "Equipe " + equipe.getNome() + " cadastrada com sucesso";
			return "redirect:/equipe/lista";
		} catch (Exception e) {
			model.addAttribute("mensagemError", e.getMessage());
		}
		return telaCadastro(model);
	}

	@GetMapping(value = "/equipe/{id}/excluir")
	public String excluir(@PathVariable Integer id) {
		Equipe equipe = EquipeRepository.excluir(id);
		msg = "Equipe " + equipe.getNome() + " removida com sucesso";

		return "redirect:/equipe/lista";
	}

}
