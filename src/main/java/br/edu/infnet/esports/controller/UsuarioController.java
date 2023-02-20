package br.edu.infnet.esports.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.edu.infnet.esports.model.domain.Usuario;
import br.edu.infnet.esports.model.exceptions.EmailInvalidoException;
import br.edu.infnet.esports.model.repository.UsuarioRepository;

@Controller
public class UsuarioController {
	
	private String msg;
	
	@GetMapping(value = "/usuario")
	public String telaCadastro() {
		return "usuario/cadastro";
	}

	@GetMapping(value = "/usuario/lista")
	public String telaLista(Model model) {
		
		model.addAttribute("usuarios", UsuarioRepository.obterLista());
		model.addAttribute("mensagem", msg);
		msg = null;
		return "usuario/lista";
	}

	@PostMapping(value = "/usuario/incluir")
	public String incluir(
			@RequestParam String nome,
			@RequestParam String email,
			@RequestParam String senha,
			@RequestParam String perfil
	) throws EmailInvalidoException {
		Usuario usuario = new Usuario();
		
		usuario.setNome(nome);
		usuario.setEmail(email);
		usuario.setSenha(senha);
		usuario.setPerfil(perfil);
	
		UsuarioRepository.incluir(usuario);
		msg = "Usuário " + usuario.getNome() + " cadastrado com sucesso";
	
		return "redirect:/";
	}
	
	@GetMapping(value = "/usuario/{id}/excluir" )
	public String excluir(@PathVariable Integer id) {
		Usuario usuario = UsuarioRepository.excluir(id);
		msg = "Usuário " + usuario.getNome() + " removido com sucesso";
	
		return "redirect:/usuario/lista";
	}
}
