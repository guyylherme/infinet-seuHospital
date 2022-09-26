package br.edu.infinet.seuhospital.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infinet.seuhospital.model.domain.ClinicoGeral;
import br.edu.infinet.seuhospital.model.domain.Usuario;
import br.edu.infinet.seuhospital.model.repository.ClinicoGeralRepository;
import br.edu.infinet.seuhospital.model.test.AppImpressao;

@Service
public class ClinicoGeralService {
	
	@Autowired
	private ClinicoGeralRepository clinicoGeralRepository;
 
	public void incluir(ClinicoGeral clinicoGeral) { 
		
		try {
			clinicoGeralRepository.save(clinicoGeral);			
			AppImpressao.relatorio("Inclusão do clinico " + clinicoGeral.getNome() , clinicoGeral);
		} catch (Exception e) {
			System.out.println("[ERROR] " + e.getMessage()); 
		} 
		
	} 

	public Collection<ClinicoGeral> obterLista(){
		return (Collection<ClinicoGeral>) clinicoGeralRepository.findAll();
	}


	public Collection<ClinicoGeral> obterLista(Usuario usuario){
		return clinicoGeralRepository.findAll(usuario.getId());
	}
	
	public void excluir(Integer id){
		clinicoGeralRepository.deleteById(id);
	}
	 
}