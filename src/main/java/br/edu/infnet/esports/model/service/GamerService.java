package br.edu.infnet.esports.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.esports.model.domain.Gamer;
import br.edu.infnet.esports.model.repository.GamerRepository;

@Service
public class GamerService {
	
	@Autowired
	private GamerRepository gamerRepository;
	
	public boolean incluir(Gamer gamer) {
		return gamerRepository.incluir(gamer);
	}
	
	public Gamer excluir(Integer key) {
		return gamerRepository.excluir(key);
	}
	
	public Gamer obterGamerById(Integer key) {
		return gamerRepository.obterGamerById(key);
	}
	
	public Collection<Gamer> obterLista() {
		return gamerRepository.obterLista();
	}
}
