package br.edu.infinet.seuhospital.model.test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.edu.infinet.seuhospital.model.domain.Dentista;
import br.edu.infinet.seuhospital.model.exceptions.ValorHoraZeradoException;
import br.edu.infinet.seuhospital.model.service.DentistaService;

@Component
public class DentistaTeste implements ApplicationRunner {

	@Autowired
	DentistaService dentistaService;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println();
		System.out.println("#DentistaTeste");

		String dir = "C:\\Users\\Guylherme\\OneDrive\\Documentos\\Projetos\\Tecnologia Java - Infinet\\seuhospital\\seuhospital\\src\\main\\db_text\\";
		String arq = "especialidades.txt";

		try {

			try {
				FileReader fileReader = new FileReader(dir + arq);
				BufferedReader leitura = new BufferedReader(fileReader);

				String linha = leitura.readLine();
				while (linha != null) {
					
					String[] campos = linha.split(";");
					
					if("D".equalsIgnoreCase(campos[0])) {
						try { 
							Dentista dentista = new Dentista();
							dentista.setCodigo(campos[1]);
							dentista.setNome(campos[2]);
							dentista.setStatus(Boolean.valueOf(campos[3]));

							dentista.setAtendeCrianca(Boolean.valueOf(campos[4]));
							dentista.setCirurgia(Boolean.valueOf(campos[5]));
							dentista.setTurno(campos[7]);

							dentista.setValorHora(Float.valueOf(campos[6]));
							dentista.calcularValorHora();

							dentistaService.incluir(dentista);

						} catch (ValorHoraZeradoException e) {
							System.out.println("[ ERROR - DENTISTA ] " + e.getMessage());
						}
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
