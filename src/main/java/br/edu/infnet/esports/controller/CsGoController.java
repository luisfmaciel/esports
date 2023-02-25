package br.edu.infnet.esports.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.infnet.esports.model.domain.CsGo;
import br.edu.infnet.esports.model.repository.CsGoRepository;

@Controller
public class CsGoController {
	private String msg;
	
	@GetMapping(value = "/game/csgo")
	public String telaCadastro() {
		return "game/csgo/cadastro";
	}
	
	@GetMapping(value = "/game/csgo/lista")
	public String telaLista(Model model) {
		
		model.addAttribute("estatisticasCsGo", CsGoRepository.obterLista());
		model.addAttribute("mensagem", msg);
		msg = null;
		return "game/csgo/lista";
	}

	@PostMapping(value = "/game/csgo/incluir")
	public String incluir(CsGo csgo) {
		CsGoRepository.incluir(csgo);
		msg = "Estatísticas cadastradas com sucesso";
		return "redirect:/";
	}
	
	@GetMapping(value = "/game/csgo/{id}/excluir" )
	public String excluir(@PathVariable Integer id) {
		CsGoRepository.excluir(id);
		msg = "Estatísticas removidas com sucesso";
	
		return "redirect:/game/csgo/lista";
	}
	
}
