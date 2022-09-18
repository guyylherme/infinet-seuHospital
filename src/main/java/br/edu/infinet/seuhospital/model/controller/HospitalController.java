package br.edu.infinet.seuhospital.model.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.infinet.seuhospital.model.domain.Hospital;
import br.edu.infinet.seuhospital.model.service.HospitalService;

@Controller
public class HospitalController {
	 
	@Autowired
	HospitalService hospitalService;	
	 
	@GetMapping(value = "/hospital/lista")
	public String telaHospital(Model model) {
		   
		model.addAttribute("listagem", hospitalService.obterLista());		
		return "hospital/lista";
	}
		
	@GetMapping(value = "/hospital/incluir")
	public String telaCadastro() { 
		return "hospital/cadastro";
	}
	
	@PostMapping(value = "/hospital/incluir")
	public String incluir(Hospital hospital){		
		hospitalService.incluir(hospital);	
		
		return "redirect:/hospital/lista";
	}
	
	
	@GetMapping(value = "/hospital/{id}/excluir")
	public String exclusao(@PathVariable Integer id) {
		
		hospitalService.excluir(id); 		
		return "redirect:/hospital/lista";
	}

}
