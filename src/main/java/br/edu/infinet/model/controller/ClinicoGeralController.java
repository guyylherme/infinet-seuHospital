package br.edu.infinet.model.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ClinicoGeralController {
	 
	@GetMapping(value = "/clinicoGeral/lista")
	public String telaClinicoGeral() {
		return "clinicoGeral/lista";
	}

}
