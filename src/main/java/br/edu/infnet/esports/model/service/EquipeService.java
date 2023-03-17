package br.edu.infnet.esports.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.esports.model.domain.Equipe;
import br.edu.infnet.esports.model.domain.Usuario;
import br.edu.infnet.esports.model.repository.EquipeRepository;

@Service
public class EquipeService {
	
	@Autowired
	private EquipeRepository equipeRepository;
	
	public Equipe incluir(Equipe equipe) {
		return equipeRepository.save(equipe);
	}
	
	public void excluir(Integer key) {
		equipeRepository.deleteById(key);
	}
	
	public Collection<Equipe> obterLista() {
		return (Collection<Equipe>) equipeRepository.findAll();
	}
	
	public Collection<Equipe> obterLista(Usuario usuario) {
		return (Collection<Equipe>) equipeRepository.obterLista(usuario.getId());
	}
}
