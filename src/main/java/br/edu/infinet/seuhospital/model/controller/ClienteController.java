package br.edu.infinet.seuhospital.model.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.infinet.seuhospital.model.domain.Cliente;
import br.edu.infinet.seuhospital.model.test.AppImpressao;

@Controller
public class ClienteController {
	
	private static Map<String, Cliente> mapaCliente = new HashMap<String, Cliente>();  
	
	public static Cliente validar(String email, String senha) {
		
		Cliente cliente = mapaCliente.get(email);
		
		if(cliente != null && senha.equals(cliente.getSenha())) {
			return cliente;
		}
		
		return null;
	}
	
	public static void incluir(Cliente cliente) {  
		mapaCliente.put(cliente.getEmail(), cliente);
		
		AppImpressao.relatorio("Inclusão do cliente " + cliente.getNome() , cliente);
	}
	
	public static Collection<Cliente> obterLista(){
		return mapaCliente.values();
	}
	
	public static void excluir(String email){
		mapaCliente.remove(email);
	}
	 
	@GetMapping(value = "/cliente/lista")
	public String telaCliente(Model model) {
		   
		model.addAttribute("listagem", obterLista());		
		return "cliente/lista";
	}
	
	@GetMapping(value = "/cliente")
	public String telaCadastro() { 
		return "cliente/cadastro";
	}
	
	@PostMapping(value = "/cliente/incluir")
	public String inclusao(Cliente cliente){
		
		incluir(cliente);
		
		return "redirect:/";
	}
	
	@GetMapping(value = "/cliente/{email}/excluir")
	public String exclusao(@PathVariable String email) {
		
		excluir(email); 		
		return "redirect:/cliente/lista";
	}
	
	

}








