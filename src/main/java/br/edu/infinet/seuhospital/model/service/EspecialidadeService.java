package br.edu.infinet.seuhospital.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infinet.seuhospital.model.domain.Especialidade;
import br.edu.infinet.seuhospital.model.domain.Usuario;
import br.edu.infinet.seuhospital.model.repository.EspecialidadeRepository;
import br.edu.infinet.seuhospital.model.test.AppImpressao;

@Service
public class EspecialidadeService {
	
	@Autowired
	private EspecialidadeRepository especialidadeRepository; 
	
	public void incluir(Especialidade especialidade) { 
		
		try {
			
			especialidadeRepository.save(especialidade);
			
			AppImpressao.relatorio("Inclusão do clinico " + especialidade.getNome() , especialidade);
		} catch (Exception e) {
			System.out.println("[ERROR] " + e.getMessage()); 
		} 
		
	} 

	public Collection<Especialidade> obterLista(){
		return (Collection<Especialidade>) especialidadeRepository.findAll();
	}
	
	public Collection<Especialidade> obterLista(Usuario usuario){
		return especialidadeRepository.findAll(usuario.getId());
	}
	
	public void excluir(Integer id){
		especialidadeRepository.deleteById(id);
	}

}
