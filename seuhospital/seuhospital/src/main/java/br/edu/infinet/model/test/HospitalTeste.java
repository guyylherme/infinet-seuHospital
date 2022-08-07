package br.edu.infinet.model.test;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infinet.model.domain.Hospital;

@Order(1)
@Component
public class HospitalTeste implements ApplicationRunner {
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println();
		System.out.println("#HospitalTeste");
		 
 		
 		Hospital hospital1 = new Hospital("Hospital Central do Rio", "60.151.516/0001-69", "É o estabelecimento de saúde destinado a prestar assistência médico-sanitária a população do Rio de Janeiro.");
		System.out.println(hospital1);
 
	}
	
}
