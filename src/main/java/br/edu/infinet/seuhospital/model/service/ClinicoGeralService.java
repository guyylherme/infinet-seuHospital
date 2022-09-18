package br.edu.infinet.seuhospital.model.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import br.edu.infinet.seuhospital.model.domain.ClinicoGeral;
import br.edu.infinet.seuhospital.model.test.AppImpressao;

@Service
public class ClinicoGeralService {

	private static Map<Integer, ClinicoGeral> mapaClinicoGeral = new HashMap<Integer, ClinicoGeral>(); 
	private static Integer id = 1;
	
	public void incluir(ClinicoGeral clinicoGeral) { 
		
		try {
			clinicoGeral.setId(id++);		 
			mapaClinicoGeral.put(clinicoGeral.getId(), clinicoGeral);
			
			AppImpressao.relatorio("Inclusão do clinico " + clinicoGeral.getNome() , clinicoGeral);
		} catch (Exception e) {
			System.out.println("[ERROR] " + e.getMessage()); 
		} 
		
	} 

	public Collection<ClinicoGeral> obterLista(){
		return mapaClinicoGeral.values();
	}
	
	public void excluir(Integer id){
		mapaClinicoGeral.remove(id);
	}
	 
}