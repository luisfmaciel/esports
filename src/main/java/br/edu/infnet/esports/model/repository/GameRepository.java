package br.edu.infnet.esports.model.repository;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.esports.model.domain.Game;

@Repository
public interface GameRepository extends CrudRepository<Game, Integer> {
	
//	@Query("from Game game where ((game.gamer is null) or (game.gamer is not null and game.gamer.usuario.id = :userId))")
//	List<Game> obterLista(Integer userId);
	
	@Query("from Game g where g.nome = :nome")
	List<Game> findGameByName(String nome);
}
