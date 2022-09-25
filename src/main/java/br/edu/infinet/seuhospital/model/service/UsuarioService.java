package br.edu.infinet.seuhospital.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infinet.seuhospital.model.domain.Usuario;
import br.edu.infinet.seuhospital.model.repository.UsuarioRepository;
import br.edu.infinet.seuhospital.model.test.AppImpressao;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	public Usuario validar(String email, String senha) {

		try { 
			Usuario usuario = usuarioRepository.findByLoginAndSenha(email, senha); 
			if (usuario != null && senha.equals(usuario.getSenha())) { 
				return usuario;
			}

		} catch (Exception e) {
			System.out.println("[ERROR] " + e.getMessage());
		}

		return null;
	}

	public void incluir(Usuario usuario) {

		try {
			usuarioRepository.save(usuario);
			AppImpressao.relatorio("Inclusão do usuario " + usuario.getNome(), usuario);
		} catch (Exception e) {
			System.out.println("[ERROR] " + e.getMessage());
		}

	}

	public Collection<Usuario> obterLista() {
		return (Collection<Usuario>) usuarioRepository.findAll();
	}

	public void excluir(Integer id) {
		usuarioRepository.deleteById(id);
	}

}
