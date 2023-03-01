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
	
	public boolean incluir(CsGo csgo) {
		return csgoRepository.incluir(csgo);
	}
	
	public CsGo excluir(Integer key) {
		return csgoRepository.excluir(key);
	}
	
	public Collection<CsGo> obterLista() {
		return csgoRepository.obterLista();
	}
}
