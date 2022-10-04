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
	
	private String mensagem;
	private String tipo;
	
	@GetMapping(value = "/dentista/lista")
	public String telaDentista(Model model, @SessionAttribute("user") Usuario usuario) {
		   
		model.addAttribute("listagem", dentistaService.obterLista(usuario));	
		model.addAttribute("mensagem", mensagem);	
		model.addAttribute("tipo", tipo);
		
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
		mensagem = dentista.getNome() + " incluído com sucesso!"; 
		tipo = " alert-success";
		
		return "redirect:/dentista/lista";
	}
	
	@GetMapping(value = "/dentista/{id}/excluir")
	public String exclusao(@PathVariable Integer id) {
		
		try {
			dentistaService.excluir(id);  
			mensagem = "Exclusão do Dentista <strong>#" + id + "</strong> realizada com sucesso!"; 
			tipo = " alert-success";
			
		} catch (Exception e) {
			mensagem = "Impossível realizar a exclusão do Dentista <strong>#" + id + "</strong>" ; 
			tipo = " alert-danger";
		}
		
				
		return "redirect:/dentista/lista";
	} 

}
