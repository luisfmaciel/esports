package br.edu.infnet.esports.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.edu.infnet.esports.model.domain.Fifa;
import br.edu.infnet.esports.model.domain.Usuario;
import br.edu.infnet.esports.model.repository.FifaRepository;

@Service
public class FifaService {
	
	@Autowired
	private FifaRepository fifaRepository;
	
	public Fifa incluir(Fifa fifa) {
		return fifaRepository.save(fifa);
	}
	
	public void excluir(Integer key) {
		fifaRepository.deleteById(key);
	}
	
	public Fifa obterGameById(Integer key) {
		return fifaRepository.findById(key).get();
	}
	
	public Collection<Fifa> obterLista() {
		return (Collection<Fifa>) fifaRepository.findAll();
	}
	
	public Collection<Fifa> obterLista(Usuario usuario) {
		return (Collection<Fifa>) fifaRepository.obterLista(usuario.getId(), Sort.by(Direction.DESC, "mediaEstatistica"));
	}
}
