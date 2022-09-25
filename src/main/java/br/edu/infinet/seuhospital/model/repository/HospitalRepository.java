package br.edu.infinet.seuhospital.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infinet.seuhospital.model.domain.Hospital;

@Repository
public interface HospitalRepository extends CrudRepository<Hospital, Integer>{

//	@Query("FROM Usuario u WHERE u.email = :email and u.senha = :senha")
//    public Usuario findByLoginAndSenha(@Param("email")String email, @Param("senha") String senha);
	 
 
}
 