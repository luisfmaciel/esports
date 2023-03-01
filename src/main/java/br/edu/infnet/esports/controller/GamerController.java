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

import br.edu.infnet.esports.model.domain.Game;
import br.edu.infnet.esports.model.domain.Gamer;
import br.edu.infnet.esports.model.domain.Usuario;
import br.edu.infnet.esports.model.exceptions.EmailInvalidoException;
import br.edu.infnet.esports.model.exceptions.ValorLimiteUltrapassadoException;
import br.edu.infnet.esports.model.repository.GameRepository;
import br.edu.infnet.esports.model.repository.GamerRepository;
import br.edu.infnet.esports.model.repository.UsuarioRepository;
import br.edu.infnet.esports.model.service.UsuarioService;

@Controller
public class GamerController {
	
	@Autowired
	private UsuarioService usuarioService;
	private String msg;

	@GetMapping(value = "/gamer")
	public String telaCadastro(Model model) {
		model.addAttribute("usuarios", usuarioService.obterLista());
		model.addAttribute("games", GameRepository.obterLista());
		return "gamer/cadastro";
	}

	@GetMapping(value = "/gamer/lista")
	public String telaLista(Model model) {
		model.addAttribute("gamers", GamerRepository.obterLista());
		model.addAttribute("mensagem", msg);
		msg = null;

		return "gamer/lista";
	}

	@PostMapping(value = "/gamer/incluir")
	public String incluir(Model model, @RequestParam String usuarioId, String gameId)
			throws EmailInvalidoException, NumberFormatException, ValorLimiteUltrapassadoException {

		List<Game> meusJogos = new ArrayList<Game>();
		Usuario user = usuarioService.obterUsuarioById(Integer.parseInt(usuarioId));

		for (String g : gameId.split(",")) {
			meusJogos.add(GameRepository.obterGameById(Integer.parseInt(g)));
		}

		Gamer gamer = new Gamer();		
		gamer.setNome(user.getNome());
		gamer.setEmail(user.getEmail());
		gamer.setSenha(user.getSenha());
		gamer.setPerfil(user.getPerfil());
		gamer.setGames(meusJogos);

		GamerRepository.incluir(gamer);
		return "redirect:/gamer/lista";
	}

	@GetMapping(value = "/gamer/{id}/excluir")
	public String excluir(@PathVariable Integer id) {
		GamerRepository.excluir(id);
		msg = "Gamer removido com sucesso";

		return "redirect:/gamer/lista";
	}

}
