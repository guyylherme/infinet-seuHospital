package br.edu.infinet.seuhospital.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infinet.seuhospital.model.domain.Especialidade;

@Repository
public interface EspecialidadeRepository extends CrudRepository<Especialidade, Integer>{

}
