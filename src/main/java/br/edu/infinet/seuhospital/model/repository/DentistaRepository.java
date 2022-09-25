package br.edu.infinet.seuhospital.model.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.edu.infinet.seuhospital.model.domain.Dentista;

@Repository
public interface DentistaRepository extends CrudRepository<Dentista, Integer>{

	@Query("FROM Dentista d WHERE d.usuario.id = :idUsuario") 
	Collection<Dentista> findAll(@Param("idUsuario") Integer idUsuario);
	 
}
