package br.edu.infinet.seuhospital.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infinet.seuhospital.model.domain.ClinicoGeral;

@Repository
public interface ClinicoGeralRepository extends CrudRepository<ClinicoGeral, Integer>{
	
//	@Query("FROM Endereco e WHERE e.usuario.id = :idUsuario")
//    List<Endereco> obterLista(@Param("idUsuario") Integer idUsuario);
 
}
