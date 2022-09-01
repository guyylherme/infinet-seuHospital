package br.edu.infinet.seuhospital.model.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.edu.infinet.seuhospital.model.domain.Dentista;
import br.edu.infinet.seuhospital.model.test.AppImpressao;

@Controller
public class DentistaController {
	
	private static Map<Integer, Dentista> mapaDentista = new HashMap<Integer, Dentista>(); 
	private static Integer id = 1;
	
	public static void incluir(Dentista dentista) { 
		dentista.setId(id++);		 
		mapaDentista.put(dentista.getId(), dentista);
		
		AppImpressao.relatorio("Inclusão do dentista " + dentista.getNome() , dentista);
	}
	
	public static Collection<Dentista> obterLista(){
		return mapaDentista.values();
	}
	
	public static void excluir(Integer id){
		mapaDentista.remove(id);
	}
	  
	@GetMapping(value = "/dentista/lista")
	public String telaDentista(Model model) {
		   
		model.addAttribute("listagem", obterLista());		
		return "dentista/lista";
	}
	
	@GetMapping(value = "/dentista/{id}/excluir")
	public String exclusao(@PathVariable Integer id) {
		
		excluir(id); 		
		return "redirect:/dentista/lista";
	} 

}
