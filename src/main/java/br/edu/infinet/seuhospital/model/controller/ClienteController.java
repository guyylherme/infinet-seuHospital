package br.edu.infinet.seuhospital.model.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.infinet.seuhospital.model.domain.Cliente;
import br.edu.infinet.seuhospital.model.service.ClienteService;

@Controller
public class ClienteController{
	 
	@Autowired
	private ClienteService clienteService;	
	 
	@GetMapping(value = "/cliente/lista")
	public String telaCliente(Model model) {
		   
		model.addAttribute("listagem", clienteService.obterLista());		
		return "cliente/lista";
	}
	
	@GetMapping(value = "/cliente")
	public String telaCadastro() { 
		return "cliente/cadastro";
	}
	
	@PostMapping(value = "/cliente/incluir")
	public String incluir(Cliente cliente){
		
		clienteService.incluir(cliente);
		
		return "redirect:/";
	}
	
	@GetMapping(value = "/cliente/{email}/excluir")
	public String exclusao(@PathVariable String email) {
		
		clienteService.excluir(email); 		
		return "redirect:/cliente/lista";
	}
	
	

}








