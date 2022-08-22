package br.edu.infinet.seuhospital.model.test;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.edu.infinet.seuhospital.model.controller.ClinicoGeralController;
import br.edu.infinet.seuhospital.model.domain.ClinicoGeral;

@Component
public class ClinicoGeralTeste implements ApplicationRunner {
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println();
		System.out.println("#ClinicoGeralTeste");
		
		ClinicoGeral clinico = new ClinicoGeral();
		clinico.setCodigo(02);
		clinico.setNome("Débora Santos");
		clinico.setStatus(false);
		
		clinico.setDescricao("Responsável por acompanhar problemas de saúde");
		clinico.setDiarista(true);
		clinico.setValorHora(22);
		clinico.setTurno("Noturno"); 
 		
 		ClinicoGeral clinico1 = new ClinicoGeral();
		clinico1.setCodigo(05);
		clinico1.setNome("Marcia Ferreira");
		clinico1.setStatus(false);
		
		clinico1.setDescricao("Responsável XPTOx");
		clinico1.setDiarista(true);
		clinico1.setValorHora(28);
		clinico1.setTurno("Diúrno"); 
 		
 		ClinicoGeral clinico2 = new ClinicoGeral();
		clinico2.setCodigo(01);
		clinico2.setNome("Marcela Andrade");
		clinico2.setStatus(false);
		
		clinico2.setDescricao("Responsável XPTOz");
		clinico2.setDiarista(true);
		clinico2.setValorHora(21);
		clinico2.setTurno("Noturno"); 
		
		ClinicoGeralController.incluir(clinico);
		ClinicoGeralController.incluir(clinico1);
		ClinicoGeralController.incluir(clinico2); 
		  		 
	}
	
}
