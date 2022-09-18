package br.edu.infinet.seuhospital.model.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import br.edu.infinet.seuhospital.model.domain.Pediatria;
import br.edu.infinet.seuhospital.model.test.AppImpressao;

@Service
public class PediatriaService {

	private static Map<Integer, Pediatria> mapaPediatra = new HashMap<Integer, Pediatria>(); 
	private static Integer id = 1;
	
	public void incluir(Pediatria pediatra) { 
		pediatra.setId(id++);		 
		mapaPediatra.put(pediatra.getId(), pediatra);
		
		AppImpressao.relatorio("Inclusão do pediatra " + pediatra.getNome() , pediatra);
	}
	
	public Collection<Pediatria> obterLista(){
		return mapaPediatra.values();
	} 
	
	public void excluir(Integer id){
		mapaPediatra.remove(id);
	}
	 
}