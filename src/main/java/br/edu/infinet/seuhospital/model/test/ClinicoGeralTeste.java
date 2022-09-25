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
import br.edu.infinet.seuhospital.model.domain.Usuario;
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
		
		Usuario usuario = new Usuario(); 
		usuario.setId(1);
		
		String dir = "C:\\Users\\Guylherme\\OneDrive\\Documentos\\Projetos\\Tecnologia Java - Infinet\\seuhospital\\seuhospital\\src\\main\\db_text\\";
		String arq = "especialidades.txt";
 
		try {

			try {
				FileReader fileReader = new FileReader(dir + arq);
				BufferedReader leitura = new BufferedReader(fileReader);

				String linha = leitura.readLine();
				while (linha != null) {
					
					String[] campos = linha.split(";");
					
					if("Cc".equalsIgnoreCase(campos[0])) {
						try {  
							ClinicoGeral clinicoGeral = new ClinicoGeral();
							clinicoGeral.setCodigo(campos[1]);
							clinicoGeral.setNome(campos[2]);
							clinicoGeral.setStatus(Boolean.valueOf(campos[3]));
							
							clinicoGeral.setDescricao(campos[4]);
							clinicoGeral.setDiarista(Boolean.valueOf(campos[5]));						
							clinicoGeral.setTurno(campos[7]);  
							
							clinicoGeral.setValorHora(Float.valueOf(campos[6]));
							clinicoGeral.calcularValorHora();
							clinicoGeral.setUsuario(usuario);
							 
							clinicoGeralService.incluir(clinicoGeral);
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
