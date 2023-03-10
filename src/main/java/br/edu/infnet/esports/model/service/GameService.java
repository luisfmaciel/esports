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
	
	public Game incluir(Game game) {
		return gameRepository.save(game);
	}
	
	public void excluir(Integer key) {
		gameRepository.deleteById(key);
	}
	
	public Game obterGameById(Integer key) {
		return gameRepository.findById(key).get();
	}
	
	public Collection<Game> obterLista() {
		return (Collection<Game>) gameRepository.findAll();
	}
}
