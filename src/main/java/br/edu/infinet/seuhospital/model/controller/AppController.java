package br.edu.infinet.seuhospital.model.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import br.edu.infinet.seuhospital.model.domain.Cliente;
import br.edu.infinet.seuhospital.model.service.AppService;
import br.edu.infinet.seuhospital.model.service.ClienteService;

@SessionAttributes("user")
@Controller
public class AppController {
	
	@Autowired
	AppService appService;
	
	@GetMapping(value = "/")
	public String telaHome(Model model) { 
		
		model.addAttribute("projeto", appService.obterProjeto());	
		return "home";
	} 

	@GetMapping(value = "/login")
	public String telaLogin() {
		return "login";
	} 
	
	
	@PostMapping(value = "/login")
	public String login(Model model, @RequestParam String email, @RequestParam String senha) {
		
		Cliente cliente = new ClienteService().validar(email, senha);		
		if(cliente != null) {			 
			model.addAttribute("user", cliente);			
			return "home"; 
		}		
		return "login"; 
	}
	
	@GetMapping(value = "/logout")
	public String logout(HttpSession session, SessionStatus status) {
		
		status.setComplete();
		session.removeAttribute("user");
		
		return "redirect:/";
	}
	
	
}
