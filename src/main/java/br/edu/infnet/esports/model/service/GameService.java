package br.edu.infnet.esports.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.esports.model.domain.Game;
import br.edu.infnet.esports.model.repository.GameRepository;

@Service
public class GameService {
	
	@Autowired
	private GameRepository gameRepository;
	
	public boolean incluir(Game game) {
		return gameRepository.incluir(game);
	}
	
	public Game excluir(Integer key) {
		return gameRepository.excluir(key);
	}
	
	public Game obterGameById(Integer key) {
		return gameRepository.obterGameById(key);
	}
	
	public Collection<Game> obterLista() {
		return gameRepository.obterLista();
	}
}
