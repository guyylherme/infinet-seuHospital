package br.edu.infinet.seuhospital.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infinet.seuhospital.model.domain.Endereco;
import br.edu.infinet.seuhospital.model.domain.Usuario;
import br.edu.infinet.seuhospital.model.repository.EnderecoRepository;
import br.edu.infinet.seuhospital.model.test.AppImpressao;

@Service
public class EnderecoService {
	
	@Autowired
	private EnderecoRepository enderecoRepository;
 
	public void incluir(Endereco endereco) { 
		
		try {
			enderecoRepository.save(endereco); 
			AppImpressao.relatorio("Inclusão do clinico " + endereco.getRua() , endereco);
		} catch (Exception e) {
			System.out.println("[ERROR] " + e.getMessage()); 
		} 
		
	} 

	public Collection<Endereco> obterLista(){
		return (Collection<Endereco>) enderecoRepository.findAll();
	}

	public Collection<Endereco> obterLista(Usuario usuario){ 
		return enderecoRepository.obterLista(usuario.getId());
	}
	
	public void excluir(Integer id){
		enderecoRepository.deleteById(id);
	}

}
