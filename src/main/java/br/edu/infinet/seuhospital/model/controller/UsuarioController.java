package br.edu.infinet.seuhospital.model.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.infinet.seuhospital.model.domain.Usuario;
import br.edu.infinet.seuhospital.model.service.UsuarioService;

@Controller
public class UsuarioController{
	 
	@Autowired
	private UsuarioService usuarioService;	
	 
	@GetMapping(value = "/usuario/lista")
	public String telaUsuario(Model model) {
		   
		model.addAttribute("listagem", usuarioService.obterLista());		
		return "usuario/lista";
	}
	
	@GetMapping(value = "/usuario")
	public String telaCadastro() { 
		return "usuario/cadastro";
	}
	
	@PostMapping(value = "/usuario/incluir")
	public String incluir(Usuario usuario){
		
		usuarioService.incluir(usuario);
		
		return "redirect:/";
	}
	
	@GetMapping(value = "/usuario/{id}/excluir")
	public String exclusao(@PathVariable Integer id) {
		
		usuarioService.excluir(id); 		
		return "redirect:/usuario/lista";
	}
	
	

}








