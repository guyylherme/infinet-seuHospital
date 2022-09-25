package br.edu.infinet.seuhospital.model.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import br.edu.infinet.seuhospital.model.domain.Dentista;
import br.edu.infinet.seuhospital.model.domain.Usuario;
import br.edu.infinet.seuhospital.model.service.DentistaService;

@Controller
public class DentistaController {
	  
	@Autowired
	DentistaService dentistaService; 
	
	@GetMapping(value = "/dentista/lista")
	public String telaDentista(Model model, @SessionAttribute("user") Usuario usuario) {
		   
		model.addAttribute("listagem", dentistaService.obterLista(usuario));		
		return "dentista/lista";
	}
	
	@GetMapping(value = "/dentista/incluir")
	public String telaCadastro() {  
		return "dentista/cadastro";
	}
	 
	@PostMapping(value = "/dentista/incluir")
	public String incluir(Dentista dentista, @SessionAttribute("user") Usuario usuario){
		
		dentista.setUsuario(usuario);
		dentistaService.incluir(dentista);	
		
		return "redirect:/dentista/lista";
	}
	
	@GetMapping(value = "/dentista/{id}/excluir")
	public String exclusao(@PathVariable Integer id) {
		
		dentistaService.excluir(id); 		
		return "redirect:/dentista/lista";
	} 

}
