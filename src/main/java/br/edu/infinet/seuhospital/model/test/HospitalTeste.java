package br.edu.infinet.seuhospital.model.test;

import java.util.HashSet;
import java.util.Set;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infinet.seuhospital.model.domain.ClinicoGeral;
import br.edu.infinet.seuhospital.model.domain.Dentista;
import br.edu.infinet.seuhospital.model.domain.Endereco;
import br.edu.infinet.seuhospital.model.domain.Especialidade;
import br.edu.infinet.seuhospital.model.domain.Hospital;
import br.edu.infinet.seuhospital.model.domain.Pediatria;

@Order(1)
@Component
public class HospitalTeste implements ApplicationRunner {
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println();
		System.out.println("#HospitalTeste");
		
		ClinicoGeral clinico = new ClinicoGeral();
		clinico.setCodigo(02);
		clinico.setNome("Débora");
		clinico.setStatus(false);
		
		clinico.setDescricao("Responsável por acompanhar problemas de saúde");
		clinico.setDiarista(true);
		clinico.setValorHora(22);
		clinico.setTurno("Noturno");
		
		Dentista dentista = new Dentista();
		dentista.setCodigo(01);
		dentista.setNome("Márcio");
		dentista.setStatus(true);
		
		dentista.setAtendeCrianca(true);
		dentista.setCirurgia(true);
		dentista.setValorHora(23);
		dentista.setTurno("Diúrno");
 		//System.out.println(dentista);
 		
 		Pediatria pediatria = new Pediatria();
		pediatria.setCodigo(03);
		pediatria.setNome("Jessica");
		pediatria.setStatus(false);
		
		pediatria.setApenasBebes(true);
		pediatria.setCardiologia(true);
		pediatria.setNeonatologia(true);
		pediatria.setValorHora(20);
 		//System.out.println(pediatria);
		 
 		//Criação de uma coleção de produtos
 		Set<Especialidade> listaEspecialidadesHospital1 = new HashSet<Especialidade>();
 		
 		//Adicionar produtos a coleção
 		listaEspecialidadesHospital1.add(clinico);
 		listaEspecialidadesHospital1.add(dentista);
 		listaEspecialidadesHospital1.add(pediatria);
 		
 		
 		Hospital hospital1 = new Hospital("Hospital Central do Rio", "60.151.516/0001-69", "É o estabelecimento de saúde destinado a prestar assistência médico-sanitária a população do Rio de Janeiro.");
		hospital1.setEndereco(new Endereco("Primeira rua", 1, "Rio de Janeiro", "Brasil", "25046-111"));
		hospital1.setEspecialidades(listaEspecialidadesHospital1);
 		System.out.println(hospital1);
 
	}
	
}
