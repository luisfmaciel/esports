package br.edu.infnet.esports.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.esports.model.domain.Gamer;

@Repository
public interface GamerRepository extends CrudRepository<Gamer, Integer> {
	@Query("from Gamer g where g.usuario.id = :userId")
	List<Gamer> obterLista(Integer userId);
}
