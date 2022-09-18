package br.edu.infinet.seuhospital.model.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.infinet.seuhospital.model.domain.Pediatria;
import br.edu.infinet.seuhospital.model.service.PediatriaService;

@Controller
public class PediatriaController {
	
	@Autowired
	PediatriaService pediatriaService; 
		  
	@GetMapping(value = "/pediatra/lista")
	public String telaPediatria(Model model) {
		   
		model.addAttribute("listagem", pediatriaService.obterLista());		
		return "pediatria/lista";
	}
	
	@GetMapping(value = "/pediatra/incluir")
	public String telaCadastro() {  
		return "pediatria/cadastro";
	}
	 
	@PostMapping(value = "/pediatra/incluir")
	public String incluir(Pediatria pediatra){		
		pediatriaService.incluir(pediatra);	
		
		return "redirect:/pediatra/lista";
	}
	
	
	@GetMapping(value = "/pediatra/{id}/excluir")
	public String exclusao(@PathVariable Integer id) {
		
		pediatriaService.excluir(id); 		
		return "redirect:/pediatra/lista";
	} 
}
