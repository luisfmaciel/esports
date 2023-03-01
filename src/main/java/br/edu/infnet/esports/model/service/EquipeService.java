package br.edu.infnet.esports.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.esports.model.domain.Equipe;
import br.edu.infnet.esports.model.repository.EquipeRepository;

@Service
public class EquipeService {
	
	@Autowired
	private EquipeRepository equipeRepository;
	
	public boolean incluir(Equipe equipe) {
		return equipeRepository.incluir(equipe);
	}
	
	public Equipe excluir(Integer key) {
		return equipeRepository.excluir(key);
	}
	
	public Collection<Equipe> obterLista() {
		return equipeRepository.obterLista();
	}
}
