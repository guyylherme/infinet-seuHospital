package br.edu.infinet.seuhospital.model.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.infinet.seuhospital.model.domain.Endereco;
import br.edu.infinet.seuhospital.model.service.EnderecoService;

@Controller
public class EnderecoController {
	
	@Autowired
	EnderecoService enderecoService;
	 
	@GetMapping(value = "/endereco/lista")
	public String telaClinicoGeral(Model model) {
		   
		model.addAttribute("listagem", enderecoService.obterLista());		
		return "endereco/lista";
	}
	
	@GetMapping(value = "/endereco/incluir")
	public String telaCadastro() { 
		return "endereco/cadastro";
	}
	
	@PostMapping(value = "/endereco/incluir")
	public String incluir(Endereco endereco){		
		enderecoService.incluir(endereco);	
		
		return "redirect:/endereco/lista";
	}
	
	@GetMapping(value = "/endereco/{id}/excluir")
	public String exclusao(@PathVariable Integer id) {
		
		enderecoService.excluir(id); 		
		return "redirect:/endereco/lista";
	}
	
	  

}
