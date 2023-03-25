package br.edu.infnet.esports.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.edu.infnet.esports.model.domain.Gamer;
import br.edu.infnet.esports.model.domain.Usuario;
import br.edu.infnet.esports.model.repository.GamerRepository;

@Service
public class GamerService {
	
	@Autowired
	private GamerRepository gamerRepository;
	
	public Gamer incluir(Gamer gamer) {
		return gamerRepository.save(gamer);
	}
	
	public void excluir(Integer key) {
		gamerRepository.deleteById(key);
	}
	
	public Gamer obterGamerById(Integer key) {
		return gamerRepository.findById(key).get();
	}
	
	public Collection<Gamer> obterLista() {
		return (Collection<Gamer>) gamerRepository.findAll();
	}
	
	public Collection<Gamer> obterLista(Usuario usuario) {
		return (Collection<Gamer>) gamerRepository.obterLista(usuario.getId(), Sort.by(Direction.ASC, "username"));
	}
}
