package br.edu.infinet.seuhospital.model.test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
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
import br.edu.infinet.seuhospital.model.exceptions.EnderecoNuloException;
import br.edu.infinet.seuhospital.model.exceptions.EspecialidadeNulaVaziaException;
import br.edu.infinet.seuhospital.model.exceptions.RuaNaoPreenchidoException;
import br.edu.infinet.seuhospital.model.service.HospitalService;

@Order(1)
@Component
public class HospitalTeste implements ApplicationRunner {
	
	@Autowired
	HospitalService hospitalService;	

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println();
		System.out.println("#HospitalTeste");

		ClinicoGeral clinico = new ClinicoGeral();
		clinico.setCodigo("XPCC2");
		clinico.setNome("Débora");
		clinico.setStatus(false);

		clinico.setDescricao("Responsável por acompanhar problemas de saúde");
		clinico.setDiarista(true);
		clinico.setValorHora(22);
		clinico.setTurno("Noturno");

		Dentista dentista = new Dentista();
		dentista.setCodigo("XPz1");
		dentista.setNome("Márcio");
		dentista.setStatus(true);

		dentista.setAtendeCrianca(true);
		dentista.setCirurgia(true);
		dentista.setValorHora(23);
		dentista.setTurno("Diúrno");

		Pediatria pediatria = new Pediatria();
		pediatria.setCodigo("CPAs3");
		pediatria.setNome("Jessica");
		pediatria.setStatus(false);

		pediatria.setApenasBebes(true);
		pediatria.setCardiologia(true);
		pediatria.setNeonatologia(true);
		pediatria.setValorHora(20);

		String dir = "C:\\Users\\Guylherme\\OneDrive\\Documentos\\Projetos\\Tecnologia Java - Infinet\\seuhospital\\seuhospital\\src\\main\\db_text\\";
		String arq = "hospitais.txt";

		try {

			try {
				FileReader fileReader = new FileReader(dir + arq);
				BufferedReader leitura = new BufferedReader(fileReader);

				String linha = leitura.readLine();
				while (linha != null) {

					try {

						String[] campos = linha.split(";");

						// Criação de uma coleção de produtos
						Set<Especialidade> listaEspecialidadesHospital1 = new HashSet<Especialidade>();

						// Adicionar produtos a coleção
						listaEspecialidadesHospital1.add(clinico);
						listaEspecialidadesHospital1.add(dentista);
						listaEspecialidadesHospital1.add(pediatria);

						Endereco enderecoHospital1 = new Endereco(campos[3], Integer.valueOf(campos[4]), campos[5],campos[6], campos[7]);
						Hospital hospital1 = new Hospital(campos[0], campos[1], campos[2], enderecoHospital1,listaEspecialidadesHospital1);
						hospitalService.incluir(hospital1);

					} catch (EnderecoNuloException | EspecialidadeNulaVaziaException | RuaNaoPreenchidoException e) {
						System.out.println("[ ERROR - HOSPITAL TESTE ] " + e.getMessage());
					}

					linha = leitura.readLine();
				}

				leitura.close();
				fileReader.close();

			} catch (FileNotFoundException e) {
				System.out.println("[ERROR] O arquivo não existe!");
			} catch (IOException e) {
				System.out.println("[ERROR] Problemas no fechamaneto do arquivo!");
			}

		} finally {
			System.out.println("Processo finalizado!");
		}

	}

}
