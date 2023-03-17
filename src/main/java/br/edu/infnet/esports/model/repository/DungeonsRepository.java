package br.edu.infnet.esports.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.esports.model.domain.Dungeons;

@Repository
public interface DungeonsRepository extends CrudRepository<Dungeons, Integer>{
	@Query("from Dungeons d where d.usuario.id = :userId")
	List<Dungeons> obterLista(Integer userId);
}
