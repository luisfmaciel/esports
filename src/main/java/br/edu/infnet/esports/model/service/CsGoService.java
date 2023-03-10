package br.edu.infnet.esports.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.esports.model.domain.CsGo;
import br.edu.infnet.esports.model.repository.CsGoRepository;

@Service
public class CsGoService {
	
	@Autowired
	private CsGoRepository csgoRepository;
	
	public CsGo incluir(CsGo csgo) {
		return csgoRepository.save(csgo);
	}
	
	public void excluir(Integer key) {
		csgoRepository.deleteById(key);
	}
	
	public Collection<CsGo> obterLista() {
		return (Collection<CsGo>) csgoRepository.findAll();
	}
}
