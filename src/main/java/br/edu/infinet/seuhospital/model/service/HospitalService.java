package br.edu.infinet.seuhospital.model.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infinet.seuhospital.model.domain.Hospital;
import br.edu.infinet.seuhospital.model.repository.HospitalRepository;
import br.edu.infinet.seuhospital.model.test.AppImpressao;

@Service
public class HospitalService {
	
	@Autowired
	private HospitalRepository hospitalRepository; 
	
	public void incluir(Hospital hospital) { 
		
		System.out.println("Entrou aq2");
		
		try {
			hospitalRepository.save(hospital);
			AppImpressao.relatorio("Inclusão do hospital " + hospital.getNome() , hospital);
		} catch (Exception e) {
			System.out.println("[ERROR] " + e.getMessage()); 
		} 
		
	} 

	public Collection<Hospital> obterLista(){
		return (Collection<Hospital>) hospitalRepository.findAll();
	}
	
	public void excluir(Integer id){
		hospitalRepository.deleteById(id);
	}

}
