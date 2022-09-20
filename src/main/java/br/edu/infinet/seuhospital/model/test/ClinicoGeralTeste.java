package br.edu.infinet.seuhospital.model.test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.edu.infinet.seuhospital.model.domain.ClinicoGeral;
import br.edu.infinet.seuhospital.model.exceptions.PeriodoInvalidoException;
import br.edu.infinet.seuhospital.model.service.ClinicoGeralService;

@Component
public class ClinicoGeralTeste implements ApplicationRunner {
	
	@Autowired
	ClinicoGeralService clinicoGeralService;	
	 	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println();
		System.out.println("#ClinicoGeralTeste");
		
		String dir = "C:\\Users\\Guylherme\\OneDrive\\Documentos\\Projetos\\Tecnologia Java - Infinet\\seuhospital\\seuhospital\\src\\main\\db_text\\";
		String arq = "especialidades.txt";
 
		try {

			try {
				FileReader fileReader = new FileReader(dir + arq);
				BufferedReader leitura = new BufferedReader(fileReader);

				String linha = leitura.readLine();
				while (linha != null) {
					
					String[] campos = linha.split(";");
					
					if("C".equalsIgnoreCase(campos[0])) {
						try {  
							ClinicoGeral clinico = new ClinicoGeral();
							clinico.setCodigo(campos[1]);
							clinico.setNome(campos[2]);
							clinico.setStatus(Boolean.valueOf(campos[3]));
							
							clinico.setDescricao(campos[4]);
							clinico.setDiarista(Boolean.valueOf(campos[5]));						
							clinico.setTurno(campos[7]);  
							
							clinico.setValorHora(Float.valueOf(campos[6]));
							clinico.calcularValorHora();
							
							clinicoGeralService.incluir(clinico);
						} catch (PeriodoInvalidoException e) {
							System.out.println("[ERROR - CLINICO GERAL] " + e.getMessage());
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
