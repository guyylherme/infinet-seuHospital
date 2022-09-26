package br.edu.infinet.seuhospital.model.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import br.edu.infinet.seuhospital.model.domain.Hospital;
import br.edu.infinet.seuhospital.model.domain.Usuario;
import br.edu.infinet.seuhospital.model.service.EnderecoService;
import br.edu.infinet.seuhospital.model.service.EspecialidadeService;
import br.edu.infinet.seuhospital.model.service.HospitalService;

@Controller
public class HospitalController {
	 
	@Autowired
	HospitalService hospitalService;
	
	@Autowired
	EspecialidadeService especialidadeService;
	
	@Autowired
	EnderecoService enderecoService;
	 
	@GetMapping(value = "/hospital/lista")
	public String telaHospital(Model model, @SessionAttribute("user") Usuario usuario) {		   
		model.addAttribute("listagem", hospitalService.obterLista(usuario));		
		return "hospital/lista";
	}
		
	@GetMapping(value = "/hospital/incluir")
	public String telaCadastro(Model model) { 		
		model.addAttribute("enderecos", enderecoService.obterLista());
		model.addAttribute("especialidades", especialidadeService.obterLista());
		
		return "hospital/cadastro";
	}
	
	@PostMapping(value = "/hospital/incluir")
	public String incluir(Hospital hospital, @SessionAttribute("user") Usuario usuario){					
		hospital.setUsuario(usuario);		
		hospitalService.incluir(hospital);		
		return "redirect:/hospital/lista";
	}
	
	
	@GetMapping(value = "/hospital/{id}/excluir")
	public String exclusao(@PathVariable Integer id) {		
		hospitalService.excluir(id); 		
		return "redirect:/hospital/lista";
	}

}
