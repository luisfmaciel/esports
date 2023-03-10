package br.edu.infnet.esports.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import br.edu.infnet.esports.model.domain.Game;
import br.edu.infnet.esports.model.domain.Gamer;
import br.edu.infnet.esports.model.domain.Usuario;
import br.edu.infnet.esports.model.exceptions.EmailInvalidoException;
import br.edu.infnet.esports.model.exceptions.ValorLimiteUltrapassadoException;
import br.edu.infnet.esports.model.service.GameService;
import br.edu.infnet.esports.model.service.GamerService;
import br.edu.infnet.esports.model.service.UsuarioService;

@Controller
public class GamerController {

	@Autowired
	private UsuarioService usuarioService;
	@Autowired
	private GameService gameService;
	@Autowired
	private GamerService gamerService;

	private String msg;

	@GetMapping(value = "/gamer")
	public String telaCadastro(Model model) {
		model.addAttribute("usuarios", usuarioService.obterLista());
		model.addAttribute("games", gameService.obterLista());
		return "gamer/cadastro";
	}

	@GetMapping(value = "/gamer/lista")
	public String telaLista(Model model, @SessionAttribute("user") Usuario usuario) {
		model.addAttribute("gamers", gamerService.obterLista(usuario));
		model.addAttribute("mensagem", msg);
		msg = null;

		return "gamer/lista";
	}

	@PostMapping(value = "/gamer/incluir")
	public String incluir(Model model, @RequestParam String nome, @RequestParam String email,
			@RequestParam String usuarioId, @RequestParam String gameId, @SessionAttribute("user") Usuario usuario)
			throws EmailInvalidoException, NumberFormatException, ValorLimiteUltrapassadoException {
		List<Game> meusJogos = new ArrayList<Game>();
//		Usuario user = usuarioService.obterUsuarioById(Integer.parseInt(usuarioId));

		for (String g : gameId.split(",")) {
			meusJogos.add(gameService.obterGameById(Integer.parseInt(g)));
		}

		Gamer gamer = new Gamer();
		gamer.setNome(nome);
		gamer.setEmail(email);
		gamer.setUsuario(usuario);
		gamer.setGames(meusJogos);

		gamerService.incluir(gamer);
		return "redirect:/gamer/lista";
	}

	@GetMapping(value = "/gamer/{id}/excluir")
	public String excluir(@PathVariable Integer id) {
		gamerService.excluir(id);
		msg = "Gamer removido com sucesso";

		return "redirect:/gamer/lista";
	}

}
