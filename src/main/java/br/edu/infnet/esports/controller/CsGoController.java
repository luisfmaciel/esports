package br.edu.infnet.esports.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.edu.infnet.esports.model.domain.CsGo;
import br.edu.infnet.esports.model.exceptions.ValorLimiteUltrapassadoException;
import br.edu.infnet.esports.model.repository.CsGoRepository;
import br.edu.infnet.esports.model.repository.GameRepository;

@Controller
public class CsGoController {
	private String msg;

	@GetMapping(value = "/game/csgo")
	public String telaCadastro() {
		return "game/csgo/cadastro";
	}

	@GetMapping(value = "/game/csgo/lista")
	public String telaLista(Model model) {

		model.addAttribute("csgoEstatisticas", CsGoRepository.obterLista());
		model.addAttribute("mensagem", msg);
		msg = null;
		return "game/csgo/lista";
	}

	@PostMapping(value = "/game/csgo/incluir")
	public String incluir(Model model, @RequestParam String plataforma, @RequestParam int titulos,
			@RequestParam float precisao, @RequestParam float agressividade, @RequestParam float tatica) {
		try {
			CsGo csgo = new CsGo(plataforma);
			csgo.setTitulos(titulos);
			csgo.setPrecisao(precisao);
			csgo.setAgressividade(agressividade);
			csgo.setTatica(tatica);
			csgo.setMediaEstatistica(csgo.calculaMediaEstatisticaGamer());
			csgo.setNivel(csgo.identificaNivelGamer());
			
			CsGoRepository.incluir(csgo);
			GameRepository.incluir(csgo);
			msg = "Estatísticas cadastradas com sucesso";

			return "redirect:/game/csgo/lista";
		} catch (ValorLimiteUltrapassadoException e) {
			model.addAttribute("mensagemError", e.getMessage());
		}
		
		return telaCadastro();
	}

	@GetMapping(value = "/game/csgo/{id}/excluir")
	public String excluir(@PathVariable Integer id) {
		CsGoRepository.excluir(id);
		msg = "Estatísticas removidas com sucesso";

		return "redirect:/game/csgo/lista";
	}

}
