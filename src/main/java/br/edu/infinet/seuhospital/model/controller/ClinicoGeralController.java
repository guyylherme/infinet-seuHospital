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
	 
	private String mensagem;
	private String tipo;
	
	@GetMapping(value = "/clinicoGeral/lista")
	public String telaClinicoGeral(Model model, @SessionAttribute("user") Usuario usuario) {
		
		model.addAttribute("listagem", clinicoGeralService.obterLista(usuario));	
		model.addAttribute("mensagem", mensagem);	
		model.addAttribute("tipo", tipo);
		
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
		mensagem = clinicoGeral.getNome() + " incluído com sucesso!"; 
		tipo = " alert-success";
		
		return "redirect:/clinicoGeral/lista";
	}
	
	@GetMapping(value = "/clinicoGeral/{id}/excluir")
	public String exclusao(@PathVariable Integer id) {		
					
		try {
			clinicoGeralService.excluir(id); 
			mensagem = "Exclusão do Clinico Geral <strong>#" + id + "</strong> realizada com sucesso!"; 
			tipo = " alert-success";
			
		} catch (Exception e) {
			mensagem = "Impossível realizar a exclusão do Clinico Geral <strong>#" + id + "</strong>"; 
			tipo = " alert-danger";
		}
		
		return "redirect:/clinicoGeral/lista";
	}

}








