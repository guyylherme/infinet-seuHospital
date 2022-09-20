package br.edu.infinet.seuhospital.model.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import br.edu.infinet.seuhospital.model.domain.Hospital;
import br.edu.infinet.seuhospital.model.test.AppImpressao;

@Service
public class HospitalService {

	private static Map<Integer, Hospital> mapaHospital = new HashMap<Integer, Hospital>(); 
	private static Integer id = 1;
	
	public void incluir(Hospital hospital) { 
		
		System.out.println("Entrou aq2");
		
		try {
			hospital.setId(id++);		 
			mapaHospital.put(hospital.getId(), hospital);
			
			AppImpressao.relatorio("Inclusão do hospital " + hospital.getNome() , hospital);
		} catch (Exception e) {
			System.out.println("[ERROR] " + e.getMessage()); 
		} 
		
	} 

	public Collection<Hospital> obterLista(){
		return mapaHospital.values();
	}
	
	public void excluir(Integer id){
		mapaHospital.remove(id);
	}

}
