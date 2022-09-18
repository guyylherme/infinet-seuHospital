package br.edu.infinet.seuhospital.model.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import br.edu.infinet.seuhospital.model.domain.Endereco;
import br.edu.infinet.seuhospital.model.test.AppImpressao;

@Service
public class EnderecoService {

	private static Map<Integer, Endereco> mapaEndereco = new HashMap<Integer, Endereco>(); 
	private static Integer id = 1;
	
	public void incluir(Endereco endereco) { 
		
		try {
			endereco.setId(id++);		 
			mapaEndereco.put(endereco.getId(), endereco);
			
			AppImpressao.relatorio("Inclusão do clinico " + endereco.getRua() , endereco);
		} catch (Exception e) {
			System.out.println("[ERROR] " + e.getMessage()); 
		} 
		
	} 

	public Collection<Endereco> obterLista(){
		return mapaEndereco.values();
	}
	
	public void excluir(Integer id){
		mapaEndereco.remove(id);
	}

}
