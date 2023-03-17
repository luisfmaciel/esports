package br.edu.infnet.esports.model.repository;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.esports.model.domain.Fifa;

@Repository
public interface FifaRepository extends CrudRepository<Fifa, Integer>{
	@Query("from Fifa f where f.usuario.id = :userId")
	List<Fifa> obterLista(Integer userId);
}
