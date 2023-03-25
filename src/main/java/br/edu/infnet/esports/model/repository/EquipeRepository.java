package br.edu.infnet.esports.model.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.esports.model.domain.Equipe;

@Repository
public interface EquipeRepository extends CrudRepository<Equipe, Integer>{
	@Query("from Equipe e where e.usuario.id = :userId")
	List<Equipe> obterLista(Integer userId, Sort sort);
}
