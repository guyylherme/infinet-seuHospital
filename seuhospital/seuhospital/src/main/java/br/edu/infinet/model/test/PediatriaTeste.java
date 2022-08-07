package br.edu.infinet.model.test;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.edu.infinet.model.domain.Pediatria;

@Component
public class PediatriaTeste implements ApplicationRunner {
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println();
		System.out.println("#PediatriaTeste");
		
		Pediatria pediatria = new Pediatria();
		pediatria.setCodigo(02);
		pediatria.setNome("Jessica");
		pediatria.setStatus(false);
		
		pediatria.setApenasBebes(true);
		pediatria.setCardiologia(false);
		pediatria.setNeonatologia(true);
 		System.out.println(pediatria);
		
	}
	
}
