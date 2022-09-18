package br.edu.infinet.seuhospital.model.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import br.edu.infinet.seuhospital.model.domain.Especialidade;
import br.edu.infinet.seuhospital.model.test.AppImpressao;

@Service
public class EspecialidadeService {

	private static Map<Integer, Especialidade> mapaEspecialidade = new HashMap<Integer, Especialidade>(); 
	private static Integer id = 1; 
	
	public void incluir(Especialidade especialidade) { 
		
		try {
			especialidade.setId(id++);		 
			mapaEspecialidade.put(especialidade.getId(), especialidade);
			
			AppImpressao.relatorio("Inclusão do clinico " + especialidade.getNome() , especialidade);
		} catch (Exception e) {
			System.out.println("[ERROR] " + e.getMessage()); 
		} 
		
	} 

	public Collection<Especialidade> obterLista(){
		return mapaEspecialidade.values();
	}
	
	public void excluir(Integer id){
		mapaEspecialidade.remove(id);
	}

}
