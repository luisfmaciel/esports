package br.edu.infnet.esports.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.infnet.esports.model.domain.Dungeons;
import br.edu.infnet.esports.model.repository.DungeonsRepository;

@Controller
public class DungeonsController {
	private String msg;
	
	@GetMapping(value = "/game/dungeons")
	public String telaCadastro() {
		return "game/dungeons/cadastro";
	}
	
	@GetMapping(value = "/game/dungeons/lista")
	public String telaLista(Model model) {
		
		model.addAttribute("estatisticasDungeons", DungeonsRepository.obterLista());
		model.addAttribute("mensagem", msg);
		msg = null;
		return "game/dungeons/lista";
	}

	@PostMapping(value = "/game/dungeons/incluir")
	public String incluir(Dungeons dungeons) {
		DungeonsRepository.incluir(dungeons);
		msg = "Estatísticas cadastradas com sucesso";
		return "redirect:/";
	}
	
	@GetMapping(value = "/game/dungeons/{id}/excluir" )
	public String excluir(@PathVariable Integer id) {
		DungeonsRepository.excluir(id);
		msg = "Estatísticas removidas com sucesso";
	
		return "redirect:/game/dungeons/lista";
	}
	
}
