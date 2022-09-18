package br.edu.infinet.seuhospital.model.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.infinet.seuhospital.model.domain.Especialidade;
import br.edu.infinet.seuhospital.model.service.EspecialidadeService;

@Controller
public class EspecialidadeController {
	
	@Autowired
	EspecialidadeService especialidadeService;	
	 
	@GetMapping(value = "/especialidade/lista")
	public String telaEspecialidade(Model model) {
		   
		model.addAttribute("listagem", especialidadeService.obterLista());		
		return "especialidade/lista";
	}
	
	@GetMapping(value = "/especialidade/incluir")
	public String telaCadastro() { 
		return "especialidade/cadastro";
	}
	
	@PostMapping(value = "/especialidade/incluir")
	public String incluir(Especialidade especialidade){		
		especialidadeService.incluir(especialidade);	
		
		return "redirect:/especialidade/lista";
	}
	
	@GetMapping(value = "/especialidade/{id}/excluir")
	public String exclusao(@PathVariable Integer id) {
		
		especialidadeService.excluir(id); 		
		return "redirect:/especialidade/lista";
	} 

}
