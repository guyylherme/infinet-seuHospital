package br.edu.infinet.seuhospital.model.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import br.edu.infinet.seuhospital.model.domain.Especialidade;
import br.edu.infinet.seuhospital.model.domain.Usuario;
import br.edu.infinet.seuhospital.model.service.EspecialidadeService;

@Controller
public class EspecialidadeController {
	
	@Autowired
	EspecialidadeService especialidadeService;	
	
	private String mensagem;
	private String tipo;
	 
	@GetMapping(value = "/especialidade/lista")
	public String telaEspecialidade(Model model, @SessionAttribute("user") Usuario usuario) {
		   
		model.addAttribute("listagem", especialidadeService.obterLista(usuario));
		model.addAttribute("mensagem", mensagem);
		model.addAttribute("tipo", tipo);
		
		return "especialidade/lista";
	}
	
	@GetMapping(value = "/especialidade/incluir")
	public String telaCadastro() { 
		return "especialidade/cadastro";
	}
	
	@PostMapping(value = "/especialidade/incluir")
	public String incluir(Especialidade especialidade, @SessionAttribute("user") Usuario usuario){		
		
		especialidade.setUsuario(usuario);
		especialidadeService.incluir(especialidade);			
		return "redirect:/especialidade/lista";
	}
	
	@GetMapping(value = "/especialidade/{id}/excluir")
	public String exclusao(@PathVariable Integer id) {
				
		try {
			especialidadeService.excluir(id); 
			mensagem = "Exclusão da Especialidade <strong>#" + id + "</strong> realizada com sucesso!";
			tipo = " alert-success";
			
		} catch (Exception e) {
			mensagem = "Impossível realizar a exclusão da Especialidade <strong>#" + id + "</strong>" ; 
			tipo = " alert-danger";
		}
		
		return "redirect:/especialidade/lista";
	} 

}
