package br.edu.infnet.esports.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import br.edu.infnet.esports.model.domain.Usuario;
import br.edu.infnet.esports.model.exceptions.EmailInvalidoException;
import br.edu.infnet.esports.model.repository.AcessoRepository;
import jakarta.servlet.http.HttpSession;

@Controller
@SessionAttributes("user")
public class AcessoController {
	@GetMapping(value = "/login")
	public String telaLogin() {
		return "login";
	}

	@PostMapping(value = "/login")
	public String login(Model model, @RequestParam String email, @RequestParam String senha) {

		try {
			Usuario usuario = new Usuario();
			usuario.setEmail(email);
			usuario.setSenha(senha);
			usuario = AcessoRepository.autenticar(usuario);
			
			if (usuario != null) {
				model.addAttribute("user", usuario);
				return "redirect:/home";
			}
			
			model.addAttribute("mensagem", "As credencias para o email " + email + " estão incorretas!");
		} catch (EmailInvalidoException e) {
			model.addAttribute("mensagem", e.getMessage());
		}

		return telaLogin();
	}

	@GetMapping(value = "/logout")
	public String logout(HttpSession session, SessionStatus status) {
		status.setComplete();

		session.removeAttribute("user");

		return "redirect:/";
	}
}
