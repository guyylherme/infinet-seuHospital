package br.edu.infinet.seuhospital.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infinet.seuhospital.model.domain.Hospital;
import br.edu.infinet.seuhospital.model.domain.Usuario;
import br.edu.infinet.seuhospital.model.repository.HospitalRepository;
import br.edu.infinet.seuhospital.model.test.AppImpressao;
 

@Service
public class HospitalService {
	
	@Autowired
	private HospitalRepository hospitalRepository; 
	
	public void incluir(Hospital hospital) {  
		try {
			hospitalRepository.save(hospital);
			AppImpressao.relatorio("Inclusão do hospital " + hospital.getNome() , hospital);
		} catch (Exception e) {
			System.out.println("[ERROR] " + e.getMessage()); 
		} 
		
	} 

	public Collection<Hospital> obterLista(Usuario usuario){
		return (Collection<Hospital>) hospitalRepository.findAll(usuario.getId());
	}
	
	public void excluir(Integer id){
		hospitalRepository.deleteById(id);
	}

}
