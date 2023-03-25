package br.edu.infnet.esports.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import br.edu.infnet.esports.model.domain.Fifa;
import br.edu.infnet.esports.model.domain.Usuario;
import br.edu.infnet.esports.model.exceptions.CampoVazioException;
import br.edu.infnet.esports.model.exceptions.ValorLimiteUltrapassadoException;
import br.edu.infnet.esports.model.service.FifaService;

@Controller
public class FifaController {

	@Autowired
	private FifaService fifaService;
	private String msg;

	@GetMapping(value = "/game/fifa")
	public String telaCadastro() {
		return "game/fifa/cadastro";
	}

	@GetMapping(value = "/game/fifa/lista")
	public String telaLista(Model model, @SessionAttribute("user") Usuario usuario) {

		model.addAttribute("fifaEstatisticas", fifaService.obterLista(usuario));
		model.addAttribute("mensagem", msg);
		msg = null;
		return "game/fifa/lista";
	}

	@PostMapping(value = "/game/fifa/incluir")
	public String incluir(Model model, @RequestParam String plataforma, @RequestParam String titulos,
			@RequestParam String finalizacao, @RequestParam String marcacao, @RequestParam String passe,
			@SessionAttribute("user") Usuario usuario) {
		try {
			Fifa fifa = new Fifa(plataforma);
			fifa.setUsuario(usuario);
			fifa.setTitulos(titulos);
			fifa.setFinalizacao(finalizacao);
			fifa.setMarcacao(marcacao);
			fifa.setPasse(passe);
			fifa.setMediaEstatistica(fifa.calculaMediaEstatisticaGamer());
			fifa.setNivel(fifa.identificaNivelGamer());

			fifaService.incluir(fifa);
			msg = "Estatísticas cadastradas com sucesso";

			return "redirect:/game/fifa/lista";
		} catch (ValorLimiteUltrapassadoException | CampoVazioException e) {
			model.addAttribute("mensagemError", e.getMessage());
		}

		return telaCadastro();
	}

	@GetMapping(value = "/game/fifa/{id}/excluir")
	public String excluir(@PathVariable Integer id) {
		Fifa fifa = fifaService.obterGameById(id);

		try {
			fifaService.excluir(id);
			msg = "O Game " + fifa.getNome() + " - ID: " + fifa.getId() + " - foi removido com sucesso";
		} catch (Exception e) {
			msg = "Impossível realizar a exclusão do game: " + fifa.getNome() + " - ID: " + fifa.getId();
		}

		return "redirect:/game/fifa/lista";
	}

}
