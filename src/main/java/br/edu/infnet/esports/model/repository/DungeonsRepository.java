package br.edu.infnet.esports.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.esports.model.domain.Dungeons;

@Repository
public interface DungeonsRepository extends CrudRepository<Dungeons, Integer>{}
