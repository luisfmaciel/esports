package br.edu.infnet.esports.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.esports.model.domain.CsGo;

@Repository
public interface CsGoRepository extends CrudRepository<CsGo, Integer>{
	@Query("from CsGo c where c.usuario.id = :userId")
	List<CsGo> obterLista(Integer userId);
}
