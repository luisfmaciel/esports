package br.edu.infnet.esports.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.edu.infnet.esports.model.domain.Usuario;
import br.edu.infnet.esports.model.exceptions.CampoVazioException;
import br.edu.infnet.esports.model.exceptions.EmailInvalidoException;
import br.edu.infnet.esports.model.service.UsuarioService;

@Controller
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	private String msg;
	
	@GetMapping(value = "/usuario")
	public String telaCadastro() {
		return "usuario/cadastro";
	}

	@GetMapping(value = "/usuario/lista")
	public String telaLista(Model model) {
	
		model.addAttribute("usuarios", usuarioService.obterLista());
		model.addAttribute("mensagem", msg);
		msg = null;
		return "usuario/lista";
	}

	@PostMapping(value = "/usuario/incluir")
	public String incluir(
			Model model,
			@RequestParam String nome,
			@RequestParam String email, 
			@RequestParam String senha, 
			@RequestParam String perfil
	) throws EmailInvalidoException {
		try {			
			Usuario usuario = new Usuario(nome, email, senha, perfil);
			usuarioService.incluir(usuario);
			msg = "Usuário " + usuario.getNome() + " cadastrado com sucesso";
			
			return "redirect:/";
		} catch (EmailInvalidoException | CampoVazioException e) {
			model.addAttribute("mensagemError", e.getMessage());
		}
		return telaCadastro();
	}
	
	@GetMapping(value = "/usuario/{id}/excluir" )
	public String excluir(@PathVariable Integer id) {
		usuarioService.excluir(id);
		msg = "Usuário " + id + " removido com sucesso";
	
		return "redirect:/usuario/lista";
	}
}
