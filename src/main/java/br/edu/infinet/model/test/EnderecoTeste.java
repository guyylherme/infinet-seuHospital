package br.edu.infinet.model.test;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infinet.model.domain.Endereco;

@Order(2)
@Component
public class EnderecoTeste implements ApplicationRunner {
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println();
		System.out.println("#EnderecoTeste");
		 
 		
 		Endereco endereco1 = new Endereco("Primeira rua", 1, "Rio de Janeiro", "Brasil", "25046-111");
		System.out.println(endereco1);

//		Endereco endereco2 = new Endereco("Segunda rua", 2, "Rio de Janeiro", "Brasil", "25046-222");
//		System.out.println(endereco2);
//
//		Endereco endereco3 = new Endereco("Terceira rua", 3, "Rio de Janeiro", "Brasil", "25046-333");
//		System.out.println(endereco3);
		
	}
	
}