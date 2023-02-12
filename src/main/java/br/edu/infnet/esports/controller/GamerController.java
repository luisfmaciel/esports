package br.edu.infnet.esports.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.edu.infnet.esports.model.domain.CsGo;
import br.edu.infnet.esports.model.domain.Dungeons;
import br.edu.infnet.esports.model.domain.Fifa;
import br.edu.infnet.esports.model.domain.Game;
import br.edu.infnet.esports.model.domain.Gamer;
import br.edu.infnet.esports.model.exceptions.EmailInvalidoException;
import br.edu.infnet.esports.model.repository.GamerRepository;

@Controller
public class GamerController {

	@GetMapping(value = "/gamer")
	public String telaCadastro() {
		return "gamer/cadastro";
	}

	@GetMapping(value = "/gamer/lista")
	public String telaLista() {
		List<Gamer> lista = GamerRepository.obterLista();
		
		for(Gamer gamer : lista) {
			System.out.printf("%s - %s\n", gamer.getUsername(), gamer.getEmail());
		}
		
		return "gamer/lista";
	}
	
	@PostMapping(value = "/gamer/incluir")
	public String incluir(
			@RequestParam String nome,
			@RequestParam String email,
			@RequestParam String senha,
			@RequestParam(value = "PS5", required = false) String PS5,
			@RequestParam(value = "Xbox", required = false) String Xbox,
			@RequestParam(value = "PC", required = false) String PC
	) throws EmailInvalidoException {
		Gamer gamer = new Gamer();
		List<Game> games = new ArrayList<Game>();
		
		gamer.setNome(nome);
		gamer.setEmail(email);
		gamer.setSenha(senha);
		
		instanciaGame(games, PS5, "PS5");
		instanciaGame(games, Xbox, "Xbox One");
		instanciaGame(games, PC, "PC");
		
		gamer.setGames(games);
		
		System.out.println("Inclusão realizada com sucesso: " + gamer);
		GamerRepository.incluir(gamer);
		return "redirect:/gamer/lista";
	}
	
	private void instanciaGame(List<Game> games, String selectedGames, String plataforma) {
		if(selectedGames != null) {
			String[] listGames = selectedGames.split(",");
			for(String game : listGames) {
				Game newGame = null;
				switch (game) {
				case "Csgo": {
					newGame = new CsGo(plataforma);
					break;
				}
				case "Fifa": {
					newGame = new Fifa(plataforma);
					break;
				}
				case "Dungeons": {
					newGame = new Dungeons(plataforma);
					break;
				}
				default:
					break;
				}
				games.add(newGame);
			}
		}
	}
}
