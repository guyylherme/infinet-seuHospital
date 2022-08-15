package br.edu.infinet.model.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DentistaController {
	 
	@GetMapping(value = "/dentista/lista")
	public String telaDentista() {
		return "dentista/lista";
	}

}
