package br.edu.infnet.esports.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import br.edu.infnet.esports.model.domain.Dungeons;
import br.edu.infnet.esports.model.domain.Usuario;
import br.edu.infnet.esports.model.exceptions.CampoVazioException;
import br.edu.infnet.esports.model.exceptions.ValorLimiteUltrapassadoException;
import br.edu.infnet.esports.model.service.DungeonsService;

@Controller
public class DungeonsController {

	@Autowired
	private DungeonsService dungeonsService;
	private String msg;

	@GetMapping(value = "/game/dungeons")
	public String telaCadastro() {
		return "game/dungeons/cadastro";
	}

	@GetMapping(value = "/game/dungeons/lista")
	public String telaLista(Model model, @SessionAttribute("user") Usuario usuario) {

		model.addAttribute("dungeonsEstatisticas", dungeonsService.obterLista(usuario));
		model.addAttribute("mensagem", msg);
		msg = null;
		return "game/dungeons/lista";
	}

	@PostMapping(value = "/game/dungeons/incluir")
	public String incluir(Model model, @RequestParam String plataforma, @RequestParam String titulos,
			@RequestParam String dano, @RequestParam String sabedoria, @RequestParam String velocidade,
			@SessionAttribute("user") Usuario usuario) {
		try {
			Dungeons dungeons = new Dungeons(plataforma);
			dungeons.setUsuario(usuario);
			dungeons.setTitulos(titulos);
			dungeons.setDano(dano);
			dungeons.setSabedoria(sabedoria);
			dungeons.setVelocidade(velocidade);
			dungeons.setMediaEstatistica(dungeons.calculaMediaEstatisticaGamer());
			dungeons.setNivel(dungeons.identificaNivelGamer());

			dungeonsService.incluir(dungeons);
			msg = "Estatísticas cadastradas com sucesso";

			return "redirect:/game/dungeons/lista";
		} catch (ValorLimiteUltrapassadoException | CampoVazioException e) {
			model.addAttribute("mensagemError", e.getMessage());
		}

		return telaCadastro();
	}

	@GetMapping(value = "/game/dungeons/{id}/excluir")
	public String excluir(@PathVariable Integer id) {
		Dungeons dungeons = dungeonsService.obterGameById(id);

		try {
			dungeonsService.excluir(id);
			msg = "O Game " + dungeons.getNome() + " - ID: " + dungeons.getId() + " - foi removido com sucesso";
		} catch (Exception e) {
			msg = "Impossível realizar a exclusão do game: " + dungeons.getNome() + " - ID: " + dungeons.getId();
		}

		return "redirect:/game/dungeons/lista";
	}

}
