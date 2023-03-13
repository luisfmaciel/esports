package br.edu.infnet.esports.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.esports.model.domain.Equipe;

@Repository
public interface EquipeRepository extends CrudRepository<Equipe, Integer>{}
