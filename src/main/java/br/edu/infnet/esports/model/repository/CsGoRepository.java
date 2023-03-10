package br.edu.infnet.esports.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.esports.model.domain.CsGo;

@Repository
public interface CsGoRepository extends CrudRepository<CsGo, Integer>{}
