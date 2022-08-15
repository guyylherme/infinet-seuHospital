package br.edu.infinet.model.test;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.edu.infinet.model.domain.ClinicoGeral;

@Component
public class ClinicoGeralTeste implements ApplicationRunner {
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println();
		System.out.println("#ClinicoGeralTeste");
		
		ClinicoGeral clinico = new ClinicoGeral();
		clinico.setCodigo(02);
		clinico.setNome("Débora");
		clinico.setStatus(false);
		
		clinico.setDescricao("Responsável por acompanhar problemas de saúde");
		clinico.setDiarista(true);
		clinico.setValorHora(22);
		clinico.setTurno("Noturno");
 		System.out.println(clinico);
 		
 		new SeuHospital("Inclusão do clinico geral teste!!!").relatorio(clinico);; 
		
	}
	
}
