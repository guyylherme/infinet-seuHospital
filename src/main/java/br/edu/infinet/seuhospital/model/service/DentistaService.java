package br.edu.infinet.seuhospital.model.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import br.edu.infinet.seuhospital.model.domain.Dentista;
import br.edu.infinet.seuhospital.model.test.AppImpressao;

@Service
public class DentistaService {

	private static Map<Integer, Dentista> mapaDentista = new HashMap<Integer, Dentista>(); 
	private static Integer id = 1;
	
	public void incluir(Dentista dentista) { 
		
		try {
			dentista.setId(id++);		 
			mapaDentista.put(dentista.getId(), dentista);
			
			AppImpressao.relatorio("Inclusão do dentista " + dentista.getNome() , dentista);
		} catch (Exception e) {
			System.out.println("[ERROR] " + e.getMessage()); 
		} 
		
	} 

	public Collection<Dentista> obterLista(){
		return mapaDentista.values();
	}
	
	public void excluir(Integer id){
		mapaDentista.remove(id);
	}
	 
}