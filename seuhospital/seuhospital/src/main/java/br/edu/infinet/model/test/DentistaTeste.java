package br.edu.infinet.model.test;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.edu.infinet.model.domain.Dentista;

@Component 
public class DentistaTeste implements ApplicationRunner {
 
		@Override
		public void run(ApplicationArguments args) throws Exception {
			System.out.println();
			System.out.println("#DentistaTeste");
			
			Dentista dentista = new Dentista();
			dentista.setCodigo(01);
			dentista.setNome("Márcio");
			dentista.setStatus(true);
			
			dentista.setAtendeCrianca(true);
			dentista.setCirurgia(true);
			dentista.setTurno("Diúrno");
	 		System.out.println(dentista);
		
			
		}
		
		 

}
