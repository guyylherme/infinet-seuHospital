package br.edu.infinet.seuhospital.model.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.edu.infinet.seuhospital.model.domain.Especialidade;
import br.edu.infinet.seuhospital.model.test.AppImpressao;

@Controller
public class EspecialidadeController {
	
	private static Map<Integer, Especialidade> mapaEspecialidade = new HashMap<Integer, Especialidade>(); 
	private static Integer id = 1;
	
	public static void incluir(Especialidade especialidade) { 
		especialidade.setId(id++);		 
		mapaEspecialidade.put(especialidade.getId(), especialidade);
		
		AppImpressao.relatorio("Inclusão do clinico " + especialidade.getNome() , especialidade);
	}
	
	public static Collection<Especialidade> obterLista(){
		return mapaEspecialidade.values();
	}
	
	public static void excluir(Integer id){
		mapaEspecialidade.remove(id);
	}
	 
	@GetMapping(value = "/especialidade/lista")
	public String telaEspecialidade(Model model) {
		   
		model.addAttribute("listagem", obterLista());		
		return "especialidade/lista";
	}
	
	@GetMapping(value = "/especialidade/{id}/excluir")
	public String exclusao(@PathVariable Integer id) {
		
		excluir(id); 		
		return "redirect:/especialidade/lista";
	} 

}
