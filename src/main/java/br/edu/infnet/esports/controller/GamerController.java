package br.edu.infnet.esports.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.edu.infnet.esports.model.domain.CsGo;
import br.edu.infnet.esports.model.domain.Dungeons;
import br.edu.infnet.esports.model.domain.Fifa;
import br.edu.infnet.esports.model.domain.Game;
import br.edu.infnet.esports.model.domain.Gamer;
import br.edu.infnet.esports.model.exceptions.EmailInvalidoException;
import br.edu.infnet.esports.model.exceptions.ValorLimiteUltrapassadoException;
import br.edu.infnet.esports.model.repository.GameRepository;
import br.edu.infnet.esports.model.repository.GamerRepository;
import br.edu.infnet.esports.model.repository.UsuarioRepository;

@Controller
public class GamerController {
	private String msg;
	
	@GetMapping(value = "/gamer")
	public String telaCadastro(Model model) {
		model.addAttribute("usuarios", UsuarioRepository.obterLista());
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
	public String incluir(Model model, @RequestParam String usuario, String game)
			throws EmailInvalidoException, NumberFormatException, ValorLimiteUltrapassadoException {
		String[] user = usuario.split(";");
		String[] games = game.split(",");
		List<Game> meusJogos = new ArrayList<Game>();

		for (String g : games) {
			String[] item = g.split(";");
			Game newGame = null;

			switch (item[0]) {
			case "CS:GO": {
				newGame = new CsGo();
				((CsGo) newGame).setPrecisao(Float.parseFloat(item[5]));
				((CsGo) newGame).setAgressividade(Float.parseFloat(item[6]));
				((CsGo) newGame).setTatica(Float.parseFloat(item[7]));
				break;
			}
			case "FIFA": {
				newGame = new Fifa();
				((Fifa) newGame).setFinalizacao(Float.parseFloat(item[5]));
				((Fifa) newGame).setMarcacao(Float.parseFloat(item[6]));
				((Fifa) newGame).setPasse(Float.parseFloat(item[7]));
				break;
			}
			case "DUNGEONS": {
				newGame = new Dungeons();
				((Dungeons) newGame).setDano(Float.parseFloat(item[5]));
				((Dungeons) newGame).setSabedoria(Float.parseFloat(item[6]));
				((Dungeons) newGame).setVelocidade(Float.parseFloat(item[7]));
				break;
			}
			default:
				break;
			}
			newGame.setNome(item[0]);
			newGame.setPlataforma(item[1]);
			newGame.setNivel(item[2]);
			newGame.setTitulos(Integer.parseInt(item[3]));
			newGame.setMediaEstatistica(Float.parseFloat(item[4]));
			meusJogos.add(newGame);
		}

		Gamer gamer = new Gamer();
		gamer.setNome(user[0]);
		gamer.setEmail(user[1]);
		gamer.setSenha(user[3]);
		gamer.setPerfil(user[4]);
		gamer.setGames(meusJogos);

		GamerRepository.incluir(gamer);
		return "redirect:/gamer/lista";
	}
	
	@GetMapping(value = "/gamer/{id}/excluir" )
	public String excluir(@PathVariable Integer id) {
		GamerRepository.excluir(id);
		msg = "Gamer removido com sucesso";
	
		return "redirect:/gamer/lista";
	}

}
