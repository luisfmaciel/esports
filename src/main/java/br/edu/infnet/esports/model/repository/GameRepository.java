package br.edu.infnet.esports.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.esports.model.domain.Game;

@Repository
public interface GameRepository extends CrudRepository<Game, Integer> {}
