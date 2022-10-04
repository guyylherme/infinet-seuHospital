package br.edu.infinet.seuhospital.model.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import br.edu.infinet.seuhospital.model.domain.Endereco;
import br.edu.infinet.seuhospital.model.domain.Usuario;
import br.edu.infinet.seuhospital.model.service.EnderecoService;

@Controller
public class EnderecoController {
	
	@Autowired
	private EnderecoService enderecoService;
	
	private String mensagem;
	private String tipo;
	 
	@GetMapping(value = "/endereco/lista")
	public String telaEndereco(Model model, @SessionAttribute("user") Usuario usuario) {
		 
		model.addAttribute("listagem", enderecoService.obterLista(usuario));	
		model.addAttribute("mensagem", mensagem);	
		model.addAttribute("tipo", tipo);
		
		return "endereco/lista";
	}
	
	@GetMapping(value = "/endereco/incluir")
	public String telaCadastro() { 
		return "endereco/cadastro";
	}
	
	@PostMapping(value = "/endereco/incluir")
	public String incluir(Endereco endereco, @SessionAttribute("user") Usuario usuario){	
		
		endereco.setUsuario(usuario);
		enderecoService.incluir(endereco);	
		mensagem = endereco.getRua() + " " + endereco.getEstado() + " incluído com sucesso!"; 
		tipo = " alert-success";
		
		return "redirect:/endereco/lista";
	}
	
	@GetMapping(value = "/endereco/{id}/excluir")
	public String exclusao(@PathVariable Integer id) {
		
		try {
			enderecoService.excluir(id); 
			mensagem = "Exclusão do endereço <strong>#" + id + "</strong> realizada com sucesso!"; 
			tipo = " alert-success";
			
		} catch (Exception e) {
			mensagem = "Impossível realizar a exclusão do Endereço  <strong>#" + id + "</strong>"; 
			tipo = " alert-danger";
		}
				
		return "redirect:/endereco/lista";
	}
	
	  

}
