package br.edu.infinet.seuhospital.model.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.edu.infinet.seuhospital.model.domain.ClinicoGeral;
import br.edu.infinet.seuhospital.model.test.AppImpressao;

@Controller
public class ClinicoGeralController {
	
	private static Map<Integer, ClinicoGeral> mapaClinicoGeral = new HashMap<Integer, ClinicoGeral>(); 
	private static Integer id = 1;
	
	public static void incluir(ClinicoGeral clinicoGeral) { 
		clinicoGeral.setId(id++);		 
		mapaClinicoGeral.put(clinicoGeral.getId(), clinicoGeral);
		
		AppImpressao.relatorio("Inclusão do clinico " + clinicoGeral.getNome() , clinicoGeral);
	}
	
	public static Collection<ClinicoGeral> obterLista(){
		return mapaClinicoGeral.values();
	}
	
	public static void excluir(Integer id){
		mapaClinicoGeral.remove(id);
	}
	 
	@GetMapping(value = "/clinicoGeral/lista")
	public String telaClinicoGeral(Model model) {
		  
		System.err.println("entrou");
		model.addAttribute("listagem", obterLista());
		
		return "clinicoGeral/lista";
	}
	
	@GetMapping(value = "/clinicoGeral/{id}/excluir")
	public String exclusao(@PathVariable Integer id) {
		
		excluir(id); 
		
		return "redirect:/clinicoGeral/lista";
	}

}








