package br.edu.infinet.seuhospital.model.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PediatriaController {
	 
	@GetMapping(value = "/pediatra/lista")
	public String telaPediatria() {
		return "pediatria/lista";
	}

}
