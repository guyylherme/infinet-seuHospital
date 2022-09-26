package br.edu.infinet.seuhospital.model.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import br.edu.infinet.seuhospital.model.domain.ClinicoGeral;
import br.edu.infinet.seuhospital.model.domain.Usuario;
import br.edu.infinet.seuhospital.model.service.ClinicoGeralService;

@Controller
public class ClinicoGeralController {
	
	@Autowired
	private ClinicoGeralService clinicoGeralService;	
	 
	
	@GetMapping(value = "/clinicoGeral/lista")
	public String telaClinicoGeral(Model model, @SessionAttribute("user") Usuario usuario) {		   
		model.addAttribute("listagem", clinicoGeralService.obterLista(usuario));		
		return "clinicoGeral/lista";
	}
	
	@GetMapping(value = "/clinicoGeral/incluir")
	public String telaCadastro() { 
		return "clinicoGeral/cadastro";
	}
	
	@PostMapping(value = "/clinicoGeral/incluir")
	public String incluir(ClinicoGeral clinicoGeral, @SessionAttribute("user") Usuario usuario){		
		clinicoGeral.setUsuario(usuario);
		clinicoGeralService.incluir(clinicoGeral);			
		return "redirect:/clinicoGeral/lista";
	}
	
	@GetMapping(value = "/clinicoGeral/{id}/excluir")
	public String exclusao(@PathVariable Integer id) {		
		clinicoGeralService.excluir(id); 		
		return "redirect:/clinicoGeral/lista";
	}

}








