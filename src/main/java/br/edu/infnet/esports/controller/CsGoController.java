package br.edu.infnet.esports.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import br.edu.infnet.esports.model.domain.CsGo;
import br.edu.infnet.esports.model.domain.Usuario;
import br.edu.infnet.esports.model.exceptions.CampoVazioException;
import br.edu.infnet.esports.model.exceptions.ValorLimiteUltrapassadoException;
import br.edu.infnet.esports.model.service.CsGoService;

@Controller
public class CsGoController {

	@Autowired
	private CsGoService csgoService;
	private String msg;

	@GetMapping(value = "/game/csgo")
	public String telaCadastro() {
		return "game/csgo/cadastro";
	}

	@GetMapping(value = "/game/csgo/lista")
	public String telaLista(Model model, @SessionAttribute("user") Usuario usuario) {

		model.addAttribute("csgoEstatisticas", csgoService.obterLista(usuario));
		model.addAttribute("mensagem", msg);
		msg = null;
		return "game/csgo/lista";
	}

	@PostMapping(value = "/game/csgo/incluir")
	public String incluir(Model model, @RequestParam String plataforma, @RequestParam String titulos,
			@RequestParam String precisao, @RequestParam String agressividade, @RequestParam String tatica,
			@SessionAttribute("user") Usuario usuario) {
		try {
			CsGo csgo = new CsGo(plataforma);
			csgo.setUsuario(usuario);
			csgo.setTitulos(titulos);
			csgo.setPrecisao(precisao);
			csgo.setAgressividade(agressividade);
			csgo.setTatica(tatica);
			csgo.setMediaEstatistica(csgo.calculaMediaEstatisticaGamer());
			csgo.setNivel(csgo.identificaNivelGamer());

			csgoService.incluir(csgo);
			msg = "Estatísticas cadastradas com sucesso";

			return "redirect:/game/csgo/lista";
		} catch (ValorLimiteUltrapassadoException | CampoVazioException e) {
			model.addAttribute("mensagemError", e.getMessage());
		}

		return telaCadastro();
	}

	@GetMapping(value = "/game/csgo/{id}/excluir")
	public String excluir(@PathVariable Integer id) {
		
		CsGo csgo = csgoService.obterGameById(id);
		
		try {
			csgoService.excluir(id);
			msg = "O Game " + csgo.getNome() + " - ID: " + csgo.getId() + " - foi removido com sucesso";
		} catch (Exception e) {
			msg = "Impossível realizar a exclusão do game: " + csgo.getNome() + " - ID: " + csgo.getId();
		}
		
		return "redirect:/game/csgo/lista";
	}

}
