package br.edu.infinet.seuhospital.model.test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.edu.infinet.seuhospital.model.domain.Usuario;
import br.edu.infinet.seuhospital.model.service.UsuarioService;

@Component
public class UsuarioTeste implements ApplicationRunner {
	
	@Autowired
	UsuarioService usuarioService;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println();
		System.out.println("#UsuarioTeste");
		 
		
		String dir = "C:\\Users\\Guylherme\\OneDrive\\Documentos\\Projetos\\Tecnologia Java - Infinet\\seuhospital\\seuhospital\\src\\main\\db_text\\";
		String arq = "usuarios.txt";
 
		try {

			try {
				FileReader fileReader = new FileReader(dir + arq);
				BufferedReader leitura = new BufferedReader(fileReader);

				String linha = leitura.readLine();
				while (linha != null) {

					try {
						
						String[] campos = linha.split(";");
						
						Usuario usuario = new Usuario();
						usuario.setId(Integer.valueOf(campos[0]));
						usuario.setNome(campos[1]);
						usuario.setEmail(campos[2]);
						usuario.setSenha(campos[3]);
						  
						usuarioService.incluir(usuario);
						
					} catch (Exception e) {
						System.out.println("[ERROR - USUÁRIO] " + e.getMessage());
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
