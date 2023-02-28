package br.edu.infnet.esports.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.edu.infnet.esports.model.domain.Fifa;
import br.edu.infnet.esports.model.domain.Fifa;
import br.edu.infnet.esports.model.exceptions.ValorLimiteUltrapassadoException;
import br.edu.infnet.esports.model.repository.FifaRepository;
import br.edu.infnet.esports.model.repository.GameRepository;
import br.edu.infnet.esports.model.repository.FifaRepository;

@Controller
public class FifaController {
	private String msg;
	
	@GetMapping(value = "/game/fifa")
	public String telaCadastro() {
		return "game/fifa/cadastro";
	}
	
	@GetMapping(value = "/game/fifa/lista")
	public String telaLista(Model model) {
		
		model.addAttribute("fifaEstatisticas", FifaRepository.obterLista());
		model.addAttribute("mensagem", msg);
		msg = null;
		return "game/fifa/lista";
	}

	@PostMapping(value = "/game/fifa/incluir")
	public String incluir(Model model, @RequestParam String plataforma, @RequestParam int titulos,
			@RequestParam float finalizacao, @RequestParam float marcacao, @RequestParam float passe) {
		try {
			Fifa fifa = new Fifa(plataforma);
			fifa.setTitulos(titulos);
			fifa.setFinalizacao(finalizacao);
			fifa.setMarcacao(marcacao);
			fifa.setPasse(passe);
			fifa.setMediaEstatistica(fifa.calculaMediaEstatisticaGamer());
			fifa.setNivel(fifa.identificaNivelGamer());
			
			FifaRepository.incluir(fifa);
			GameRepository.incluir(fifa);
			msg = "Estatísticas cadastradas com sucesso";

			return "redirect:/game/fifa/lista";
		} catch (ValorLimiteUltrapassadoException e) {
			model.addAttribute("mensagemError", e.getMessage());
		}
		
		return telaCadastro();
	}
	
	@GetMapping(value = "/game/fifa/{id}/excluir" )
	public String excluir(@PathVariable Integer id) {
		FifaRepository.excluir(id);
		msg = "Estatísticas removidas com sucesso";
	
		return "redirect:/game/fifa/lista";
	}
	
}
