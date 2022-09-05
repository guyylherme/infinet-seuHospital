package br.edu.infinet.seuhospital.model.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.edu.infinet.seuhospital.model.domain.Cliente;

@Controller
public class AppController {
	
	@GetMapping(value = "/")
	public String telaHome() {
		return "home";
	} 

	@GetMapping(value = "/login")
	public String telaLogin() {
		return "login";
	}
	
	
	@PostMapping(value = "/login")
	public String login(Model model, @RequestParam String email, @RequestParam String senha) {
		
		Cliente cliente = ClienteController.validar(email, senha);
		
		if(cliente != null) {
			 
			model.addAttribute("user", cliente.getNome());
			
			return "home";
//			return "redirect:/";
		}
		
		return "login";
//		return "redirect:/login";
	}
	
	@GetMapping(value = "/logout")
	public String logout(Model model) {
		
		model.addAttribute("user", "");
		
		return "redirect:/";
	}
	
	
}
