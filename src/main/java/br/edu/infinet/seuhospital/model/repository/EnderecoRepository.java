package br.edu.infinet.seuhospital.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.edu.infinet.seuhospital.model.domain.Endereco;

@Repository
public interface EnderecoRepository extends CrudRepository<Endereco, Integer>{
	
	@Query("FROM Endereco e WHERE e.usuario.id = :idUsuario")
    List<Endereco> obterLista(@Param("idUsuario") Integer idUsuario);
 
}
