package br.edu.infnet.esports.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import br.edu.infnet.esports.model.domain.Equipe;
import br.edu.infnet.esports.model.domain.Usuario;
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
	public String telaCadastro(Model model, @SessionAttribute("user") Usuario usuario) {

		model.addAttribute("gamers", gamerService.obterLista(usuario));
		model.addAttribute("games", gameService.obterLista(usuario));
		return "equipe/cadastro";
	}

	@GetMapping(value = "/equipe/lista")
	public String telaLista(Model model, @SessionAttribute("user") Usuario usuario) {

		model.addAttribute("equipes", equipeService.obterLista(usuario));
		model.addAttribute("mensagem", msg);
		msg = null;
		return "equipe/lista";
	}

	@PostMapping(value = "/equipe/incluir")
	public String incluir(Model model, @RequestParam String nome, @RequestParam String limiteParticipantes,
			@RequestParam String gameId, @RequestParam String multiplataforma,
			@RequestParam(required = false) String gamerId, @SessionAttribute("user") Usuario usuario) {
		try {
			Equipe equipe = new Equipe();
			equipe.setUsuario(usuario);
			equipe.setNome(nome);
			equipe.setLimiteParticipantes(limiteParticipantes);
			equipe.setNivel(gameService.obterGameById(Integer.parseInt(gameId)).getNivel());
			equipe.setPlataforma(gameService.obterGameById(Integer.parseInt(gameId)).getPlataforma());
			equipe.setMultiPlataforma(Boolean.parseBoolean(multiplataforma));
			equipe.setGame(gameService.obterGameById(Integer.parseInt(gameId)));

			if (gamerId != null) {
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
		return "redirect:/equipe";
	}

	@GetMapping(value = "/equipe/{id}/excluir")
	public String excluir(@PathVariable Integer id) {
		equipeService.excluir(id);
		msg = "Equipe " + id + " removida com sucesso";

		return "redirect:/equipe/lista";
	}

}
