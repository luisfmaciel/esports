package br.edu.infnet.esports.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.esports.model.domain.Dungeons;
import br.edu.infnet.esports.model.repository.DungeonsRepository;

@Service
public class DungeonsService {
	
	@Autowired
	private DungeonsRepository dungeonsRepository;
	
	public boolean incluir(Dungeons dungeons) {
		return dungeonsRepository.incluir(dungeons);
	}
	
	public Dungeons excluir(Integer key) {
		return dungeonsRepository.excluir(key);
	}
	
	public Collection<Dungeons> obterLista() {
		return dungeonsRepository.obterLista();
	}
}
