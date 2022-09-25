package br.edu.infinet.seuhospital.model.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.edu.infinet.seuhospital.model.domain.Pediatria;

@Repository
public interface PediatraRepository extends CrudRepository<Pediatria, Integer>{
	
	@Query("FROM Pediatria p WHERE p.usuario.id = :idUsuario") 
	Collection<Pediatria> findAll(@Param("idUsuario") Integer idUsuario);
 
}
