package br.edu.infinet.seuhospital.model.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.edu.infinet.seuhospital.model.domain.Usuario;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Integer>{

	@Query("FROM Usuario u WHERE u.email = :email and u.senha = :senha")
    public Usuario findByLoginAndSenha(@Param("email")String email, @Param("senha") String senha);

	public Optional<Usuario> findByEmail(String username);
	 
 
}
 