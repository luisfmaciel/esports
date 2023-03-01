package br.edu.infnet.esports.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.esports.model.domain.Fifa;
import br.edu.infnet.esports.model.repository.FifaRepository;

@Service
public class FifaService {
	
	@Autowired
	private FifaRepository fifaRepository;
	
	public boolean incluir(Fifa fifa) {
		return fifaRepository.incluir(fifa);
	}
	
	public Fifa excluir(Integer key) {
		return fifaRepository.excluir(key);
	}
	
	public Collection<Fifa> obterLista() {
		return fifaRepository.obterLista();
	}
}
