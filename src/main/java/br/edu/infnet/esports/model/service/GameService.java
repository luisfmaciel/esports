package br.edu.infnet.esports.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.esports.model.domain.Game;
import br.edu.infnet.esports.model.repository.GameRepository;

@Service
public class GameService {
	
	@Autowired
	private GameRepository usuarioRepository;
	
	public boolean incluir(Game usuario) {
		return usuarioRepository.incluir(usuario);
	}
	
	public Game excluir(Integer key) {
		return usuarioRepository.excluir(key);
	}
	
	public Game obterGameById(Integer key) {
		return usuarioRepository.obterGameById(key);
	}
	
	public Collection<Game> obterLista() {
		return usuarioRepository.obterLista();
	}
}
