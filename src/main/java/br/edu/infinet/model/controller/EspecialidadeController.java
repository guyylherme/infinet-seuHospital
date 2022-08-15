package br.edu.infinet.model.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EspecialidadeController {
	 
	@GetMapping(value = "/especialidade/lista")
	public String telaEspecialidade() {
		return "especialidade/lista";
	}

}
