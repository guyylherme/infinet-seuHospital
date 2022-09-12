package br.edu.infinet.seuhospital.model.test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.edu.infinet.seuhospital.model.domain.app.Atributo;
import br.edu.infinet.seuhospital.model.domain.app.Classe;
import br.edu.infinet.seuhospital.model.domain.app.Projeto;
import br.edu.infinet.seuhospital.model.service.AppService;

@Component
public class AppTeste implements ApplicationRunner {
	 
	@Autowired
	private AppService appService;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println();
		System.out.println("#AppTeste");

		String dir = "C:\\Users\\Guylherme\\OneDrive\\Documentos\\Projetos\\Tecnologia Java - Infinet\\seuhospital\\seuhospital\\src\\main\\db_text\\";
		String arq = "app.txt";

		try {

			try {
				FileReader fileReader = new FileReader(dir + arq);
				BufferedReader leitura = new BufferedReader(fileReader);
				List<Classe> classes = null;
				List<Atributo> atributos = null;
				Projeto projeto = null;

				String linha = leitura.readLine();
				while (linha != null) {

					String[] campos = linha.split(";");

					switch (campos[0].toUpperCase()) {
					case "P":
						classes = new ArrayList<Classe>();

						projeto = new Projeto();
						projeto.setNome(campos[1]);
						projeto.setDescricao(campos[2]);
						projeto.setClasses(classes);
						
						break;

					case "C":
						atributos = new ArrayList<Atributo>();
						Classe classe = new Classe();
						classe.setNome(campos[1]);
						classe.setAtributos(atributos);
						
						classes.add(classe);
						break; 

					case "A":
						Atributo atributo = new Atributo(campos[1], campos[2], campos[3]);
						 
						atributos.add(atributo);
						break;

					default:
						break;
					}

					linha = leitura.readLine();
				}
				 
				appService.incluir(projeto);

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
