package br.edu.infinet.seuhospital.model.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.edu.infinet.seuhospital.model.domain.Pediatria;
import br.edu.infinet.seuhospital.model.test.AppImpressao;

@Controller
public class PediatriaController {
	
	private static Map<Integer, Pediatria> mapaPediatra = new HashMap<Integer, Pediatria>(); 
	private static Integer id = 1;
	
	public static void incluir(Pediatria pediatra) { 
		pediatra.setId(id++);		 
		mapaPediatra.put(pediatra.getId(), pediatra);
		
		AppImpressao.relatorio("Inclusão do pediatra " + pediatra.getNome() , pediatra);
	}
	
	public static Collection<Pediatria> obterLista(){
		return mapaPediatra.values();
	}
	
	public static void excluir(Integer id){
		mapaPediatra.remove(id);
	}
	  
	@GetMapping(value = "/pediatra/lista")
	public String telaPediatria(Model model) {
		   
		model.addAttribute("listagem", obterLista());		
		return "pediatria/lista";
	}
	
	@GetMapping(value = "/pediatra/{id}/excluir")
	public String exclusao(@PathVariable Integer id) {
		
		excluir(id); 		
		return "redirect:/pediatra/lista";
	} 
}
