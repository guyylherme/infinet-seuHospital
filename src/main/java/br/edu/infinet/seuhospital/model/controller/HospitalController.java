package br.edu.infinet.seuhospital.model.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.edu.infinet.seuhospital.model.domain.Hospital;
import br.edu.infinet.seuhospital.model.test.AppImpressao;

@Controller
public class HospitalController {
	
	private static Map<Integer, Hospital> mapaHospital = new HashMap<Integer, Hospital>(); 
	private static Integer id = 1;
	
	public static void incluir(Hospital hospital) { 
		hospital.setId(id++);		 
		mapaHospital.put(hospital.getId(), hospital);
		
		AppImpressao.relatorio("Inclusão do hospital " + hospital.getNome() , hospital);
	}
	
	public static Collection<Hospital> obterLista(){
		return mapaHospital.values();
	}
	
	public static void excluir(Integer id){
		mapaHospital.remove(id);
	}
	  
	@GetMapping(value = "/hospital/lista")
	public String telaHospital(Model model) {
		   
		model.addAttribute("listagem", obterLista());		
		return "hospital/lista";
	}
	
	@GetMapping(value = "/hospital/{id}/excluir")
	public String exclusao(@PathVariable Integer id) {
		
		excluir(id); 		
		return "redirect:/hospital/lista";
	}

}
