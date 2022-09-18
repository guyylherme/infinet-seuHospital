package br.edu.infinet.seuhospital.model.test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infinet.seuhospital.model.domain.Endereco;
import br.edu.infinet.seuhospital.model.exceptions.RuaNaoPreenchidoException;
import br.edu.infinet.seuhospital.model.service.EnderecoService;

@Order(2)
@Component
public class EnderecoTeste implements ApplicationRunner {
	
	@Autowired
	EnderecoService enderecoService;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println();
		System.out.println("#EnderecoTeste");
		
		
		String dir = "C:\\Users\\Guylherme\\OneDrive\\Documentos\\Projetos\\Tecnologia Java - Infinet\\seuhospital\\seuhospital\\src\\main\\db_text\\";
		String arq = "enderecos.txt";

		try {

			try {
				FileReader fileReader = new FileReader(dir + arq);
				BufferedReader leitura = new BufferedReader(fileReader);

				String linha = leitura.readLine();
				while (linha != null) {

					String[] campos = linha.split(";");

					try {
			 			Endereco endereco1 = new Endereco(campos[0] ,Integer.valueOf(campos[1]), campos[2], campos[3], campos[4]);
			 			enderecoService.incluir(endereco1);
			 			
					} catch (RuaNaoPreenchidoException e) {
						System.out.println("[ERROR] " + e.getMessage());
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