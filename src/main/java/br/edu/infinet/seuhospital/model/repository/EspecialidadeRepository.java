package br.edu.infinet.seuhospital.model.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.edu.infinet.seuhospital.model.domain.Especialidade;

@Repository
public interface EspecialidadeRepository extends CrudRepository<Especialidade, Integer>{

	@Query("FROM Especialidade e WHERE e.usuario.id = :idUsuario") 
	Collection<Especialidade> findAll(@Param("idUsuario") Integer idUsuario);

}
