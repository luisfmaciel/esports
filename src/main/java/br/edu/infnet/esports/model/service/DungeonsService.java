package br.edu.infnet.esports.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.esports.model.domain.Dungeons;
import br.edu.infnet.esports.model.domain.Usuario;
import br.edu.infnet.esports.model.repository.DungeonsRepository;

@Service
public class DungeonsService {
	
	@Autowired
	private DungeonsRepository dungeonsRepository;
	
	public Dungeons incluir(Dungeons dungeons) {
		return dungeonsRepository.save(dungeons);
	}
	
	public void excluir(Integer key) {
		dungeonsRepository.deleteById(key);
	}
	
	public Collection<Dungeons> obterLista() {
		return (Collection<Dungeons>) dungeonsRepository.findAll();
	}
	
	public Collection<Dungeons> obterLista(Usuario usuario) {
		return (Collection<Dungeons>) dungeonsRepository.obterLista(usuario.getId());
	}
}
