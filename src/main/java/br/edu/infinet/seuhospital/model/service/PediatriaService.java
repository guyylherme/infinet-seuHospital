package br.edu.infinet.seuhospital.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infinet.seuhospital.model.domain.Pediatria;
import br.edu.infinet.seuhospital.model.domain.Usuario;
import br.edu.infinet.seuhospital.model.repository.PediatraRepository;
import br.edu.infinet.seuhospital.model.test.AppImpressao;

@Service
public class PediatriaService {
	
	@Autowired
	private PediatraRepository pediatraRepository;
	
	public void incluir(Pediatria pediatra) { 
		pediatraRepository.save(pediatra);
		AppImpressao.relatorio("Inclusão do pediatra " + pediatra.getNome() , pediatra);
	}
	
	public Collection<Pediatria> obterLista(){
		return (Collection<Pediatria>) pediatraRepository.findAll();
	} 
	
	public Collection<Pediatria> obterLista(Usuario usuario){
		return pediatraRepository.findAll(usuario.getId());
	} 
	
	public void excluir(Integer id){
		pediatraRepository.deleteById(id);
	}
 
	 
}