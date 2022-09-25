package br.edu.infinet.seuhospital.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infinet.seuhospital.model.domain.Dentista;
import br.edu.infinet.seuhospital.model.domain.Usuario;
import br.edu.infinet.seuhospital.model.repository.DentistaRepository;
import br.edu.infinet.seuhospital.model.test.AppImpressao;

@Service
public class DentistaService {
	
	@Autowired
	private DentistaRepository dentistaRepository;
	
	public void incluir(Dentista dentista) { 
		
		try {
			dentistaRepository.save(dentista);			
			AppImpressao.relatorio("Inclusão do dentista " + dentista.getNome() , dentista);
		} catch (Exception e) {
			System.out.println("[ERROR] " + e.getMessage()); 
		} 
		
	} 

	public Collection<Dentista> obterLista(){
		return (Collection<Dentista>) dentistaRepository.findAll();
	}
	
	public Object obterLista(Usuario usuario) { 
		return dentistaRepository.findAll(usuario.getId());
	}
	
	public void excluir(Integer id){
		dentistaRepository.deleteById(id);
	} 
}