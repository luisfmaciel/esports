package br.edu.infnet.esports.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.edu.infnet.esports.model.domain.CsGo;
import br.edu.infnet.esports.model.domain.Usuario;
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
	
	public CsGo obterGameById(Integer key) {
		return csgoRepository.findById(key).get();
	}
	
	public Collection<CsGo> obterLista() {
		return (Collection<CsGo>) csgoRepository.findAll();
	}
	
	public Collection<CsGo> obterLista(Usuario usuario) {
		return (Collection<CsGo>) csgoRepository.obterLista(usuario.getId(), Sort.by(Direction.DESC, "mediaEstatistica"));
	}
}
