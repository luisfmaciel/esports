package br.edu.infnet.esports.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import br.edu.infnet.esports.model.domain.Usuario;
import br.edu.infnet.esports.model.service.EnderecoService;
import br.edu.infnet.esports.model.service.GameService;

@Controller
public class EnderecoController {

	@Autowired
	private EnderecoService enderecoServce;
	@Autowired
	private GameService gameService;

	@PostMapping(value = "/{perfil}/cep")
	public String buscaCep(Model model, @PathVariable String perfil, @RequestParam String cep,
			@SessionAttribute(value = "user", required = false) Usuario usuario) {
		model.addAttribute("endereco", enderecoServce.buscaPorCep(cep));

		if ("gamer".equalsIgnoreCase(perfil)) {
			model.addAttribute("games", gameService.obterLista(usuario));
			return "gamer/cadastro";
		}

		return "usuario/cadastro";
	}

}
