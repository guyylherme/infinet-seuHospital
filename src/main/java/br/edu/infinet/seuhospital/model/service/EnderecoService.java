package br.edu.infinet.seuhospital.model.service;

import java.util.Collection;
import java.util.Optional;

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
			AppImpressao.relatorio("Inclusão do endereço " + endereco.getRua() , endereco);
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
	
	public Optional<Endereco> findById(int id) {
		return enderecoRepository.findById(id);
	}
	
	public void excluir(Integer id){
		enderecoRepository.deleteById(id);
	} 
	

}
