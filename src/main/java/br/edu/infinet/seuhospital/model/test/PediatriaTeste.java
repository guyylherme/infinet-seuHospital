package br.edu.infinet.seuhospital.model.test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.edu.infinet.seuhospital.model.controller.PediatriaController;
import br.edu.infinet.seuhospital.model.domain.Pediatria;
import br.edu.infinet.seuhospital.model.exceptions.ValorHoraZeradoException;

@Component
public class PediatriaTeste implements ApplicationRunner {
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println();
		System.out.println("#PediatriaTeste"); 
 		
		String dir = "C:\\Users\\Guylherme\\OneDrive\\Documentos\\Projetos\\Tecnologia Java - Infinet\\seuhospital\\seuhospital\\src\\main\\db_text\\";
		String arq = "pediatras.txt";

		try {

			try {
				FileReader fileReader = new FileReader(dir + arq);
				BufferedReader leitura = new BufferedReader(fileReader);

				String linha = leitura.readLine();
				while (linha != null) {

					try {
						
						String[] campos = linha.split(";");
						
						Pediatria pediatria = new Pediatria();
						pediatria.setCodigo(Integer.valueOf(campos[0]));
						pediatria.setNome(campos[1]);
						pediatria.setStatus(Boolean.valueOf(campos[2]));
						
						pediatria.setApenasBebes(Boolean.valueOf(campos[3]));
						pediatria.setCardiologia(Boolean.valueOf(campos[4]));						
						pediatria.setNeonatologia(Boolean.valueOf(campos[5]));  
						
						pediatria.setValorHora(Float.valueOf(campos[6]));
						pediatria.calcularValorHora();
						
						PediatriaController.incluir(pediatria);
					} catch (ValorHoraZeradoException e) {
						System.out.println("[ERROR - PEDIATRIA] " + e.getMessage());
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
