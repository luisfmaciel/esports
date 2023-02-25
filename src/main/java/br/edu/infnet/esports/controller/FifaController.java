package br.edu.infnet.esports.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.infnet.esports.model.domain.Fifa;
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
		
		model.addAttribute("estatisticasFifa", FifaRepository.obterLista());
		model.addAttribute("mensagem", msg);
		msg = null;
		return "game/fifa/lista";
	}

	@PostMapping(value = "/game/fifa/incluir")
	public String incluir(Fifa fifa) {
		FifaRepository.incluir(fifa);
		msg = "Estatísticas cadastradas com sucesso";
		return "redirect:/";
	}
	
	@GetMapping(value = "/game/fifa/{id}/excluir" )
	public String excluir(@PathVariable Integer id) {
		FifaRepository.excluir(id);
		msg = "Estatísticas removidas com sucesso";
	
		return "redirect:/game/fifa/lista";
	}
	
}
