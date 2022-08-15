package br.edu.infinet.model.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EnderecoController {
	 
	@GetMapping(value = "/endereco/lista")
	public String telaEndereco() {
		return "endereco/lista";
	}

}
