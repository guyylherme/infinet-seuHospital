package br.edu.infinet.seuhospital.model.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infinet.seuhospital.model.domain.Hospital;

@Repository
public interface HospitalRepository extends CrudRepository<Hospital, Integer>{

	@Query("from Hospital h where h.usuario.id = :idUsuario")
	Collection<Hospital> findAll(Integer idUsuario);
	 
 
}
 