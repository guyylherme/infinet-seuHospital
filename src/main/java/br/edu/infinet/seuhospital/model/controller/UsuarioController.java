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
	
	private String mensagem;
	private String tipo;
	 
	@GetMapping(value = "/usuario/lista")
	public String telaUsuario(Model model) {
		   
		model.addAttribute("listagem", usuarioService.obterLista());	
		model.addAttribute("mensagem", mensagem);
		model.addAttribute("tipo", tipo);
		
		return "usuario/lista";
	}
	
	@GetMapping(value = "/usuario")
	public String telaCadastro() { 
		return "usuario/cadastro";
	}
	
	@PostMapping(value = "/usuario/incluir")
	public String incluir(Usuario usuario){
		
		usuarioService.incluir(usuario);
		mensagem = usuario.getNome() + " incluído com sucesso!"; 
		tipo = " alert-success";
		
		return "redirect:/";
	}
	
	@GetMapping(value = "/usuario/{id}/excluir")
	public String exclusao(@PathVariable Integer id) {
		
		try {
			usuarioService.excluir(id); 
			mensagem = "Exclusão do Usuário <strong>#" + id + "</strong> realizado com sucesso!"; 
			tipo = " alert-success";
			
		} catch (Exception e) {
			mensagem = "Impossível realizar a exclusão do Usuário <strong>#" + id + "</strong>" ; 
			tipo = " alert-danger";
		}
		
		return "redirect:/usuario/lista";
	}
	
	

}








