	package br.edu.infinet.seuhospital.model.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import br.edu.infinet.seuhospital.model.domain.Pediatria;
import br.edu.infinet.seuhospital.model.domain.Usuario;
import br.edu.infinet.seuhospital.model.service.PediatriaService;

@Controller
public class PediatriaController {
	
	@Autowired
	PediatriaService pediatriaService; 
	
	private String mensagem;
	private String tipo;
		  
	@GetMapping(value = "/pediatra/lista")
	public String telaPediatria(Model model, @SessionAttribute("user") Usuario usuario) {
		   
		model.addAttribute("listagem", pediatriaService.obterLista(usuario));	
		model.addAttribute("mensagem", mensagem);
		model.addAttribute("tipo", tipo);
		
		return "pediatria/lista";
	}
	
	@GetMapping(value = "/pediatra/incluir")
	public String telaCadastro() {  
		return "pediatria/cadastro";
	}
	 
	@PostMapping(value = "/pediatra/incluir")
	public String incluir(Pediatria pediatra, @SessionAttribute("user") Usuario usuario){		
		
		pediatra.setUsuario(usuario);
		pediatriaService.incluir(pediatra);	
		mensagem = pediatra.getNome() + " incluído com sucesso!"; 
		tipo = " alert-success";
		
		return "redirect:/pediatra/lista";
	}
	
	
	@GetMapping(value = "/pediatra/{id}/excluir")
	public String exclusao(@PathVariable Integer id) {
		
				
		try {
			pediatriaService.excluir(id); 	
			mensagem = "Exclusão da Pediatria <strong>#" + id + "</strong> realizada com sucesso!";
			tipo = " alert-success";
			
		} catch (Exception e) {
			mensagem = "Impossível realizar a exclusão da Pediatria <strong>#" + id + "</strong>" ; 
			tipo = " alert-danger";
		}
		
		return "redirect:/pediatra/lista";
	} 
}
