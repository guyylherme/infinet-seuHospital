package br.edu.infinet.seuhospital.model.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.edu.infinet.seuhospital.model.domain.ClinicoGeral;

@Repository
public interface ClinicoGeralRepository extends CrudRepository<ClinicoGeral, Integer>{
	
	@Query("FROM ClinicoGeral c WHERE c.usuario.id = :idUsuario") 
	Collection<ClinicoGeral> findAll(@Param("idUsuario") Integer idUsuario);
 
}
