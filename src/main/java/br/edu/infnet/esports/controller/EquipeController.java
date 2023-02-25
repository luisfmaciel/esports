package br.edu.infnet.esports.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.edu.infnet.esports.model.domain.Equipe;
import br.edu.infnet.esports.model.repository.EquipeRepository;

@Controller
public class EquipeController {

	private String msg;
	
	@GetMapping(value = "/equipe")
	public String telaCadastro() {
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
	public String incluir(Equipe equipe) {
		EquipeRepository.incluir(equipe);
		msg = "Equipe " + equipe.getNome() + " cadastrada com sucesso";
		return "redirect:/";
	}
	
	
	@GetMapping(value = "/equipe/{id}/excluir" )
	public String excluir(@PathVariable Integer id) {
		Equipe equipe = EquipeRepository.excluir(id);
		msg = "Equipe " + equipe.getNome() + " removida com sucesso";
	
		return "redirect:/equipe/lista";
	}
		
	
}
