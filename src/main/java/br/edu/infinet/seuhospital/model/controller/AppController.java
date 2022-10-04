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

import br.edu.infinet.seuhospital.model.domain.Usuario;
import br.edu.infinet.seuhospital.model.service.AppService;
import br.edu.infinet.seuhospital.model.service.UsuarioService;

@SessionAttributes("user")
@Controller
public class AppController {

	@Autowired
	private AppService appService;

	@Autowired
	private UsuarioService usuarioService;

	private String mensagem;
	private String tipo;

	@GetMapping(value = "/")
	public String telaHome(Model model) {

		model.addAttribute("projeto", appService.obterProjeto());
		model.addAttribute("mensagem", mensagem);
		model.addAttribute("tipo", tipo);

		return "home";
	}

	@GetMapping(value = "/login")
	public String telaLogin(Model model) {
		
		model.addAttribute("mensagem", mensagem);
		model.addAttribute("tipo", tipo);
		
		return "login";
	}

	@PostMapping(value = "/login")
	public String login(Model model, @RequestParam String email, @RequestParam String senha) {
				
		Usuario usuario = usuarioService.validar(email, senha);		
		
		if(usuario != null) {		
			model.addAttribute("user", usuario);			
			return "home"; 
		}else {
			mensagem = "Dados inválidos!";
			tipo = " alert-danger";
			return"redirect:/login";
		}		

	}

	@GetMapping(value = "/logout")
	public String logout(HttpSession session, SessionStatus status) {
		
		status.setComplete();
		session.removeAttribute("user");
		 		
		return "redirect:/";
	}

}
